package cscie97.asn1.knowledge.engine.domain;

/**
 *
 */
public class Triple {

    private final Node subject;

    private final Predicate predicate;

    private final Node object;

    public Triple(Node subject, Predicate predicate, Node object){
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
    }
}
