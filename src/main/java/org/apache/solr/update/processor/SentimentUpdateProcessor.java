package org.apache.solr.update.processor;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.update.AddUpdateCommand;

import java.io.IOException;

/**
 * Created by hisham on 11/04/2016.
 */
public class SentimentUpdateProcessor extends UpdateRequestProcessor {

    public SentimentUpdateProcessor(UpdateRequestProcessor next) {
        super(next);
        NLP.init();
    }

    public void processAdd(AddUpdateCommand cmd) throws IOException {
        SolrInputDocument doc = cmd.getSolrInputDocument();

        // see if the content field is available
        Object content = doc.getFieldValue("content");
        if (null != content) {
            // ok, process it
            int sentiment = NLP.getSentiment(content.toString());
            doc.setField("sentiment", sentiment);
        }

        super.processAdd(cmd);
    }

}
