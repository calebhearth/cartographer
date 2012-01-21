package net.wakka.protean.cartographer.prototypes.beans;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {

  public Node() {
    setModifiers(new LinkedList<String>());
  }

  private String name;
  private String type;
  private List<String> modifiers;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<String> getModifiers() {
    return modifiers;
  }

  public void setModifiers(List<String> modifiers) {
    this.modifiers = modifiers;
  }

}
