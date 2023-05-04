package org.adempiere.server.rpl.imp;

import java.util.List;
import java.util.Properties;

import org.adempiere.model.MImportQueue;
import org.adempiere.process.rpl.XMLHelper;
import org.adempiere.process.rpl.imp.ImportHelper;
import org.adempiere.server.rpl.IImportProcessor;
import org.compiere.model.MIMPProcessorLog;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.server.ReplicationProcessor;
import org.w3c.dom.Document;

public class WSImportProcessor implements IImportProcessor {

	public WSImportProcessor() {
		
	}

	@Override
	public void process(Properties ctx, ReplicationProcessor replicationProcessor, String trxName) throws Exception {
		
		String whereClause = "Processed='N' AND ErrorMsg IS NULL";
		
		List<PO> list = new Query(ctx, MImportQueue.Table_Name, whereClause, trxName)
				.setClient_ID()
				.setOrderBy("Created")
				.list();
		
		if(replicationProcessor == null)
			return;
		
		for(PO p : list) {			
			
			MImportQueue iq = new MImportQueue(ctx, p.get_ID(), trxName);
			try {
				int start = iq.getMsgText().indexOf("?>");
				Document documentToBeImported = XMLHelper.createDocumentFromString(iq.getMsgText().substring(start + 2));
				
				StringBuffer result = new StringBuffer();
				
				ImportHelper impHelper = new ImportHelper( ctx );
		
				impHelper.importXMLDocument(result, documentToBeImported, trxName );
				
				if(replicationProcessor != null)
				{	
					MIMPProcessorLog pLog = new MIMPProcessorLog(replicationProcessor.getMImportProcessor(), "Imported Document!");		
					pLog.saveEx();
				}
				
				iq.setProcessed(true);
				iq.saveEx();
			}
			catch(Exception ex) {
				iq.setProcessed(false);
				iq.setErrorMsg(ex.getMessage());
				iq.saveEx();
			}
		}

	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub

	}

}
