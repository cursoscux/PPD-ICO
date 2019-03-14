package mx.uaemex.threads;

import java.util.concurrent.ThreadLocalRandom;
import mx.uaemex.main.Productor_Consumidor_v2;
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
      synchronized (Productor_Consumidor_v2.miMonitor) {
        Productor_Consumidor_v2.miMonitor.notify();
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
