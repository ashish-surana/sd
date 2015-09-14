package cscie97.asn1.knowledge.engine.exception;

/**
 *
 */
public class QueryEngineException extends Exception {

    private final String query;

    public QueryEngineException(String query, String message){
        super(message);
        this.query = query;
    }

    @Override
    public String getMessage() {
        //TODO
        return super.getMessage();
    }

    public String getQuery() {
        return query;
    }

}