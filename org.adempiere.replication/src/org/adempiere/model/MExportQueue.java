package org.adempiere.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MExportQueue extends X_AD_ExportQueue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4118438663955802669L;

	public MExportQueue(Properties ctx, int AD_ExportQueue_ID, String trxName) {
		super(ctx, AD_ExportQueue_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MExportQueue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
