package com.example.util;

import org.apache.beam.sdk.values.KV;

import com.example.common.Constants;

public class DummyData {

  public static final String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
      + "<item prodcutId=\"101\">\n" + "    <product_name>S-N-01</product_name>\n"
      + "    <product_item_number>SADE2E321</product_item_number>\n"
      + "    <product_description>Sport Shoes</product_description>\n"
      + "    <product_quantity>2</product_quantity>\n"
      + "    <product_details prodcutId=\"101\" prodcutDetailsId=\"101\">\n"
      + "        <product_brand>Adidas</product_brand>\n"
      + "        <product_category>shoes</product_category>\n" + "    </product_details>\n"
      + "</item>\n" + "";

  public static final KV<String, String> expectedPayload = KV.of(Constants.KEY, expectedXml);

  public static final String topicName = "xsd-topic";
}
