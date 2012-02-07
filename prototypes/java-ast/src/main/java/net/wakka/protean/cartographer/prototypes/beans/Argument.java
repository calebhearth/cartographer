package net.wakka.protean.cartographer.prototypes.beans;

public class Argument extends Node {

  public Argument() {
    super();
    setEntityType("argument");
  }

  private String valueType;

  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

}
