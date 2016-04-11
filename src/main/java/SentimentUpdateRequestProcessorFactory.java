import org.apache.solr.request.SolrQueryRequest;
import org.apache.solr.response.SolrQueryResponse;
import org.apache.solr.update.processor.UpdateRequestProcessor;
import org.apache.solr.update.processor.UpdateRequestProcessorFactory;

/**
 * Created by hisham on 11/04/2016.
 */
public class SentimentUpdateRequestProcessorFactory extends UpdateRequestProcessorFactory {

    public SentimentUpdateRequestProcessorFactory(UpdateRequestProcessor updateRequestProcessor) {
    }

    public UpdateRequestProcessor getInstance(SolrQueryRequest solrQueryRequest, SolrQueryResponse solrQueryResponse, UpdateRequestProcessor updateRequestProcessor) {
        return new SentimentUpdateRequestProcessor(updateRequestProcessor);
    }
}
