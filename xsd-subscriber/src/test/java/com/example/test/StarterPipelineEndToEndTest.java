package com.example.test;

import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.testing.NeedsRunner;
import org.apache.beam.sdk.testing.TestPipeline;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.example.StarterPipeline;
import com.example.config.MyOptions;
import com.example.util.DummyData;

public class StarterPipelineEndToEndTest {

  @Rule
  public final transient TestPipeline testPipeline = TestPipeline.create();

  @Test
  @Category(NeedsRunner.class)
  public void testErrorCountFn() throws Exception {

    PipelineOptionsFactory.register(MyOptions.class);
    MyOptions options = PipelineOptionsFactory.as(MyOptions.class);
    options.setTopicName(DummyData.topicName);
    StarterPipeline.runDataPipelineFn(options);

  }
}
