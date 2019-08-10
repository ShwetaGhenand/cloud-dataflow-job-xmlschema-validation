package com.example.util;

import java.io.File;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.common.Constants;
import com.example.db.entity.Item;

public class CommonUtil {

  private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

  public static Item convertXMLtoObjectFn(String xml) throws JAXBException {
    LOG.debug("Convert xml to object function is started");
    JAXBContext jaxbContext;
    jaxbContext = JAXBContext.newInstance(Item.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    Item item = (Item) jaxbUnmarshaller.unmarshal(new StringReader(xml));
    return item;

  }

  public static boolean validateXmlFn(String xml) {
    LOG.debug("xml validation function is started..");
    try {
      SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
      Schema schema = factory.newSchema(new File(Constants.XSD_FILE_PATH));
      Validator validator = schema.newValidator();
      StringReader reader = new StringReader(xml);
      validator.validate(new StreamSource(reader));// verify that an XML document is an instance of
                                                   // a specified XML schema file.
      return true;
    } catch (Exception e) {
      LOG.error("Exception caught in validating xml::" + e.getLocalizedMessage(), e);
      return false;
    }

  }

}
