package com.example.test;

import org.apache.beam.sdk.testing.NeedsRunner;
import org.apache.beam.sdk.testing.PAssert;
import org.apache.beam.sdk.testing.TestPipeline;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.subprocess.KafkaPayload;
import com.example.util.CommonUtil;
import com.example.util.OutputChecker;
import com.example.util.PayloadOutputChecker;

public class StarterPipelineTest {

  @Rule
  public final transient TestPipeline testPipeLine = TestPipeline.create();

  @Test
  @Category(NeedsRunner.class)
  public void generateXmlfromXsdTestFn() throws Exception {

    PCollection<String> actualXML = testPipeLine.apply(Create.of(CommonUtil.generateXMLfromXSD()));
    PAssert.that(actualXML).satisfies(new OutputChecker());
    testPipeLine.run();
  }

  @Test
  @Category(NeedsRunner.class)
  public void kafkaPayloadTestFn() throws Exception {

    PCollection<String> xml = testPipeLine.apply(Create.of(CommonUtil.generateXMLfromXSD()));
    PCollection<KV<String, String>> payload = xml.apply(ParDo.of(new KafkaPayload()));
    PAssert.that(payload).satisfies(new PayloadOutputChecker());
    testPipeLine.run();
  }

}
