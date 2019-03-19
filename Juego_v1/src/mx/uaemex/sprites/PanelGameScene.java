package mx.uaemex.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelGameScene extends JPanel {

  private BufferedImage frameHero;
  private int posX = 350;
  private int posY = 325;
  
  public void setFrameHero(BufferedImage frameHero) {
    this.frameHero = frameHero;
  }

  public PanelGameScene() {
    setDoubleBuffered(true);
  }

  public void walkLeft() {
    posX-=5; 
    if (posX < 0) {
      posX = 0;
    }
  }
  
  public void walkRight() {
    posX+=5;
    if (posX > (getWidth() - frameHero.getWidth())) {
      posX = (getWidth() - frameHero.getWidth());
    }
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    setBackground(Color.black);
    g.drawImage(frameHero, posX, posY, null);
  }

}
