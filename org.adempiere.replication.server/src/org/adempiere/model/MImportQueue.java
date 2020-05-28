package org.adempiere.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MImportQueue extends X_TF_ImportQueue {

	public MImportQueue(Properties ctx, int TF_ImportQueue_ID, String trxName) {
		super(ctx, TF_ImportQueue_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MImportQueue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

}
