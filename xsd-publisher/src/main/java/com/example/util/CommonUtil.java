package com.example.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.common.Constants;

import generated.Item;
import generated.ObjectFactory;
import generated.ProductDetails;

public class CommonUtil {

  private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);
  static ObjectFactory factory = new ObjectFactory();

  private CommonUtil() {

  }

  public static Item createItem() {
    Long val = new Long(101);
    ProductDetails productDetails = factory.createProductDetails();
    productDetails.setProdcutId(val);
    productDetails.setProdcutDetailsId(val);
    productDetails.setProductBrand("Adidas");
    productDetails.setProductCategory("shoes");

    Item item = factory.createItem();
    item.setProdcutId(val);
    item.setProductItemNumber("SADE2E321");
    item.setProductDescription("Sport Shoes");
    item.setProductQuantity("2");
    item.setProductName("S-N-01");
    item.setProductDetails(productDetails);
    return item;
  }

  public static String generateXMLfromXSD() {
    JAXBContext context;
    String xml = null;
    try {
      Item item = createItem();
      context = JAXBContext.newInstance(Constants.JAXB_CONTEXT_PATH);
      JAXBElement<Item> element = factory.createItem(item);
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
      StringWriter sw = new StringWriter();
      marshaller.marshal(element, sw);
      xml = sw.toString();

    } catch (Exception e) {
      LOG.error("Exception caught while genarating xml from xsd::" + e.getLocalizedMessage(), e);

    }
    return xml;
  }

}
