package hilos_lab03;

import mx.uaemex.threads.Hilo;

public class Hilos_Lab03 {

  public static void main(String[] args) {
    Hilo hilos[] = new Hilo[2000];
    
    for (int i = 0; i < hilos.length; i++) {
      hilos[i] = new Hilo("Hilo " + (i + 1));
      hilos[i].start();
    }
    
  }
  
}
