package cscie97.asn1.knowledge.engine.domain;

/**
 *
 */
public class Predicate {

    private final String identifier;

    public Predicate(String identifier){
        this.identifier = identifier.trim().toLowerCase();
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
