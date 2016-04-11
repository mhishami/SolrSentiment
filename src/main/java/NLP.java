import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

/**
 * Created by hisham on 11/04/2016.
 */
public class NLP {
    private static StanfordCoreNLP pipeline;

    public NLP() {
    }

    public static void init() {
        pipeline = new StanfordCoreNLP("profile.properties");
    }

    public static int getSentiment(String tweet) {

        int mainSentiment = 0;

        if (tweet != null) {
            int longest = 0;

            /*
             * The annotations works this way:
             * 0: "Very Negative"
             * 1: "Negative"
             * 2: "Neutral"
             * 3: "Positive"
             * 4: "Very Positive"
             */
            Annotation annotation = pipeline.process(tweet);
            for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
                Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
                int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
                String parText = sentence.toString();

                if (parText.length() > longest) {
                    mainSentiment = sentiment;
                    longest = parText.length();
                }
            }
        }

        return mainSentiment;
    }
}
