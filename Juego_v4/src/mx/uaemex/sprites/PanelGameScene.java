package mx.uaemex.sprites;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelGameScene extends JPanel {

  private BufferedImage frameHero;
  private BufferedImage imgBackground;

  private int posX = 350;
  private int posY = 325;

  public final static int WALK_STAND = 0; //0 = stand, 1 = walkRight, 2 = walkLeft
  public final static int WALK_LEFT = 1;
  public final static int WALK_RIGHT = 2;

  private FrameEnemy frameEnemy;

  public Point getPosition() {
    return new Point(posX, posY);
  }
  
  public void setFrameEnemy(BufferedImage frameEnemy, int posX, int posY) {
    this.frameEnemy = new FrameEnemy(frameEnemy, posX, posY);
  }

  public void setFrameHero(BufferedImage frameHero) {
    this.frameHero = frameHero;
  }

  public PanelGameScene() {
    setDoubleBuffered(true);
    try {
      imgBackground = ImageIO.read(new File("res/background.jpg"));
    } catch (IOException ex) {
    }
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
    //setBackground(Color.black);
    g.drawImage(imgBackground, 0, 0, null);
    g.drawImage(frameHero, posX, posY, null);
    g.drawImage(frameEnemy.getFrame(), 
            frameEnemy.getPosX(), frameEnemy.getPosY(), 
            null);
  }

}
