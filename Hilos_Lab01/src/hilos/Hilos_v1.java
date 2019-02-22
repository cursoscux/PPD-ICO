
package hilos;

public class Hilos_v1 {

  public static void main(String[] args) {
    HiloHeredado hilo1 = new HiloHeredado();
    HiloHeredado hilo2 = new HiloHeredado();
    
    hilo2.algunMetodo();
    hilo1.algunMetodo();
    
    hilo1.start(); //Crea un hilo adicional
    hilo2.start(); //Crea un hilo adicional
    
    HiloImplementado hr = new HiloImplementado();
    Thread hilo3 = new Thread(hr);
    hilo3.start();
  }
  
}
