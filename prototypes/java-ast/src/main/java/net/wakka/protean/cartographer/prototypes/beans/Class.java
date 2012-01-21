package net.wakka.protean.cartographer.prototypes.beans;

import java.util.LinkedList;
import java.util.List;

public class Class extends Node {

  public Class() {
    super();
    setType("class");
    interfaces = new LinkedList<String>();
    superclasses = new LinkedList<String>();
    members = new LinkedList<Node>();
  }

  private List<String> interfaces;
  private List<String> superclasses;
  private List<Node> members;

  public List<String> getInterfaces() {
    return interfaces;
  }

  public void setInterfaces(List<String> interfaces) {
    this.interfaces = interfaces;
  }

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
