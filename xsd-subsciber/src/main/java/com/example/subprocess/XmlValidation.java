package com.example.subprocess;

import org.apache.beam.sdk.io.kafka.KafkaRecord;
import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.util.CommonUtil;

public class XmlValidation extends DoFn<KafkaRecord<String, String>, String> {

  private static final Logger LOG = LoggerFactory.getLogger(XmlValidation.class);
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  boolean isValid;

  @ProcessElement
  public void processElement(ProcessContext processContext) {
    try {
      KafkaRecord<String, String> record = processContext.element();
      isValid = CommonUtil.validateXmlFn(record.getKV().getValue());

      if (isValid) {
        processContext.output(record.getKV().getValue());
      } else {
        LOG.error("Invalid Xml data:" + record.getKV().getValue());
      }
    } catch (Exception e) {
      LOG.error("Exception caught while validating xml" + e.getLocalizedMessage(), e);
    }

  }

}
