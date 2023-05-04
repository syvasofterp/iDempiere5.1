package org.adempiere.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MImportQueue extends X_AD_ImportQueue {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7185111019420822474L;

	public MImportQueue(Properties ctx, int AD_ImportQueue_ID, String trxName) {
		super(ctx, AD_ImportQueue_ID, trxName);
		
	}

	public MImportQueue(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		
	}

}
