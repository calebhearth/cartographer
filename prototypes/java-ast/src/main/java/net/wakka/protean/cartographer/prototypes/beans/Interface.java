package net.wakka.protean.cartographer.prototypes.beans;

import java.util.List;

public class Interface extends Node {

  public Interface() {
    super();
    setType("interface");
  }

  private List<Interface> superinterfaces;
  private List<Node> members;

  public List<Interface> getSuperinterfaces() {
    return superinterfaces;
  }

  public void setSuperinterfaces(List<Interface> superinterfaces) {
    this.superinterfaces = superinterfaces;
  }

  public List<Node> getMembers() {
    return members;
  }

  public void setMembers(List<Node> members) {
    this.members = members;
  }

}
