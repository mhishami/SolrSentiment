package com.zmt.solr;

import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.update.processor.UpdateRequestProcessor;
import org.apache.solr.update.processor.UpdateRequestProcessorFactory;

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
