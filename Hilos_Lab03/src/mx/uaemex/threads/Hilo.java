package mx.uaemex.threads;

import java.util.Random;

public class Hilo extends Thread{

  private boolean corriendo = true;
  
  public Hilo(String tName) {
    super(tName);
  }

  @Override
  public void run() {
    super.run(); 
    while (corriendo) {
      System.out.println("Thread ejecutandose: " + super.getName());
      Random aleatorio = new Random(System.currentTimeMillis());
      int segundos = aleatorio.nextInt(4);
      try {
        Thread.sleep(segundos*1000);
      } catch (Exception ex) {
        //TODO something...
        ex.printStackTrace();
      }
    }
  }
  
  public void stopHilo_01() {
    corriendo = false;
  }
}
