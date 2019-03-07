package mx.uaemex.threads;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.DefaultListModel;
import mx.uaemex.gui.VentanaAleatorios;

public class GeneraAleatorioThread extends Thread {

  private boolean estaCorriendo = false;
  private DefaultListModel modeloLista;

  public GeneraAleatorioThread(String name, DefaultListModel modeloLista) {
    this.setName(name);
    this.modeloLista = modeloLista;
  }

  @Override
  public void run() {
    super.run();
    estaCorriendo = true;

    while (estaCorriendo) {

      int segundos = ThreadLocalRandom.current().nextInt(1, 5 + 1);
      modeloLista.addElement(getName() + ", Tiempo de espera: " + segundos);     
      VentanaAleatorios.datos.add(getName() + ", Tiempo de espera: " + segundos);

      try {
        System.out.println("Lecturas: " + VentanaAleatorios.datos);
        Thread.sleep(segundos * 1000);
      } catch (Exception ex) {
        //TODO something...
        ex.printStackTrace();
        System.exit(0);
      }
    }
  }

  public void stopThread() {
    estaCorriendo = false;
  }

}
