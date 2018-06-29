package ast;

import java.util.ArrayList;

/**
 * Interface that extends Node and define new methods
 * that have to be implemented in every node that implement FunInterfaceNode
 */
public interface FunInterfaceNode extends Node {

    /**
     *
     * @return Function's ID
     */
    String getId();

    /**
     *
     * @return instance of TypeNode that represent node's type
     */
    Node getType();

    /**
     *
     * @return Node's ArrayList variables
     */
    ArrayList<Node> getListVar();


}
