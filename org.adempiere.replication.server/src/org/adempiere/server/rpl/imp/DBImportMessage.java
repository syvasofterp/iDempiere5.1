package org.adempiere.server.rpl.imp;

import org.adempiere.model.MImportQueue;
import org.adempiere.process.rpl.XMLHelper;
import org.adempiere.process.rpl.imp.ImportHelper;
import org.compiere.process.SvrProcess;
import org.w3c.dom.Document;

public class DBImportMessage extends SvrProcess {

	@Override
	protected void prepare() {
		// TODO Auto-generated method stub

	}

	@Override
	protected String doIt() throws Exception {
		MImportQueue imp = new MImportQueue(getCtx(), getRecord_ID(), get_TrxName());
		try {
			Document documentToBeImported = XMLHelper.createDocumentFromString(imp.getMessage());
			StringBuffer result = new StringBuffer();
			ImportHelper impHelper = new ImportHelper(getCtx());
			impHelper.importXMLDocument(result, documentToBeImported, get_TrxName() );
			imp.setissync(true);
			imp.setLog(result.toString());
		}
		catch (Exception e) {
			imp.setLog(e.getMessage());
			imp.setIsError(true);				
		}
		imp.saveEx();
		return null;
	}

}
