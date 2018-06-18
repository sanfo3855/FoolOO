package ast;

import util.Environment;
import util.SemanticError;

import java.util.ArrayList;

public interface TypeNode extends Node {

    String getType();
}