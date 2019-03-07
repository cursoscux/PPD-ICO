package mx.uaemex.threads;

import java.util.concurrent.ThreadLocalRandom;
import mx.uaemex.shared.Comal;

public class Consumidor extends Thread{

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
      System.out.println("Producto tomado: " + comal.takeQuesadilla());
      int segundos = ThreadLocalRandom.current().nextInt(1, 5 + 1);
      try {
        Thread.sleep(segundos * 1000);
      } catch (Exception e) {
      }
    }
  }
  
  
}
