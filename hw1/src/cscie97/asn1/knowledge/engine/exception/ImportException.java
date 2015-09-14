package cscie97.asn1.knowledge.engine.exception;

/**
 *
 */
public class ImportException extends Exception{

    private final String filePath;

    public ImportException(String filePath, String message){
        super(message);
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String getMessage() {
        //TODO
        return super.getMessage();
    }
}
