/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
/** Generated Model - DO NOT CHANGE */
package org.adempiere.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for AD_ExportQueue
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_AD_ExportQueue extends PO implements I_AD_ExportQueue, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20230226L;

    /** Standard Constructor */
    public X_AD_ExportQueue (Properties ctx, int AD_ExportQueue_ID, String trxName)
    {
      super (ctx, AD_ExportQueue_ID, trxName);
      /** if (AD_ExportQueue_ID == 0)
        {
			setAD_ExportQueue_ID (0);
			setProcessed (false);
// N
        } */
    }

    /** Load Constructor */
    public X_AD_ExportQueue (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 7 - System - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_AD_ExportQueue[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Export Queue.
		@param AD_ExportQueue_ID Export Queue	  */
	public void setAD_ExportQueue_ID (int AD_ExportQueue_ID)
	{
		if (AD_ExportQueue_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_ExportQueue_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_ExportQueue_ID, Integer.valueOf(AD_ExportQueue_ID));
	}

	/** Get Export Queue.
		@return Export Queue	  */
	public int getAD_ExportQueue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_ExportQueue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AD_ExportQueue_UU.
		@param AD_ExportQueue_UU AD_ExportQueue_UU	  */
	public void setAD_ExportQueue_UU (String AD_ExportQueue_UU)
	{
		set_ValueNoCheck (COLUMNNAME_AD_ExportQueue_UU, AD_ExportQueue_UU);
	}

	/** Get AD_ExportQueue_UU.
		@return AD_ExportQueue_UU	  */
	public String getAD_ExportQueue_UU () 
	{
		return (String)get_Value(COLUMNNAME_AD_ExportQueue_UU);
	}

	/** Set Message Text.
		@param MsgText 
		Textual Informational, Menu or Error Message
	  */
	public void setMsgText (String MsgText)
	{
		set_Value (COLUMNNAME_MsgText, MsgText);
	}

	/** Get Message Text.
		@return Textual Informational, Menu or Error Message
	  */
	public String getMsgText () 
	{
		return (String)get_Value(COLUMNNAME_MsgText);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}
}