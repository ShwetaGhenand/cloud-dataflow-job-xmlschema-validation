package com.example.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.beam.sdk.testing.NeedsRunner;
import org.apache.beam.sdk.testing.TestPipeline;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.db.entity.Item;
import com.example.util.CommonUtil;
import com.example.util.DummyData;

public class StarterPipelineTest {

  @Rule
  public final transient TestPipeline testPipeLine = TestPipeline.create();

  @Test
  @Category(NeedsRunner.class)
  public void validateXmlFnWithValideData() throws Exception {
    boolean isValid = CommonUtil.validateXmlFn(DummyData.validXml);
    assertTrue(isValid);

  }

  @Test
  @Category(NeedsRunner.class)
  public void validateXmlFnWithInvalideData() throws Exception {
    boolean isValid = CommonUtil.validateXmlFn(DummyData.invalidXml);
    assertFalse(isValid);

  }

  // Need to optimized
  @Test
  @Category(NeedsRunner.class)
  public void xmlToObjectConversionTestFn() throws Exception {

    Item actualItem = CommonUtil.convertXMLtoObjectFn(DummyData.validXml);
    Item expextedItem = DummyData.getExpectedItem();

    assertTrue(actualItem.getProdcut_id().equals(expextedItem.getProdcut_id()));
    assertTrue(actualItem.getProduct_name().equals(expextedItem.getProduct_name()));
    assertTrue(actualItem.getProduct_quantity().equals(expextedItem.getProduct_quantity()));
    assertTrue(actualItem.getProduct_item_number().equals(expextedItem.getProduct_item_number()));
    assertTrue(actualItem.getProduct_description().equals(expextedItem.getProduct_description()));

    assertTrue(actualItem.getProduct_details().getProduct_brand()
        .equals(expextedItem.getProduct_details().getProduct_brand()));
    assertTrue(actualItem.getProduct_details().getProduct_category()
        .equals(expextedItem.getProduct_details().getProduct_category()));
    assertTrue(actualItem.getProduct_details().getProdcut_details_id()
        .equals(expextedItem.getProduct_details().getProdcut_details_id()));
    assertTrue(actualItem.getProduct_details().getProdcut_id()
        .equals(expextedItem.getProduct_details().getProdcut_id()));

    // assertEquals(actualItem, expextedItem);

  }

}
