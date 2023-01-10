package net.wakka.protean.cartographer.prototypes.beans;

import java.util.LinkedList;
import java.util.List;

public class Class extends Node {

  public Class() {
    super();
    setEntityType("class");
    superclasses = new LinkedList<String>();
    members = new LinkedList<Node>();
  }

  private List<String> superclasses;
  private List<Node> members;

  public List<String> getSuperclasses() {
    return superclasses;
  }

  public void setSuperclasses(List<String> superclasses) {
    this.superclasses = superclasses;
  }

  public List<Node> getMembers() {
    return members;
  }

  public void setMembers(List<Node> members) {
    this.members = members;
  }

}
