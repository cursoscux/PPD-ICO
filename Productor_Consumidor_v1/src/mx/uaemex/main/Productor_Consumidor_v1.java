package mx.uaemex.main;

import mx.uaemex.shared.Comal;
import mx.uaemex.threads.Consumidor;
import mx.uaemex.threads.Productor;

public class Productor_Consumidor_v1 {

  public static void main(String[] args) {
    Comal comal = new Comal();
    Productor productor = new Productor(comal);
    Consumidor consumidor = new Consumidor(comal);
    productor.start();
    consumidor.start();
  }
  
}
