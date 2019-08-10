
## Kafka XSD Subscription

- Generate XSD from Java POJO classes.
- Create a subscriber to consume XML document from the topic.
- Validate XML document against XSD.
- Persist data into a database if it validates successfully. 


###### Data Pipeline Execution Command
```
mvn compile exec:java -Dexec.mainClass=com.example.StarterPipeline -Dexec.args=" --kafkaURL=localhost:9092 --topicName=xsd-topic --instanceName=cloud-spanner-test-01 --databaseName=test-database-01"
```


