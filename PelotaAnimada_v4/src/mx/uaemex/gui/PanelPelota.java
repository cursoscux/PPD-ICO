package mx.uaemex.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;
import mx.uaemex.animaciones.PelotaRebotadora;

public class PanelPelota extends JPanel {

  public PanelPelota() {
    setDoubleBuffered(true);
  }

  Image img = Toolkit.getDefaultToolkit().getImage("pelota.png");

  public void add(PelotaRebotadora b) {
    pelotas.add(b);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    for (PelotaRebotadora p : pelotas) {
      g2.drawImage(img, p.x, p.y, p.TAMX, p.TAMY, this);

    }
    
  }

  private ArrayList<PelotaRebotadora> pelotas = new ArrayList<PelotaRebotadora>();
}
