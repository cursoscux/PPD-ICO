package mx.uaemex.threads;

import java.util.Random;
import javax.swing.JTextField;

public class Hilo extends Thread{

  private boolean corriendo = true;
  private JTextField txtHilo;
  
  public Hilo(String tName, JTextField txtHilo) {
    super(tName);
    this.txtHilo = txtHilo;
  }

  @Override
  public void run() {
    super.run(); 
    while (corriendo) {
      System.out.println("Thread ejecutandose: " + super.getName());
      txtHilo.setText(super.getName());
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
    txtHilo.setText("");
  }
}
