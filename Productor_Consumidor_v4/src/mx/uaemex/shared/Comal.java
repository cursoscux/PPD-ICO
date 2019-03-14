package mx.uaemex.shared;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Comal {

  private ArrayList comal;

  public void writeComalStatus(){
    try {
      FileWriter fw = new FileWriter("comal.txt", false);
      BufferedWriter bw = new BufferedWriter(fw);
      //Escribir...
      for (int i = 0; i < comal.size(); i++) {
        bw.write((String) comal.get(i));
        bw.newLine();
      }
      bw.close();
    } catch(IOException ex){
      //TODO something...
    }
  }
  
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
