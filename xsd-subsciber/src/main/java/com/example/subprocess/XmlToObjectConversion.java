package com.example.subprocess;

import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.db.entity.Item;
import com.example.util.CommonUtil;

public class XmlToObjectConversion extends DoFn<String, Item> {
  private static final Logger LOG = LoggerFactory.getLogger(XmlToObjectConversion.class);
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ProcessElement
  public void processElement(ProcessContext processContext) {
    try {
      Item item = CommonUtil.convertXMLtoObjectFn(processContext.element());
      processContext.output(item);
    } catch (Exception e) {
      LOG.error("Exception caught while converting xml to object:" + e.getLocalizedMessage(), e);
    }

  }
}
