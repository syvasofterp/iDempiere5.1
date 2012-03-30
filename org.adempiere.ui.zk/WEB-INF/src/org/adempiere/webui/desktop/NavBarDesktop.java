/******************************************************************************
 * Copyright (C) 2008 Low Heng Sin                                            *
 * Copyright (C) 2008 Idalica Corporation                                     *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 *****************************************************************************/
package org.adempiere.webui.desktop;

import java.io.Serializable;
import java.util.Properties;

import org.adempiere.util.ServerContext;
import org.adempiere.webui.apps.BusyDialog;
import org.adempiere.webui.apps.ProcessDialog;
import org.adempiere.webui.component.Accordion;
import org.adempiere.webui.component.Tabpanel;
import org.adempiere.webui.component.ToolBarButton;
import org.adempiere.webui.dashboard.DPActivities;
import org.adempiere.webui.dashboard.DPFavourites;
import org.adempiere.webui.dashboard.DashboardPanel;
import org.adempiere.webui.event.MenuListener;
import org.adempiere.webui.panel.ADForm;
import org.adempiere.webui.panel.HeaderPanel;
import org.adempiere.webui.panel.SidePanel;
import org.adempiere.webui.session.SessionContextListener;
import org.adempiere.webui.session.SessionManager;
import org.adempiere.webui.util.IServerPushCallback;
import org.adempiere.webui.util.ServerPushTemplate;
import org.adempiere.webui.util.UserPreference;
import org.adempiere.webui.window.ADWindow;
import org.compiere.util.CLogger;
import org.compiere.util.Env;
import org.compiere.util.Msg;
import org.zkoss.zk.au.out.AuScript;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.event.DropEvent;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.OpenEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Center;
import org.zkoss.zul.North;
import org.zkoss.zul.West;
import org.zkoss.zul.Div;
import org.zkoss.zul.Treeitem;
import org.zkoss.zul.Treerow;

/**
 * @author hengsin
 */
public class NavBarDesktop extends TabbedDesktop implements MenuListener, Serializable, EventListener<Event>, IServerPushCallback
{

	private static final long serialVersionUID = 4721048271543882164L;

	private static final String FAVOURITES_PATH = "/zul/favourites.zul";

	private static final String ACTIVITIES_PATH = "/zul/activities.zul";

	private static final String VIEWS_PATH = "/zul/views.zul";

	@SuppressWarnings("unused")
	private static final CLogger logger = CLogger.getCLogger(DefaultDesktop.class);

    private Center windowArea;

	private Borderlayout layout;

	private Accordion navigationPanel;

	private West leftRegion;

	private DPFavourites favPanel;

	private int noOfNotice;

	private int noOfRequest;

	private int noOfWorkflow;

	private Tabpanel homeTab;

	private DashboardController dashboardController;

    public NavBarDesktop()
    {
    	super();
    	dashboardController = new DashboardController();
    }

    protected Component doCreatePart(Component parent)
    {
    	SidePanel pnlSide = new SidePanel();
    	HeaderPanel pnlHead = new HeaderPanel();

        pnlSide.getMenuPanel().addMenuListener(this);

        layout = new Borderlayout();
        if (parent != null)
        {
        	layout.setParent(parent);
        	layout.setWidth("100%");
        	layout.setHeight("100%");
        	layout.setStyle("position: absolute");
        }
        else
        	layout.setPage(page);

        North n = new North();
        layout.appendChild(n);
        n.setCollapsible(false);
        pnlHead.setParent(n);

        leftRegion = new West();
        layout.appendChild(leftRegion);
        leftRegion.setWidth("300px");
        leftRegion.setCollapsible(true);
        leftRegion.setSplittable(true);
        leftRegion.setTitle("Navigation");
        leftRegion.setFlex(true);
        leftRegion.addEventListener(Events.ON_OPEN, new EventListener<Event>() {			
			@Override
			public void onEvent(Event event) throws Exception {
				OpenEvent oe = (OpenEvent) event;
				UserPreference pref = SessionManager.getSessionApplication().getUserPreference();
				pref.setProperty(UserPreference.P_MENU_COLLAPSED, !oe.isOpen());
				pref.savePreference();
			}
		});
        UserPreference pref = SessionManager.getSessionApplication().getUserPreference();
        boolean menuCollapsed= pref.isPropertyBool(UserPreference.P_MENU_COLLAPSED);
        leftRegion.setOpen(!menuCollapsed);
        navigationPanel = new Accordion();
        navigationPanel.setParent(leftRegion);

        navigationPanel.setWidth("100%");
        navigationPanel.setHeight("100%");
        navigationPanel.add(pnlSide, "Application Menu");

        Div div = new Div();
        favPanel = (DPFavourites) Executions.createComponents(FAVOURITES_PATH, div, null);
        navigationPanel.add(div, "Favourites");

        //setup drag and drop for favourites
        div = navigationPanel.getHeader(1);
        div.setDroppable(DPFavourites.FAVOURITE_DROPPABLE);
        div.addEventListener(Events.ON_DROP, this);

        div = new Div();
        Component component = Executions.createComponents(ACTIVITIES_PATH, div, null);
        if (component instanceof DashboardPanel)
    	{
        	DashboardPanel dashboardPanel = (DashboardPanel) component;
        	dashboardController.addDashboardPanel(dashboardPanel);
    	}
        navigationPanel.add(div, "Activities");

        div = new Div();
        Executions.createComponents(VIEWS_PATH, div, null);
        navigationPanel.add(div, Msg.getMsg(Env.getCtx(), "View").replaceAll("&", ""));

        navigationPanel.setSelectedIndex(0);

        windowArea = new Center();
        windowArea.setParent(layout);
        windowArea.setFlex(true);

        windowContainer.createPart(windowArea);

        homeTab = new Tabpanel();
        windowContainer.addWindow(homeTab, Msg.getMsg(Env.getCtx(), "Home").replaceAll("&", ""), false);
        BusyDialog busyDialog = new BusyDialog();
        busyDialog.setShadow(false);
        homeTab.appendChild(busyDialog);
        
        if (!layout.getDesktop().isServerPushEnabled())
    	{
    		layout.getDesktop().enableServerPush(true);
    	}
        
        Runnable runnable = new Runnable() {			
			public void run() {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}

				IServerPushCallback callback = new IServerPushCallback() {					
					public void updateUI() {
						Properties ctx = (Properties)layout.getDesktop().getSession().getAttribute(SessionContextListener.SESSION_CTX);
						try {
							ServerContext.setCurrentInstance(ctx);
							renderHomeTab();
						} finally {
							ServerContext.dispose();
						}
					}
				};
				ServerPushTemplate template = new ServerPushTemplate(layout.getDesktop());
				template.execute(callback);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();

        return layout;
    }

	private void renderHomeTab()
	{
		homeTab.getChildren().clear();

		//register as 0
        registerWindow(homeTab);
        
		dashboardController.render(homeTab, this);		
	}

    public void onEvent(Event event)
    {
        Component comp = event.getTarget();
        String eventName = event.getName();

        if(eventName.equals(Events.ON_CLICK))
        {
            if(comp instanceof ToolBarButton)
            {
            	ToolBarButton btn = (ToolBarButton) comp;

            	int menuId = 0;
            	try
            	{
            		menuId = Integer.valueOf(btn.getName());
            	}
            	catch (Exception e) {

				}

            	if(menuId > 0) onMenuSelected(menuId);
            }
        }
        else if(eventName.equals(Events.ON_DROP))
        {
        	DropEvent de = (DropEvent) event;
    		Component dragged = de.getDragged();

    		if(dragged instanceof Treerow)
    		{
    			Treerow treerow = (Treerow) dragged;
    			Treeitem treeitem = (Treeitem) treerow.getParent();

    			favPanel.addItem(treeitem);
    		}
        }
    }

    public void onServerPush(ServerPushTemplate template)
	{
    	noOfNotice = DPActivities.getNoticeCount();
    	noOfRequest = DPActivities.getRequestCount();
    	noOfWorkflow = DPActivities.getWorkflowCount();

    	template.execute(this);
	}

	/**
	 *
	 * @param page
	 */
	public void setPage(Page page) {
		if (this.page != page) {
			layout.setPage(page);
			this.page = page;
		}
		
		if (dashboardController != null) {
			dashboardController.onSetPage(page, layout.getDesktop(), this);
		}
	}

	/**
	 * Get the root component
	 * @return Component
	 */
	public Component getComponent() {
		return layout;
	}

	public void logout() {
		if (dashboardController != null) {
			dashboardController.onLogOut();
		}	
	}

	public void updateUI() {
		int total = noOfNotice + noOfRequest + noOfWorkflow;
    	navigationPanel.setLabel(2, "Activities (" + total + ")");
    	navigationPanel.setTooltiptext(2, Msg.translate(Env.getCtx(), "AD_Note_ID") + " : " + noOfNotice
    			+ ", " + Msg.translate(Env.getCtx(), "R_Request_ID") + " : " + noOfRequest
    			+ ", " + Msg.getMsg (Env.getCtx(), "WorkflowActivities") + " : " + noOfWorkflow);
	}
	
	private void autoHideMenu() {
		if (layout.getWest().isCollapsible() && !layout.getWest().isOpen())
		{
			//using undocumented js api, need to be retested after every version upgrade
			String id = layout.getWest().getUuid() + "!real";
			String btn = layout.getWest().getUuid() + "!btn";
			String script = "zk.show('" + id + "', false);";
			script += "$e('"+id+"')._isSlide = false;";
			script += "$e('"+id+"')._lastSize = null;";
			script += "$e('"+btn+"').style.display = '';";
			AuScript aus = new AuScript(layout.getWest(), script);
			Clients.response("autoHideWest", aus);
		}
	}

	@Override
	public ADWindow openWindow(int windowId) {
		autoHideMenu();
		return super.openWindow(windowId);
	}

	@Override
	public ADForm openForm(int formId) {
		autoHideMenu();
		return super.openForm(formId);
	}

	@Override
	public ProcessDialog openProcessDialog(int processId, boolean soTrx) {
		autoHideMenu();
		return super.openProcessDialog(processId, soTrx);
	}

	@Override
	public void openTask(int taskId) {
		autoHideMenu();
		super.openTask(taskId);
	}

	@Override
	public void openWorkflow(int workflowID) {
		autoHideMenu();
		super.openWorkflow(workflowID);
	}
}
