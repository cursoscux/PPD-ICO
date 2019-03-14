package mx.uaemex.shared;

import java.util.ArrayList;

public class Comal {

  private ArrayList comal;

  public Comal() {
    comal = new ArrayList();
  }
  
  public int countQuesadillas() {
    return comal.size();
  }
  
  public void addQuesadilla(Object quesadilla) {
    comal.add(quesadilla);
  }
  
  public Object takeQuesadilla() {
    Object quesadilla = comal.remove(comal.size()-1);
    return quesadilla;
  }

  @Override
  public String toString() {
    return comal.toString();
  }
  
  
}
