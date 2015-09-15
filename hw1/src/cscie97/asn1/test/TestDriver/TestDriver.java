package cscie97.asn1.test.TestDriver;

import cscie97.asn1.knowledge.engine.Importer;
import cscie97.asn1.knowledge.engine.QueryEngine;
import cscie97.asn1.knowledge.engine.exception.ImportException;

public class TestDriver {

    public static void main(String[] args) {
        //TODO
        args = new String[]{"E:\\Users\\ashish\\Downloads\\inputTriples.nt.txt", ""};

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
//            queryEngine.executeQueryFile(queryInputFile);
        } catch (ImportException e) {
            System.err.println(e.getMessage());
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
        System.out.println("java -cp cscie97.asn1.test.TestDriver <inputTriplesFilePath> <inputQueriesFilePath>");
    }


}
