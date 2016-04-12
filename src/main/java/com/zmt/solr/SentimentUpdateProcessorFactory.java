package com.zmt.solr;

import org.apache.log4j.Logger;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.update.processor.UpdateRequestProcessor;
import org.apache.solr.update.processor.UpdateRequestProcessorFactory;

/**
 * Created by hisham on 11/04/2016.
 */
public class SentimentUpdateProcessorFactory extends UpdateRequestProcessorFactory {

    private static final Logger LOGGER = Logger.getLogger(SentimentUpdateProcessorFactory.class.getName());

    @Override
    public void init(NamedList args) {
        super.init(args);
        LOGGER.info("Initialized...");
    }

    public UpdateRequestProcessor getInstance(SolrQueryRequest req, SolrQueryResponse resp,
                                              UpdateRequestProcessor next) {
        return new SentimentUpdateProcessor(next);
    }

}
