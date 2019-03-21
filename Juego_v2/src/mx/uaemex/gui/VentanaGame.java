package mx.uaemex.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import mx.uaemex.sprites.Animation;
import mx.uaemex.sprites.PanelGameScene;
import mx.uaemex.sprites.Sprite;

public class VentanaGame extends JFrame implements Runnable, KeyListener {

  private PanelGameScene pGameScene;
  
  private BufferedImage[] walkingDown = {Sprite.getSprite(0, 0),
    Sprite.getSprite(1, 0), Sprite.getSprite(2, 0)};
  
  private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2),
    Sprite.getSprite(1, 2), Sprite.getSprite(2, 2)};
          
  private BufferedImage[] standing = {Sprite.getSprite(1, 0)};
  
  private int frameDelay = 15; //milisegundos

  private Animation walkDown = new Animation(walkingDown, frameDelay);
  private Animation walkRight = new Animation(walkingRight, frameDelay);
  private Animation stand = new Animation(standing, frameDelay);
  
  private Animation currentAnimation = stand;
  
  private int walkDirection = PanelGameScene.WALK_STAND;
  
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
    
    currentAnimation.start();
  }

  public void updatePanel() {
    pGameScene.setFrameHero(currentAnimation.getSprite());
    pGameScene.updatePosition(walkDirection);
    pGameScene.repaint();
  }
  
  @Override
  public void run() {
    while (true) {
      currentAnimation.update();
      updatePanel();
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
      walkDirection = PanelGameScene.WALK_LEFT;
      //System.out.println("Moviendo a la izq");
    } else if (code == KeyEvent.VK_RIGHT) {
      currentAnimation = walkRight;
      walkDirection = PanelGameScene.WALK_RIGHT;
      //System.out.println("Moviendo a la der");
    }
    
    currentAnimation.start();
  }

  @Override
  public void keyReleased(KeyEvent e) {
    currentAnimation.stop();
    currentAnimation.reset();
    currentAnimation = stand;
    walkDirection = PanelGameScene.WALK_STAND;
  }

}
