/******************************************************************************
 * Product: Posterita Ajax UI 												  *
 * Copyright (C) 2007 Posterita Ltd.  All Rights Reserved.                    *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Posterita Ltd., 3, Draper Avenue, Quatre Bornes, Mauritius                 *
 * or via info@posterita.org or http://www.posterita.org/                     *
 *****************************************************************************/

package org.adempiere.webui.editor;

import org.adempiere.webui.ValuePreference;
import org.adempiere.webui.component.Textbox;
import org.adempiere.webui.event.ContextMenuEvent;
import org.adempiere.webui.event.ContextMenuListener;
import org.adempiere.webui.event.ValueChangeEvent;
import org.compiere.model.GridField;
import org.compiere.model.MRole;
import org.compiere.util.DisplayType;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.Events;

/**
 *
 * @author  <a href="mailto:agramdass@gmail.com">Ashley G Ramdass</a>
 * @date    Mar 11, 2007
 * @version $Revision: 0.10 $
 */
public class WStringEditor extends WEditor implements ContextMenuListener
{
    private static final String[] LISTENER_EVENTS = {Events.ON_CHANGE};
    
    private String oldText;
    
    private WEditorPopupMenu	popupMenu;
    
    
    public WStringEditor(GridField gridField)
    {
        super(new Textbox(), gridField);
        
        init();
    }
    
    @Override
    public Textbox getComponent() {
    	return (Textbox) component;
    }
            
    @Override
	public boolean isReadWrite() {
		return !getComponent().isReadonly();
	}

	@Override
	public void setReadWrite(boolean readWrite) {
		getComponent().setReadonly(!readWrite);
	}
	
	private void init()
    {
        getComponent().setMaxlength(gridField.getFieldLength());
        int displayLength = gridField.getDisplayLength();
        if (displayLength <= 0 || displayLength > MAX_DISPLAY_LENGTH)
        {
            displayLength = MAX_DISPLAY_LENGTH;
        }
        getComponent().setCols(displayLength);    
        
        if (gridField.getDisplayType() == DisplayType.Text)
        {
            getComponent().setMultiline(true);
            getComponent().setRows(3);
        }
        else if (gridField.getDisplayType() == DisplayType.TextLong)
        {
            getComponent().setMultiline(true);
            getComponent().setRows(5);
        }
        else if (gridField.getDisplayType() == DisplayType.Memo)
        {
            getComponent().setMultiline(true);
            getComponent().setRows(8);
        }
        
        popupMenu = new WEditorPopupMenu(false, false, true);
    }

    public void onEvent(Event event)
    {
        String newText = getComponent().getValue();
        ValueChangeEvent changeEvent = new ValueChangeEvent(this, this.getColumnName(), oldText, newText);
        super.fireValueChange(changeEvent);
        oldText = newText;
    }

    @Override
    public String getDisplay()
    {
        return getComponent().getValue();
    }

    @Override
    public Object getValue()
    {
        return getComponent().getValue();
    }

    @Override
    public void setValue(Object value)
    {
        if (value != null)
        {
            getComponent().setValue(value.toString());
        }
        else
        {
            getComponent().setValue("");
        }
        oldText = getComponent().getValue();
    }
    
    protected void setTypePassword(boolean password)
    {
        if (password)
        {
            getComponent().setType("password");
        }
        else
        {
            getComponent().setType("text");
        }
    }
    
    @Override
    public String[] getEvents()
    {
        return LISTENER_EVENTS;
    }
    
    public WEditorPopupMenu getPopupMenu()
	{
	   	return popupMenu;
	}
    
    public void onMenu(ContextMenuEvent evt) 
	{
		if (WEditorPopupMenu.PREFERENCE_EVENT.equals(evt.getContextEvent()))
		{
			if (MRole.getDefault().isShowPreference())
				ValuePreference.start (this.getGridField(), getValue());
			return;
		}
	}
}
