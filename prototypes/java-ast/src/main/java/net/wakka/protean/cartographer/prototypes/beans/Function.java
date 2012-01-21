package net.wakka.protean.cartographer.prototypes.beans;

import java.util.List;

public class Function extends Node {

  public Function() {
    super();
    setType("function");
  }

  private List<Argument> arguments;
  private String returnType;

  public List<Argument> getArguments() {
    return arguments;
  }

  public void setArguments(List<Argument> arguments) {
    this.arguments = arguments;
  }

  public String getReturnType() {
    return returnType;
  }

  public void setReturnType(String returnType) {
    this.returnType = returnType;
  }

}
