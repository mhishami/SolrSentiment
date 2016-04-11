package org.apache.solr.update.processor;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.update.AddUpdateCommand;

/**
 * Created by hisham on 12/04/2016.
 */
public class SentimentProcessorFactory extends SimpleUpdateProcessorFactory {

    @Override
    public void init(NamedList args) {
        super.init(args);
    }

    @Override
    public UpdateRequestProcessor getInstance(SolrQueryRequest req, SolrQueryResponse rsp, UpdateRequestProcessor next) {
        return super.getInstance(req, rsp, next);
    }

    protected void process(AddUpdateCommand cmd, SolrQueryRequest req, SolrQueryResponse resp) {

        SolrInputDocument doc = cmd.getSolrInputDocument();

        // see if the content field is available
        Object content = doc.getFieldValue("content");
        if (null != content) {
            // ok, process it
            int sentiment = NLP.getSentiment(content.toString());
            doc.setField("sentiment", sentiment);
        }

        //super.process(cmd, req, resp);

    }

}
