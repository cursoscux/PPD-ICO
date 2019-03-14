package mx.uaemex.threads;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.uaemex.shared.Comal;

public class Productor extends Thread {

  private Comal comal;
  private boolean estaCorriendo = false;

  public Productor(Comal comal) {
    this.comal = comal;
  }

  @Override
  public void run() {
    super.run();
    estaCorriendo = true;
    while (estaCorriendo) {
      int segundos = ThreadLocalRandom.current().nextInt(1, 5 + 1);
      comal.addQuesadilla("Quesadilla " + segundos);
      synchronized (comal) {
//        try {
//          FileWriter fw = new FileWriter("comal.txt", true);
//          BufferedWriter bw = new BufferedWriter(fw);
//          bw.write("Quesadilla " + segundos);
//          bw.newLine();
//          bw.close();
//        } catch (IOException ex) {
//          //TODO something... someday...
//        }
        comal.writeComalStatus();
        comal.notify();
      }
      try {
        System.out.println("Quesadillas en el comal: " + comal);
        Thread.sleep(segundos * 1000);
      } catch (Exception e) {
      }
    }
  }

  public void stopThread() {
    estaCorriendo = false;
  }

}
