package net.wakka.protean.cartographer.prototypes.beans;

import java.util.LinkedList;
import java.util.List;

public class Namespace extends Node {

  public Namespace() {
    super();
    setType("namespace");
    setChildren(new LinkedList<Node>());
  }

  private List<Node> children;

  public List<Node> getChildren() {
    return children;
  }

  public void setChildren(List<Node> children) {
    this.children = children;
  }

  @Override
  public boolean equals(Object o) {
    return Namespace.class.isInstance(o) && ((Namespace)o).getName().equals(this.getName());
  }

  @Override
  public int hashCode() {
    return getName() == null ? 0 : getName().hashCode();
  }

}
