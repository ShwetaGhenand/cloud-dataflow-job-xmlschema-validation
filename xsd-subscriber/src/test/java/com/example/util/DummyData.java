package com.example.util;

import com.example.db.entity.Item;
import com.example.db.entity.ProductDetails;

public class DummyData {

  public static final String validXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
      + "<item prodcutId=\"103\">\n" + "    <product_name>S-N-01</product_name>\n"
      + "    <product_item_number>SADE2E321</product_item_number>\n"
      + "    <product_description>Sport Shoes</product_description>\n"
      + "    <product_quantity>2</product_quantity>\n"
      + "    <product_details prodcutId=\"103\" prodcutDetailsId=\"103\">\n"
      + "        <product_brand>Adidas</product_brand>\n"
      + "        <product_category>shoes</product_category>\n" + "    </product_details>\n"
      + "</item>\n" + "";

  public static final String invalidXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
      + "<item prodcutId=\"103\">\n" + "    <product_name_test>S-N-01</product_name_test>\n"
      + "    <product_item_number>SADE2E321</product_item_number>\n"
      + "    <product_description>Sport Shoes</product_description>\n"
      + "    <product_quantity>2</product_quantity>\n"
      + "    <product_details prodcutId=\"103\" prodcutDetailsId=\"103\">\n"
      + "        <product_brand>Adidas</product_brand>\n"
      + "        <product_category>shoes</product_category>\n" + "    </product_details>\n"
      + "</item>\n" + "";

  public static final String topicName = "xsd-topic";

  public static Item getExpectedItem() {
    Long val = new Long(103);
    Item expectedItem = new Item();
    ProductDetails productDetails = new ProductDetails();
    productDetails.setProdcut_details_id(val);
    productDetails.setProdcut_id(val);
    productDetails.setProduct_brand("Adidas");
    productDetails.setProduct_category("shoes");

    expectedItem.setProdcut_id(val);
    expectedItem.setProduct_item_number("SADE2E321");
    expectedItem.setProduct_description("Sport Shoes");
    expectedItem.setProduct_quantity("2");
    expectedItem.setProduct_name("S-N-01");
    expectedItem.setProduct_details(productDetails);

    return expectedItem;
  }

}
