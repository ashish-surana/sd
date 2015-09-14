package cscie97.asn1.knowledge.engine.exception;

/**
 *
 */
public class BulkQueryException extends QueryEngineException {

    private final String fileName;

    private final int lineNum;


    public BulkQueryException(String fileName, int lineNum, String query, String message){
        super(query, message);
        this.fileName = fileName;
        this.lineNum = lineNum;
    }

    public int getLineNum() {
        return lineNum;
    }

    public String getFileName() {
        return fileName;
    }
}
