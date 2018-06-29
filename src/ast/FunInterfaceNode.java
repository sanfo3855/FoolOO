package ast;

import java.util.ArrayList;

/**
 * Interface that extends Node and define new methods
 * that have to be implemented in every node that implement FunInterfaceNode
 */
public interface FunInterfaceNode extends Node {

    /**
     * Return ID of a function
     *
     * @return Function's ID
     */
    String getId();

    /**
     * Return an instance of TypeNode that represent node's type
     *
     * @return TypeNode's instance
     */
    Node getType();

    /**
     * Return a Node's ArrayList variables
     * @return
     */
    ArrayList<Node> getListVar();


}
