package cscie97.asn1.knowledge.engine;

import cscie97.asn1.knowledge.engine.exception.BulkQueryException;
import cscie97.asn1.knowledge.engine.exception.QueryEngineException;

/**
 *
 */
public class QueryEngine {

    /**
     * Public method for executing a single query on the knowledge graph.
     * Checks for non null and well-formed query string.
     * @param query
     * @throws QueryEngineException on error.
     */
    public void executeQuery(String query) throws QueryEngineException{

    }


    /**
     * Public method for executing a set of queries read from a file.  
     * Checks for valid file  name. 
     * Delegates to executeQuery for processing individual queries.
     * @param fileName
     * @throws QueryEngineException on error.
     * @throws BulkQueryException on error.
     */
    public void executeQueryFile(String fileName) throws BulkQueryException, QueryEngineException{
        executeQuery(fileName);
    }
}
