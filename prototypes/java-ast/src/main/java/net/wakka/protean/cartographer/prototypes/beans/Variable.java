package net.wakka.protean.cartographer.prototypes.beans;

public class Variable extends Node {

  public Variable() {
    super();
    setEntityType("variable");
  }

  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
