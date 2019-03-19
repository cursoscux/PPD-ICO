package mx.uaemex.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import mx.uaemex.sprites.PanelGameScene;
import mx.uaemex.sprites.Sprite;

public class VentanaGame extends JFrame implements Runnable, KeyListener {

  private PanelGameScene pGameScene;
  private BufferedImage[] walkingDown = {Sprite.getSprite(0, 0),
    Sprite.getSprite(1, 0), Sprite.getSprite(2, 0)};
  private int frameDelay = 15; //milisegundos

  public VentanaGame() {
    setSize(700, 400);
    setTitle("Juego v1.0");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    addKeyListener(this);
    
    pGameScene = new PanelGameScene();
    add(pGameScene);

    setVisible(true);
    
    Thread hiloGame = new Thread(this);
    hiloGame.start();
  }

  @Override
  public void run() {
    while (true) {
      pGameScene.setFrameHero(walkingDown[1]);
      pGameScene.repaint();
      try {
        Thread.sleep(frameDelay);
      } catch (Exception ex) {
      }
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_LEFT) {
      pGameScene.walkLeft();
      //System.out.println("Moviendo a la izq");
    } else if (code == KeyEvent.VK_RIGHT) {
      pGameScene.walkRight();
      //System.out.println("Moviendo a la der");
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    
  }

}
