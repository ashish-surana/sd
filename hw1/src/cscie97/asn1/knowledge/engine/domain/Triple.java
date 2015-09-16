package cscie97.asn1.knowledge.engine.domain;

/**
 *
 */
public class Triple {

    private final Node subject;

    private final Predicate predicate;

    private final Node object;

    private final String identifier;

    public Triple(Node subject, Predicate predicate, Node object){
        this.subject = subject;
        this.predicate = predicate;
        this.object = object;
        this.identifier = getIdentifier(subject, predicate, object);
    }

    public static String getIdentifier(Node subject, Predicate predicate, Node object){
        StringBuilder tripleIdentifierBuilder = new StringBuilder().append(subject.getIdentifier());
        tripleIdentifierBuilder.append(" ");
        tripleIdentifierBuilder.append(predicate.getIdentifier());
        tripleIdentifierBuilder.append(" ");
        tripleIdentifierBuilder.append(object.getIdentifier());
        return tripleIdentifierBuilder.toString();
    }

    public String getIdentifier() {
        return identifier;
    }

    public Node getObject() {
        return object;
    }

    public Node getSubject() {
        return subject;
    }

    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
