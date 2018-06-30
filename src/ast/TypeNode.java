package ast;

/**
 * Interface that define methods that have to be implemented in every node that implement TypeNode
 */
public interface TypeNode extends Node {
    String getType();
}