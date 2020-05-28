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

/** Generated Model for TF_ImportQueue
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_TF_ImportQueue extends PO implements I_TF_ImportQueue, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200528L;

    /** Standard Constructor */
    public X_TF_ImportQueue (Properties ctx, int TF_ImportQueue_ID, String trxName)
    {
      super (ctx, TF_ImportQueue_ID, trxName);
      /** if (TF_ImportQueue_ID == 0)
        {
			setIsError (false);
			setissync (false);
			setMessage (null);
			setTF_ImportQueue_ID (0);
        } */
    }

    /** Load Constructor */
    public X_TF_ImportQueue (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
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
      StringBuffer sb = new StringBuffer ("X_TF_ImportQueue[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Table getAD_Table() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Table)MTable.get(getCtx(), org.compiere.model.I_AD_Table.Table_Name)
			.getPO(getAD_Table_ID(), get_TrxName());	}

	/** Set Table.
		@param AD_Table_ID 
		Database Table information
	  */
	public void setAD_Table_ID (int AD_Table_ID)
	{
		if (AD_Table_ID < 1) 
			set_Value (COLUMNNAME_AD_Table_ID, null);
		else 
			set_Value (COLUMNNAME_AD_Table_ID, Integer.valueOf(AD_Table_ID));
	}

	/** Get Table.
		@return Database Table information
	  */
	public int getAD_Table_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Table_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Error.
		@param IsError 
		An Error occurred in the execution
	  */
	public void setIsError (boolean IsError)
	{
		set_Value (COLUMNNAME_IsError, Boolean.valueOf(IsError));
	}

	/** Get Error.
		@return An Error occurred in the execution
	  */
	public boolean isError () 
	{
		Object oo = get_Value(COLUMNNAME_IsError);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sync.
		@param issync Sync	  */
	public void setissync (boolean issync)
	{
		set_Value (COLUMNNAME_issync, Boolean.valueOf(issync));
	}

	/** Get Sync.
		@return Sync	  */
	public boolean issync () 
	{
		Object oo = get_Value(COLUMNNAME_issync);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Log.
		@param Log Log	  */
	public void setLog (String Log)
	{
		set_Value (COLUMNNAME_Log, Log);
	}

	/** Get Log.
		@return Log	  */
	public String getLog () 
	{
		return (String)get_Value(COLUMNNAME_Log);
	}

	/** Set Message.
		@param Message 
		EMail Message
	  */
	public void setMessage (String Message)
	{
		set_Value (COLUMNNAME_Message, Message);
	}

	/** Get Message.
		@return EMail Message
	  */
	public String getMessage () 
	{
		return (String)get_Value(COLUMNNAME_Message);
	}

	/** Set Record ID.
		@param Record_ID 
		Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID)
	{
		if (Record_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_Record_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Record_ID, Integer.valueOf(Record_ID));
	}

	/** Get Record ID.
		@return Direct internal record ID
	  */
	public int getRecord_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Record_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Import Queue.
		@param TF_ImportQueue_ID Import Queue	  */
	public void setTF_ImportQueue_ID (int TF_ImportQueue_ID)
	{
		if (TF_ImportQueue_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_TF_ImportQueue_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_TF_ImportQueue_ID, Integer.valueOf(TF_ImportQueue_ID));
	}

	/** Get Import Queue.
		@return Import Queue	  */
	public int getTF_ImportQueue_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_TF_ImportQueue_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set TF_ImportQueue_UU.
		@param TF_ImportQueue_UU TF_ImportQueue_UU	  */
	public void setTF_ImportQueue_UU (String TF_ImportQueue_UU)
	{
		set_ValueNoCheck (COLUMNNAME_TF_ImportQueue_UU, TF_ImportQueue_UU);
	}

	/** Get TF_ImportQueue_UU.
		@return TF_ImportQueue_UU	  */
	public String getTF_ImportQueue_UU () 
	{
		return (String)get_Value(COLUMNNAME_TF_ImportQueue_UU);
	}
}