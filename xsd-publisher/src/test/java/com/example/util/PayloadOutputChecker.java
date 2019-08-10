package com.example.util;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.KV;

import com.example.util.DummyData;

public class PayloadOutputChecker
    implements SerializableFunction<Iterable<KV<String, String>>, Void> {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Override
  public Void apply(Iterable<KV<String, String>> output) {
    Iterator<KV<String, String>> outputIterator = output.iterator();
    while (outputIterator.hasNext()) {
      assertEquals(outputIterator.next(), DummyData.expectedPayload);
    }
    return null;
  }

}
