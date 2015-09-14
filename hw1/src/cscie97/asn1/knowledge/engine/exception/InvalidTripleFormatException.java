package cscie97.asn1.knowledge.engine.exception;

/**
 *
 */
public class InvalidTripleFormatException extends ImportException {

    private final int lineNum;

    /**
     *
     * @param filePath
     * @param lineNum
     * @param message
     */
    public InvalidTripleFormatException(String filePath, int lineNum, String message) {
        super(filePath, message);
        this.lineNum = lineNum;
    }

    public int getLineNum() {
        return lineNum;
    }

}
