package net.wakka.protean.cartographer.prototypes.beans;

import java.util.LinkedList;
import java.util.List;

public class Namespace extends Node {

  public Namespace() {
    super();
    setEntityType("namespace");
    setMembers(new LinkedList<Node>());
  }

  private List<Node> members;

  public List<Node> getMembers() {
    return members;
  }

  public void setMembers(List<Node> members) {
    this.members = members;
  }

  @Override
  public boolean equals(Object o) {
    return Namespace.class.isInstance(o) && ((Namespace)o).getIdentifier().equals(this.getIdentifier());
  }

  @Override
  public int hashCode() {
    return getIdentifier() == null ? 0 : getIdentifier().hashCode();
  }

}
