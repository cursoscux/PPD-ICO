package mx.uaemex.threads;

import java.util.Random;
import javax.swing.JTextArea;

public class GeneraAleatorioThread extends Thread{

  private boolean estaCorriendo = false;
  private JTextArea txtInfo;
  public GeneraAleatorioThread(String name, JTextArea txtInfo) {
    this.setName(name);
    this.txtInfo = txtInfo;
  }
  
  @Override
  public void run() {
    super.run(); 
    estaCorriendo = true;
    while (estaCorriendo) {
      Random aleatorio = new Random(System.currentTimeMillis());
      int segundos = aleatorio.nextInt(4) + 1;
      txtInfo.setText(txtInfo.getText() + "Hilo " + getName() + 
              ", Tiempo de espera: " + segundos + "\n");
      System.out.println("Hilo " + getName() + 
              ", Tiempo de espera: " + segundos);
      try {
        Thread.sleep(segundos*1000);
      } catch (Exception ex) {
        //TODO something...
        ex.printStackTrace();
      }
    }
  }
  
  public void stopThread() {
    estaCorriendo = false;
  }
  
}
