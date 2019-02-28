package mx.uaemex.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;
import mx.uaemex.animaciones.PelotaRebotadora;

public class PanelPelota extends JPanel {

  public void add(PelotaRebotadora b) {
    pelotas.add(b);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    Image img = Toolkit.getDefaultToolkit().getImage("pelota.png");
    int desface = 0;
    for (PelotaRebotadora p : pelotas) {
      g2.drawImage(img, p.x + desface, p.y + desface, p.TAMX, p.TAMY, this);
//      try {
//        Thread.sleep(1);
//      } catch (InterruptedException ex) {
//        //TODO something...
//      }
      desface+=32;
    }

  }

  private ArrayList<PelotaRebotadora> pelotas = new ArrayList<PelotaRebotadora>();
}
