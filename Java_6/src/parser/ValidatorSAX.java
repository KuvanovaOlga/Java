package parser;
import book.Book;
import booklet.Booklet;

import org.apache.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class ValidatorSAX {
    private static final Logger LOG = Logger.getLogger(ValidatorSAX.class);
    public void valid(){
       String filename= "files/info.xml";
       String schemaname= "files/XSD.xsd";
       String logname="log/log.xml";
        Schema schems=null;
        String language= XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory=SchemaFactory.newInstance(language);
        try{
            schems = factory.newSchema(new File(schemaname));
            Validator validator = schems.newValidator();
            Source source= new StreamSource(filename);
            Booklet s=new Booklet(logname);
            //validator.setErrorHandler(s);
            validator.validate(source);
            LOG.info(filename+   "is valid");
        }
        catch (SAXException e)
        {LOG.error(filename + " SAX error " + e.getMessage());
        }
        catch (IOException e)
        {LOG.error(" io error " + e.getMessage());
        }
    }
}
