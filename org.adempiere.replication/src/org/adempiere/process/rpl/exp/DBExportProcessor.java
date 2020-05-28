package org.adempiere.process.rpl.exp;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.adempiere.model.MExportQueue;
import org.adempiere.process.rpl.IExportProcessor;
import org.compiere.model.MEXPProcessor;
import org.compiere.util.Env;
import org.compiere.util.Trx;
import org.w3c.dom.Document;

public class DBExportProcessor implements IExportProcessor {

	@Override
	public void process(Properties ctx, MEXPProcessor expProcessor, Document document, Trx trx) throws Exception {
		
		// Construct Transformer Factory and Transformer
        TransformerFactory tranFactory = TransformerFactory.newInstance();
        String jVersion = System.getProperty("java.version");
		if (jVersion.startsWith("1.5.0"))
			tranFactory.setAttribute("indent-number", Integer.valueOf(1));
        
        Transformer aTransformer = tranFactory.newTransformer();
        aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
        Source src = new DOMSource( document );
		
        // =================================== Write to String
        Writer writer = new StringWriter();
        Result dest2 = new StreamResult(writer);
        aTransformer.transform(src, dest2);
        
        MExportQueue exp = new MExportQueue(ctx, 0, trx.getTrxName());
        exp.setAD_Org_ID(Env.getAD_Org_ID(ctx));
        exp.setMessage(writer.toString());
        exp.setissync(false);
        exp.setIsError(false);
        exp.setIsActive(true);
        exp.saveEx();
        
	}

}
