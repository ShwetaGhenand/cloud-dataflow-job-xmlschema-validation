## Kafka-XSD-Publisher:

- Generate XSD from Java POJO classes.
- Create an XML document from generated XSD.
- Publish XML document to a Kafka topic.


##### Data Pipeline Execution Command:
```
mvn compile exec:java -Dexec.mainClass=com.example.StarterPipeline  -Dexec.args=" --kafkaURL=localhost:9092 --topicName=xsd-topic"
```


