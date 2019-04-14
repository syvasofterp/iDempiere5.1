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
package org.syvasoft.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for FL_IllegalIPAccess
 *  @author iDempiere (generated) 
 *  @version Release 5.1 - $Id$ */
public class X_FL_IllegalIPAccess extends PO implements I_FL_IllegalIPAccess, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20190414L;

    /** Standard Constructor */
    public X_FL_IllegalIPAccess (Properties ctx, int FL_IllegalIPAccess_ID, String trxName)
    {
      super (ctx, FL_IllegalIPAccess_ID, trxName);
      /** if (FL_IllegalIPAccess_ID == 0)
        {
			setFL_IllegalIPAccess_ID (0);
			setIPAddress (null);
        } */
    }

    /** Load Constructor */
    public X_FL_IllegalIPAccess (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_FL_IllegalIPAccess[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_AD_Role getAD_Role() throws RuntimeException
    {
		return (org.compiere.model.I_AD_Role)MTable.get(getCtx(), org.compiere.model.I_AD_Role.Table_Name)
			.getPO(getAD_Role_ID(), get_TrxName());	}

	/** Set Role.
		@param AD_Role_ID 
		Responsibility Role
	  */
	public void setAD_Role_ID (int AD_Role_ID)
	{
		if (AD_Role_ID < 0) 
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_Role_ID, Integer.valueOf(AD_Role_ID));
	}

	/** Get Role.
		@return Responsibility Role
	  */
	public int getAD_Role_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_Role_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set User/Contact.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set FL_IllegalIPAccess.
		@param FL_IllegalIPAccess_ID FL_IllegalIPAccess	  */
	public void setFL_IllegalIPAccess_ID (int FL_IllegalIPAccess_ID)
	{
		if (FL_IllegalIPAccess_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_FL_IllegalIPAccess_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_FL_IllegalIPAccess_ID, Integer.valueOf(FL_IllegalIPAccess_ID));
	}

	/** Get FL_IllegalIPAccess.
		@return FL_IllegalIPAccess	  */
	public int getFL_IllegalIPAccess_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_FL_IllegalIPAccess_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set FL_IllegalIPAccess_UU.
		@param FL_IllegalIPAccess_UU FL_IllegalIPAccess_UU	  */
	public void setFL_IllegalIPAccess_UU (String FL_IllegalIPAccess_UU)
	{
		set_ValueNoCheck (COLUMNNAME_FL_IllegalIPAccess_UU, FL_IllegalIPAccess_UU);
	}

	/** Get FL_IllegalIPAccess_UU.
		@return FL_IllegalIPAccess_UU	  */
	public String getFL_IllegalIPAccess_UU () 
	{
		return (String)get_Value(COLUMNNAME_FL_IllegalIPAccess_UU);
	}

	/** Set IP Address.
		@param IPAddress IP Address	  */
	public void setIPAddress (String IPAddress)
	{
		set_Value (COLUMNNAME_IPAddress, IPAddress);
	}

	/** Get IP Address.
		@return IP Address	  */
	public String getIPAddress () 
	{
		return (String)get_Value(COLUMNNAME_IPAddress);
	}
}