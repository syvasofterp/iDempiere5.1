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
package org.compiere.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.util.KeyNamePair;

/** Generated Interface for CM_CStageTTable
 *  @author iDempiere (generated) 
 *  @version Release 2.0
 */
public interface I_CM_CStageTTable 
{

    /** TableName=CM_CStageTTable */
    public static final String Table_Name = "CM_CStageTTable";

    /** AD_Table_ID=881 */
    public static final int Table_ID = 881;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 6 - System - Client 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(6);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name CM_CStage_ID */
    public static final String COLUMNNAME_CM_CStage_ID = "CM_CStage_ID";

	/** Set Web Container Stage.
	  * Web Container Stage contains the staging content like images, text etc.
	  */
	public void setCM_CStage_ID (int CM_CStage_ID);

	/** Get Web Container Stage.
	  * Web Container Stage contains the staging content like images, text etc.
	  */
	public int getCM_CStage_ID();

	public org.compiere.model.I_CM_CStage getCM_CStage() throws RuntimeException;

    /** Column name CM_CStageTTable_ID */
    public static final String COLUMNNAME_CM_CStageTTable_ID = "CM_CStageTTable_ID";

	/** Set Stage T.Table.
	  * Container Stage Template Table
	  */
	public void setCM_CStageTTable_ID (int CM_CStageTTable_ID);

	/** Get Stage T.Table.
	  * Container Stage Template Table
	  */
	public int getCM_CStageTTable_ID();

    /** Column name CM_CStageTTable_UU */
    public static final String COLUMNNAME_CM_CStageTTable_UU = "CM_CStageTTable_UU";

	/** Set CM_CStageTTable_UU	  */
	public void setCM_CStageTTable_UU (String CM_CStageTTable_UU);

	/** Get CM_CStageTTable_UU	  */
	public String getCM_CStageTTable_UU();

    /** Column name CM_TemplateTable_ID */
    public static final String COLUMNNAME_CM_TemplateTable_ID = "CM_TemplateTable_ID";

	/** Set Template Table.
	  * CM Template Table Link
	  */
	public void setCM_TemplateTable_ID (int CM_TemplateTable_ID);

	/** Get Template Table.
	  * CM Template Table Link
	  */
	public int getCM_TemplateTable_ID();

	public org.compiere.model.I_CM_TemplateTable getCM_TemplateTable() throws RuntimeException;

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name OtherClause */
    public static final String COLUMNNAME_OtherClause = "OtherClause";

	/** Set Other SQL Clause.
	  * Other SQL Clause
	  */
	public void setOtherClause (String OtherClause);

	/** Get Other SQL Clause.
	  * Other SQL Clause
	  */
	public String getOtherClause();

    /** Column name Record_ID */
    public static final String COLUMNNAME_Record_ID = "Record_ID";

	/** Set Record ID.
	  * Direct internal record ID
	  */
	public void setRecord_ID (int Record_ID);

	/** Get Record ID.
	  * Direct internal record ID
	  */
	public int getRecord_ID();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name WhereClause */
    public static final String COLUMNNAME_WhereClause = "WhereClause";

	/** Set Sql WHERE.
	  * Fully qualified SQL WHERE clause
	  */
	public void setWhereClause (String WhereClause);

	/** Get Sql WHERE.
	  * Fully qualified SQL WHERE clause
	  */
	public String getWhereClause();
}
