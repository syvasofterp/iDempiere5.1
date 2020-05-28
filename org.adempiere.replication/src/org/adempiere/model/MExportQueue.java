package org.adempiere.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MExportQueue extends X_TF_ExportQueue {

	public MExportQueue(Properties ctx, int TF_ExportQueue_ID, String trxName) {
		super(ctx, TF_ExportQueue_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MExportQueue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
