package com.example.subprocess;

import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.values.KV;

import com.example.common.Constants;

public class KafkaPayload extends DoFn<String, KV<String, String>> {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @ProcessElement
  public void processElement(ProcessContext c) throws Exception {
    c.output(KV.of(Constants.KEY, c.element()));

  }

}
