
package hilos;

public class HiloHeredado extends Thread{
  
  int id;
  String nombre;
  boolean estaCorriendo;
  
  public void algunMetodo() {
    System.out.println("Execución del método #1");
  }

  @Override
  public void run() {
    super.run();
    System.out.println("Ejecutando método run()");
  }
   
}
