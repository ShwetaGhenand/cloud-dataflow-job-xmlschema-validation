/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.spanner.SpannerIO;
import org.apache.beam.sdk.io.kafka.KafkaIO;
import org.apache.beam.sdk.io.kafka.KafkaRecord;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.config.MyOptions;
import com.example.subprocess.CreateItemMutation;
import com.example.subprocess.XmlToObjectConversion;
import com.example.subprocess.XmlValidation;

/**
 * A starter example for writing Beam programs.
 *
 * <p>
 * The example takes two strings, converts them to their upper-case
 * representation and logs them.
 *
 * <p>
 * To run this starter example locally using DirectRunner, just execute it
 * without any additional parameters from your favorite development environment.
 *
 * <p>
 * To run this starter example using managed resource in Google Cloud Platform,
 * you should specify the following command-line options:
 * --project=<YOUR_PROJECT_ID>
 * --stagingLocation=<STAGING_LOCATION_IN_CLOUD_STORAGE> --runner=DataflowRunner
 */
public class StarterPipeline {
  private static final Logger LOG = LoggerFactory.getLogger(StarterPipeline.class);

  public static void runDataPipelineFn(MyOptions options) {

    try {
      Pipeline pipeLine = Pipeline.create(options);

      PCollection<KafkaRecord<String, String>> kafkaRecord = pipeLine
          .apply(KafkaIO.<String, String>read().withBootstrapServers(options.getKafkaURL())
              .withTopic(options.getTopicName()).withKeyDeserializer(StringDeserializer.class)
              .withValueDeserializer(StringDeserializer.class));

      kafkaRecord.apply("XmlValidation", ParDo.of(new XmlValidation()))
          .apply("XmlToObjectConversion", ParDo.of(new XmlToObjectConversion()))
          .apply("CreateMutation", ParDo.of(new CreateItemMutation()))
          .apply("WriteItems", SpannerIO.write().withInstanceId(options.getInstanceName())
              .withDatabaseId(options.getDatabaseName()).grouped());

      pipeLine.run();
    } catch (Exception e) {
      LOG.error("Exception Caught::" + e.getLocalizedMessage(), e);
    }
  }

  public static void main(String[] args) {

    PipelineOptionsFactory.register(MyOptions.class);
    MyOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().as(MyOptions.class);
    runDataPipelineFn(options);

  }
}
