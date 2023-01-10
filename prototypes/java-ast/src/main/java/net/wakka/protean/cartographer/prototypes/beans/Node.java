package net.wakka.protean.cartographer.prototypes.beans;

import java.util.LinkedList;
import java.util.List;

public abstract class Node {

  public Node() {
    setModifiers(new LinkedList<String>());
  }

  private String identifier;
  private String entityType;
  private List<String> modifiers;

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getEntityType() {
    return entityType;
  }

  public void setEntityType(String entityType) {
    this.entityType = entityType;
  }

  public List<String> getModifiers() {
    return modifiers;
  }

  public void setModifiers(List<String> modifiers) {
    this.modifiers = modifiers;
  }

}
