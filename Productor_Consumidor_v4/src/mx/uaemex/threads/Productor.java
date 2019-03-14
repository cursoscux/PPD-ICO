package mx.uaemex.threads;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultListModel;
import mx.uaemex.shared.Comal;

public class Productor extends Thread {

  private Comal comal;
  private boolean estaCorriendo = false;
  private DefaultListModel modeloProductor;

  public Productor(Comal comal, DefaultListModel modeloProductor) {
    this.comal = comal;
    this.modeloProductor = modeloProductor;
  }

  @Override
  public void run() {
    super.run();
    estaCorriendo = true;
    while (estaCorriendo) {
      int segundos = ThreadLocalRandom.current().nextInt(1, 3 + 1);
      comal.addQuesadilla("Quesadilla " + segundos);
      modeloProductor.addElement("Quesadilla " + segundos);
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
