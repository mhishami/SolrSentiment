package org.apache.solr.update.processor;

import org.apache.solr.common.util.NamedList;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;

/**
 * Created by hisham on 11/04/2016.
 */
public class SentimentUpdateProcessorFactory extends UpdateRequestProcessorFactory {

    @Override
    public void init(NamedList args) {
        super.init(args);
    }

    public UpdateRequestProcessor getInstance(SolrQueryRequest solrQueryRequest, SolrQueryResponse solrQueryResponse, UpdateRequestProcessor updateRequestProcessor) {
        return new SentimentUpdateProcessor(updateRequestProcessor);
    }

}
