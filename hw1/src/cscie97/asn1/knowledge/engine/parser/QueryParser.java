package cscie97.asn1.knowledge.engine.parser;

import cscie97.asn1.knowledge.engine.domain.Node;
import cscie97.asn1.knowledge.engine.domain.Predicate;
import cscie97.asn1.knowledge.engine.domain.Triple;

/**
 *
 */
public class QueryParser {

    private final String queryText;

    private String errorMessage;

    private Triple query;

    public QueryParser(String queryText) {
        this.queryText = queryText;
    }

    /**
     * Performs following validations on the given queryText.
     * <ul>
     *     <li>The queryText contains exactly three space-delimited words.</li>
     *     <li>The queryText does not end with a '.'.</li>
     * </ul>
     * @return
     */
    public boolean validate() {
        if(queryText == null){
            errorMessage = "Query text is null";
            return false;
        }

        String processedQueryText = queryText.trim();

        if("".equals(processedQueryText)){
            errorMessage = "Query text is empty";
            return false;
        }

        String queryTerminator = processedQueryText.substring(processedQueryText.length()-1);
        processedQueryText = processedQueryText.substring(0, processedQueryText.length()-1);

        if(!".".equals(queryTerminator)){
            errorMessage = "Query text does not terminate with '.' :'"
                    + queryText +"'";
            return false;
        }

        String[] triple = processedQueryText.split(" ");

        if(triple.length < 3){
            errorMessage = "Query text is missing subject, predicate, or object:'"
                    + queryText +"'";
            return false;
        }

        if(triple.length > 3){
            errorMessage = "Query text contains too many subject, predicate, or object:'"
                    + queryText +"'";
            return false;
        }

        Node subject = new Node(triple[0]);
        Predicate predicate = new Predicate(triple[1]);
        Node object = new Node(triple[2]);
        query = new Triple(subject, predicate, object);
        return true;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Triple getQuery() {
        return query;
    }
}
