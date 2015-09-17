package cscie97.asn1.test;

import cscie97.asn1.knowledge.engine.Importer;
import cscie97.asn1.knowledge.engine.KnowledgeGraph;
import cscie97.asn1.knowledge.engine.QueryEngine;
import cscie97.asn1.knowledge.engine.exception.BulkQueryException;
import cscie97.asn1.knowledge.engine.exception.ImportException;
import cscie97.asn1.knowledge.engine.exception.InvalidTripleFormatException;
import cscie97.asn1.knowledge.engine.exception.QueryEngineException;
/**
 * A class for testing KnowledgeGraph implementation.
 * Invoket the class using following command:
 * <pre><code>java -cp . cscie97.asn1.test.TestDriver inputTriplesFilePath inputQueriesFilePath</code></pre>
 * , where inputTriplesFilePath is either absolute or relative path to input Triple file,
 * and inputQueriesFilePath is either absolute or relative path to query file.
 */
public class TestDriver {

    /**
     * This method imports given input Triple file into a {@link KnowledgeGraph} using {@link Importer}.
     * It then runs queries against the {@link KnowledgeGraph} using {@link QueryEngine}.
     * @param args array containing path to input Triple file, and query file respectively.
     */
    public static void main(String[] args) {
        if(!validateArguments(args)){
            printUsage();
            return;
        }

        String tripleInputFile = args[0];
        String queryInputFile = args[1];

        Importer importer = new Importer();
        try {
            importer.importTripleFile(tripleInputFile);
            QueryEngine queryEngine = new QueryEngine();
            queryEngine.executeQueryFile(queryInputFile);
        } catch (InvalidTripleFormatException e) {
            String message = "Invalid triple found in file at path: '"+ e.getTripleFilePath() +"' at line"+e.getLineNum()+".";
            message += "Error message is: "+ e.getMessage();
            System.err.println(message);
        } catch (ImportException e) {
            String message = "Following error occurred while reading file at path: '"+ e.getTripleFilePath() +"': ";
            message += "'" + e.getMessage() + "'";
            System.err.println(message);
        } catch (BulkQueryException e) {
            String errorMessage = "Following error occurred while executing query file : '";
            errorMessage += e.getQueryFilePath()+"'";
            if(e.getLineNum() != -1) {
                errorMessage += " at line " + e.getLineNum();
            }
            errorMessage +=  " :";
            errorMessage += "'"+ e.getMessage() + "'";
            System.err.println(errorMessage);
            if(e.getQuery() != null){
                System.err.println("Offending query was: '"+ e.getQuery()+"'.");
            }
        } catch (QueryEngineException e) {
            String errorMessage = "Following error occurred while executing a query : '";
            errorMessage += e.getMessage();
            System.err.println(errorMessage);
            System.err.println("Offending query was: '" + e.getQuery() + "'.");
        }
    }

    /**
     * Validates that sufficient number of arguments are provided.
     * @param args Array containing the given arguments
     * @return true, if and only sufficient number of arguments are provided.
     */
    private static boolean validateArguments(String[] args) {
        return (args != null && args.length == 2);
    }

    /**
     * Displays instructions for running the TestDriver.
     */
    private static void printUsage(){
        System.out.println("Usage: Invoke TestDriver using following command: ");
        System.out.println("java -cp . cscie97.asn1.test.TestDriver <inputTriplesFilePath> <inputQueriesFilePath>");
    }


}
