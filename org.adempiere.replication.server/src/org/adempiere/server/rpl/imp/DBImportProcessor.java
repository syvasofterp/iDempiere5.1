package org.adempiere.server.rpl.imp;

import java.util.List;
import java.util.Properties;

import org.adempiere.model.MImportQueue;
import org.adempiere.process.rpl.XMLHelper;
import org.adempiere.process.rpl.imp.ImportHelper;
import org.adempiere.server.rpl.IImportProcessor;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.server.ReplicationProcessor;
import org.w3c.dom.Document;

public class DBImportProcessor implements IImportProcessor {

	@Override
	public void process(Properties ctx, ReplicationProcessor replicationProcessor, String trxName) throws Exception {
		// TODO Auto-generated method stub
		String whereClause = "IsSync='N' AND IsError='N'";
		List<PO> list = new Query(ctx, MImportQueue.Table_Name, whereClause, null)
				.setClient_ID()
				.setOrderBy(MImportQueue.COLUMNNAME_TF_ImportQueue_ID)
				.list();
		for(PO po : list) {
			MImportQueue imp = new MImportQueue(ctx, po.get_ID(), trxName);			
			try {
				Document documentToBeImported = XMLHelper.createDocumentFromString(imp.getMessage());
				StringBuffer result = new StringBuffer();
				ImportHelper impHelper = new ImportHelper( ctx );
				impHelper.importXMLDocument(result, documentToBeImported, trxName );
				imp.setissync(true);
				imp.setLog(result.toString());
			}
			catch (Exception e) {
				imp.setLog(e.getMessage());
				imp.setIsError(true);				
			}			
			imp.saveEx();
		}
	}

	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub

	}

}
