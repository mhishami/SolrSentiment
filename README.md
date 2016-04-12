
# SolrSentiment
An `UpdateRequestFactory` that uses the Stanford NLP Library for Sentiment Analysis.

# Usage
1. Clone this repo

2. Do `mvn package` to build the jar

3. Do `mvn install dependency:copy-dependencies` to export the libraries use in this project.

```
target
├── classes
│   ├── NLP.class
│   ├── SentimentUpdateProcessor.class
│   └── SentimentUpdateProcessorFactory.class
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
4. Create a custom directory in `${solr.install.dir}/server/lib/custom`
```
mkdir /opt/solr/server/lib/custom
```
5. Copy all the dependencies in `Step 3` above to this dir

6. Copy the jar generate in `Step 2` to this dir as well

7. Copy the `profile.properties` under `src/main/resources` into `${solr.install.dir}/server/resources`

8. Edit `solrconfig.xml` to include the section below:
```
<config>
  ...
  <lib dir="${solr.install.dir}/server/lib/custom/" regex=".*\.jar" />
  ...
  <updateRequestProcessorChain ... >
    ...
    ...
    <!-- our custom processor -->
    <processor class="com.zmt.solr.SentimentUpdateProcessorFactory"/>
    ...
    ...
  </updateRequestProcessorChain>
  ...
</config>
```
9. In some cases, to avoid `ClassNotFound` errors, you need to copy the Standford NLP libraries, and the minimal dependencies to `ext` library as well
```
  cd /opt/solr/server/lib
  cp custom/stanford*.jar ext/.
  cp custom/ejml*.jar ext/.
```

#Note
This is gonna be memory intensive. As that, ensure your Xss, Xmx are configured to a minimum of `2g`

## Enjoy!

