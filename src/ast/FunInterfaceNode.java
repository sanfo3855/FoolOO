package ast;

import java.util.ArrayList;

public interface FunInterfaceNode extends Node {

    String getId();

    Node getType();

    ArrayList<Node> getListVar();


}
