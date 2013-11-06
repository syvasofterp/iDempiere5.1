/******************************************************************************
 * Copyright (C) 2009 Low Heng Sin                                            *
 * Copyright (C) 2009 Idalica Corporation                                     *
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
package org.compiere.grid;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;

import org.compiere.apps.IStatusBar;
import org.compiere.minigrid.IMiniTable;
import org.compiere.model.GridTab;
import org.compiere.model.MRMA;
import org.compiere.model.MRMALine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.compiere.util.Msg;

/**
 *  Create Transactions for RMA
 * @author ashley
 * @author Teo Sarca, www.arhipac.ro
 * 			<li>BF [ 2007837 ] VCreateFrom.save() should run in trx
 */
public abstract class CreateFromRMA extends CreateFrom {

	public CreateFromRMA(GridTab mTab)
	{
		super(mTab);
		if (log.isLoggable(Level.INFO)) log.info(mTab.toString());
	}
	
	@Override
	public boolean dynInit() throws Exception 
	{
		log.config("");
		
		boolean isSOTrx = true;
		String value = Env.getContext(Env.getCtx(), getGridTab().getWindowNo(), MRMA.COLUMNNAME_IsSOTrx);
		if (value != null && value.equalsIgnoreCase("N"))
			isSOTrx = false;
        setTitle(isSOTrx ? "Customer" : "Vendor" + " RMA - Create Lines From");

		return true;
	}
	
	protected Vector<Vector<Object>> getRMAData()
	{
		int M_InOut_ID = Env.getContextAsInt(Env.getCtx(), getGridTab().getWindowNo(), "InOut_ID");
		int M_RMA_ID = Env.getContextAsInt(Env.getCtx(), getGridTab().getWindowNo(), "M_RMA_ID");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		/**
         * 1 M_InOutLine_ID
         * 2 Line
         * 3 Product Name
         * 4 Qty Entered
         * 5 Movement Qty
         * 6 ASI
         */
        StringBuilder sqlStmt = new StringBuilder();
        
        sqlStmt.append("SELECT iol.M_InOutLine_ID, iol.Line, "); 
        sqlStmt.append("COALESCE(p.Name, c.Name) AS ProductName, "); 
        sqlStmt.append("iol.QtyEntered, "); 
        sqlStmt.append("iol.movementQty, "); 
        sqlStmt.append("CASE WHEN iol.M_AttributeSetInstance_ID IS NOT NULL THEN (SELECT SerNo FROM M_AttributeSetInstance asi WHERE asi.M_AttributeSetInstance_ID=iol.M_AttributeSetInstance_ID) END as ASI ");
        sqlStmt.append("FROM M_InOutLine iol ");
        sqlStmt.append("LEFT JOIN M_Product p ON p.M_Product_ID = iol.M_Product_ID ");
        sqlStmt.append("LEFT JOIN C_Charge c ON c.C_Charge_ID = iol.C_Charge_ID ");
        sqlStmt.append("WHERE M_InOut_ID=? ");
        sqlStmt.append("AND iol.M_InOutLine_ID NOT IN (SELECT rmal.M_InOutLine_ID FROM M_RMALine rmal WHERE rmal.M_RMA_ID=?)");
        
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try
        {
            pstmt = DB.prepareStatement(sqlStmt.toString(), null);
            pstmt.setInt(1, M_InOut_ID);
            pstmt.setInt(2, M_RMA_ID);
            rs = pstmt.executeQuery();
            while (rs.next())
            {
                Vector<Object> line = new Vector<Object>(7);
                line.add(new Boolean(false));           //  0-Selection
                
                KeyNamePair lineKNPair = new KeyNamePair(rs.getInt(1), rs.getString(2)); // 1-Line
                line.add(lineKNPair);
                line.add(rs.getString(3)); //2-Product
                line.add(rs.getString(6)); //3-ASI
                
                BigDecimal qtyEntered = rs.getBigDecimal(4); 
                BigDecimal movementQty = rs.getBigDecimal(5);
                
                line.add(qtyEntered);  //4-Qty
                line.add(movementQty); //5-Movement Qty
                
                
                data.add(line);
            }
        }
        catch (SQLException e)
        {
            log.log(Level.SEVERE, sqlStmt.toString(), e);
        }
        finally
        {
        	DB.close(rs, pstmt);
        	rs = null;
        	pstmt = null;
        }
        
        return data;
	}

	@Override
	public void info(IMiniTable miniTable, IStatusBar statusBar) 
	{

	}
	
	protected void configureMiniTable (IMiniTable miniTable)
	{
		miniTable.setColumnClass(0, Boolean.class, false);      //  0-Selection
		miniTable.setColumnClass(1, String.class, true);        //  1-Line
		miniTable.setColumnClass(2, String.class, true);        //  2-Product 
		miniTable.setColumnClass(3, String.class, true);        //  3-ASI
		miniTable.setColumnClass(4, BigDecimal.class, true);        //  4-Qty
		miniTable.setColumnClass(5, BigDecimal.class, true);        //  5-Delivered Qty
        
        //  Table UI
		miniTable.autoSize();
	}

	@Override
	public boolean save(IMiniTable miniTable, String trxName) 
	{
		log.config("");
		int M_RMA_ID = Env.getContextAsInt(Env.getCtx(), getGridTab().getWindowNo(), "M_RMA_ID");
        
//        Integer bpId = (Integer)bPartnerField.getValue();
        MRMA rma = new MRMA(Env.getCtx(), M_RMA_ID, trxName);
        //update BP
//        rma.setC_BPartner_ID(bpId);
        
        for (int i = 0; i < miniTable.getRowCount(); i++)
        {
            if (((Boolean)miniTable.getValueAt(i, 0)).booleanValue())
            {
                BigDecimal d = (BigDecimal)miniTable.getValueAt(i, 5);              //  5-Movement Qty
                KeyNamePair pp = (KeyNamePair)miniTable.getValueAt(i, 1);   //  1-Line
                
                int inOutLineId = pp.getKey();
                
                MRMALine rmaLine = new MRMALine(rma.getCtx(), 0, rma.get_TrxName());
                rmaLine.setM_RMA_ID(M_RMA_ID);
                rmaLine.setM_InOutLine_ID(inOutLineId);
                rmaLine.setQty(d);
                rmaLine.setAD_Org_ID(rma.getAD_Org_ID());
                if (!rmaLine.save())
                {
                    throw new IllegalStateException("Could not create RMA Line");
                }
            }
        }
        rma.saveEx();
        return true;
	}
	
	protected Vector<String> getOISColumnNames()
	{
		//  Header Info
        Vector<String> columnNames = new Vector<String>(7);
        columnNames.add(Msg.getMsg(Env.getCtx(), "Select"));
        columnNames.add("Line");
        columnNames.add(Msg.translate(Env.getCtx(), "M_Product_ID"));
        columnNames.add("ASI");
        columnNames.add(Msg.translate(Env.getCtx(), "Quantity"));
        columnNames.add(Msg.getElement(Env.getCtx(), "QtyDelivered", false));
	    
	    return columnNames;
	}
}
