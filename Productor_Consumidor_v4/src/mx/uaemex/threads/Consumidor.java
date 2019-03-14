package mx.uaemex.threads;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultListModel;
import mx.uaemex.shared.Comal;

public class Consumidor extends Thread {

  private Comal comal;
  private boolean estaCorriendo = false;
  private DefaultListModel modeloConsumidor;
  private DefaultListModel modeloProductor;

  public Consumidor(Comal comal, DefaultListModel modeloConsumidor, DefaultListModel modeloProductor) {
    this.comal = comal;
    this.modeloConsumidor = modeloConsumidor;
    this.modeloProductor = modeloProductor;
  }

  public void stopThread() {
    estaCorriendo = false;
  }

  @Override
  public void run() {
    super.run();
    estaCorriendo = true;
    while (estaCorriendo) {
      if (comal.countQuesadillas() == 0) {
        try {
          System.out.println("Esperando con hambre...");
          synchronized (comal) {            
            comal.wait();
          }
        } catch (InterruptedException ex) {
          //TODO something...
        }
      }
      Object quesadilla = comal.takeQuesadilla();
      System.out.println("Producto tomado: " + quesadilla);
      modeloConsumidor.addElement(quesadilla);
      modeloProductor.removeElementAt(modeloProductor.getSize() - 1);
      comal.writeComalStatus();
      int segundos = ThreadLocalRandom.current().nextInt(1, 3 + 1);
      try {
        Thread.sleep(segundos * 1000);
      } catch (Exception e) {
      }
    }
  }

}
