package mx.uaemex.sprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class PanelGameScene extends JPanel {

  private BufferedImage frameHero;
  private int posX = 350;
  private int posY = 325;

  public final static int WALK_STAND = 0; //0 = stand, 1 = walkRight, 2 = walkLeft
  public final static int WALK_LEFT = 1;
  public final static int WALK_RIGHT = 2;

  public void setFrameHero(BufferedImage frameHero) {
    this.frameHero = frameHero;
  }

  public PanelGameScene() {
    setDoubleBuffered(true);
  }

  public void updatePosition(int walkDirection) {
    if (walkDirection == WALK_RIGHT) {
      posX++;
      if (posX > (getWidth() - frameHero.getWidth())) {
      posX = (getWidth() - frameHero.getWidth());
    }
    } else if (walkDirection == WALK_LEFT) {
      posX--;
      if (posX < 0) {
        posX = 0;
      }
    }
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    setBackground(Color.black);
    g.drawImage(frameHero, posX, posY, null);
  }

}
