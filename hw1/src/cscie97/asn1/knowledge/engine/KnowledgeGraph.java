package cscie97.asn1.knowledge.engine;

import cscie97.asn1.knowledge.engine.domain.Node;
import cscie97.asn1.knowledge.engine.domain.Predicate;
import cscie97.asn1.knowledge.engine.domain.Triple;

import java.util.*;

/**
 *
 */
public class KnowledgeGraph {

    private static final KnowledgeGraph INSTANCE = new KnowledgeGraph();

    private final Map<String, Node> nodeMap;

    private final Map<String, Triple> tripleMap;

    private final Map<String, Predicate> predicateMap;

    private final Map<Triple, Set<Triple>> queryMapSet;

    private KnowledgeGraph() {
        this.nodeMap = new HashMap<>();
        this.tripleMap = new HashMap<>();
        this.predicateMap = new HashMap<>();
        this.queryMapSet = new HashMap<>();
    }

    /**
     * This method returns a reference to the single static instance of the KnowledgeGraph.
     * @return the KnowledgeGraph. 
     */
    public static KnowledgeGraph getInstance() {
        return INSTANCE;
    }

    /**
     * Public method for adding a list of Triples to the KnowledgeGraph.
     * @param tripleList
     */
    public void importTriples(List<Triple> tripleList){
        // The following associations must be updated: nodeMap, tripleMap, queryMapSet, predicateMap to reflect the added Triple.  
        // There should be one Triple instance per unique Subject, Predicate, Object combination, so that Triples are not duplicated.
        for (Triple triple : tripleList){
            //generate all queries which can return this triple as their output.
            //For each generated query, add this triple as a result

        }
    }

    /**
     * The executeQuery() method supports execution of queries against the knowledge graph.  
     * The  Query is specified in the form of a Triple.  
     * Occurrences of the “?” identifier within the Query can  be supported by leaving the 
     * associated link (subject, predicate or object) as null within the Triple. 
     * The executeQuery() method returns a Set of matching triples.  
     * Triples are unique based on the combination of Subject, Predicate, Object. 
     * @param query
     * @return
     */
    public Set<Triple> executeQuery(Triple query){
        //Use the queryMapSet to determine the  Triples that match the given Query.  
        // If none are found return an empty Set.
        Set<Triple> queryResult = queryMapSet.get(query);

        if(queryResult == null){
            queryResult = new HashSet<>();
        }
        return queryResult;
    }

    /**
     * Return a Node Instance for the given node identifier.
     * Node identifiers are case insensitive.
     * @param identifier a unique identifier for Node.
     * @return the Node corresponding to the given identifier.
     */
    public Node getNode(String identifier){
        String cleanedId = cleanIdentifier(identifier);
        //Use the nodeMap to look up the  Node.  
        // If the Node does not exist, create it and add it to the nodeMap.
        Node node = nodeMap.get(cleanedId);

        if(node == null){
            node = new Node(identifier);
            nodeMap.put(cleanedId, node);
        }

        return node;
    }

    private String cleanIdentifier(String identifier) {
        identifier = identifier.trim().toLowerCase();
        return identifier;
    }

    public Predicate getPredicate(String identifier){
        return null;
    }

    public Triple getTriple(Node subject, Predicate predicate, Node object){
        return null;
    }
}
