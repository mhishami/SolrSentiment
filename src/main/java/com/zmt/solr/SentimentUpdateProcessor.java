package com.zmt.solr;

import org.apache.log4j.Logger;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.update.AddUpdateCommand;
import org.apache.solr.update.processor.UpdateRequestProcessor;

import java.io.IOException;

/**
 * Created by hisham on 11/04/2016.
 */
public class SentimentUpdateProcessor extends UpdateRequestProcessor {

    private static final Logger LOGGER = Logger.getLogger(SentimentUpdateProcessor.class.getName());
    private static final String SENTIMENT = "sentiment";
    private static final String CONTENT = "content";
    private static final String CONTENT_TXT = "content_txt";

    public SentimentUpdateProcessor(UpdateRequestProcessor next) {
        super(next);
        NLP.init();
    }

    public void processAdd(AddUpdateCommand cmd) throws IOException {
        SolrInputDocument doc = cmd.getSolrInputDocument();

        // see if the content field is available
        Object content = doc.getFieldValue(CONTENT);
        if (null != content) {
            // ok, process it
            int sentiment = NLP.getSentiment(content.toString());
            doc.setField(SENTIMENT, sentiment);
        } else {
            // try content_txt
            Object content_txt = doc.getFieldValue(CONTENT_TXT);
            if (null != content_txt) {
                int sentiment = NLP.getSentiment(content_txt.toString());
                doc.setField(SENTIMENT, sentiment);
            }
        }

        super.next.processAdd(cmd);
    }

}
