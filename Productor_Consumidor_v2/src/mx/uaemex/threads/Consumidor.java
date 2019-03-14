package mx.uaemex.threads;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.uaemex.main.Productor_Consumidor_v2;
import mx.uaemex.shared.Comal;

public class Consumidor extends Thread {

  private Comal comal;
  private boolean estaCorriendo = false;

  public Consumidor(Comal comal) {
    this.comal = comal;
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
          synchronized (Productor_Consumidor_v2.miMonitor) {
            Productor_Consumidor_v2.miMonitor.wait();
          }
        } catch (InterruptedException ex) {
          //TODO something...
        }
      }
      System.out.println("Producto tomado: " + comal.takeQuesadilla());
      int segundos = ThreadLocalRandom.current().nextInt(1, 1 + 1);
      try {
        Thread.sleep(segundos * 1000);
      } catch (Exception e) {
      }
    }
  }

}
