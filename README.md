
# SolrSentiment
An `UpdateRequestFactory` that uses the Stanfor com.zmt.solr.NLP Library for Sentiment Analysis.

# Usage
1. Clone this repo
2. Do `mvn package` to build the jar
3. Do `mvn install dependency:copy-dependencies` to export the libraries use in this project.

```
target
├── classes
│   ├── com.zmt.solr.NLP.class
│   ├── com.zmt.solr.SentimentUpdateRequestProcessor.class
│   └── com.zmt.solr.SentimentUpdateRequestProcessorFactory.class
├── dependency
│   ├── antlr4-runtime-4.5.1-1.jar
│   ├── asm-5.0.4.jar
│   ├── woodstox-core-asl-4.4.1.jar
|   .
|   .
|   .
│   ├── xalan-2.7.0.jar
│   ├── xercesImpl-2.8.0.jar
│   ├── xml-apis-1.3.03.jar
│   ├── xom-1.2.10.jar
│   └── zookeeper-3.4.6.jar
├── maven-archiver
│   └── pom.properties
├── setiment-update-processor-1.0.0.jar
└── surefire
```
