package cscie97.asn1.knowledge.engine;

import cscie97.asn1.knowledge.engine.domain.Triple;
import cscie97.asn1.knowledge.engine.exception.ImportException;
import cscie97.asn1.knowledge.engine.exception.InvalidTripleFormatException;

/**
 *
 */
public class Importer {

    /**
     * Public method for importing triples from N_Triple formatted file into the KnowledgeGraph. 
     * Checks for valid input file name.  
     * @param fileName
     * @throws InvalidTripleFormatException
     * //TODO
     * @throws ImportException on error accessing or processing the input triple file. 
     */
    public void importTripleFile(String fileName) throws InvalidTripleFormatException, ImportException{
        //Validate triple file
        //Read triple file, one line at a time



    }

    private Triple getTriple(String filePath, int lineNum, String tripleText) throws InvalidTripleFormatException{
        try{

        }catch (Exception e){
            throw new InvalidTripleFormatException(filePath, lineNum, e.getMessage());
        }
    }
}
