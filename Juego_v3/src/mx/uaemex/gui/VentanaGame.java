package mx.uaemex.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.JFrame;
import mx.uaemex.sprites.Animation;
import mx.uaemex.sprites.PanelGameScene;
import mx.uaemex.sprites.Sprite;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class VentanaGame extends JFrame implements Runnable, KeyListener {

  private PanelGameScene pGameScene;
  
  private BufferedImage[] walkingLeft = {Sprite.getSprite(0, 1), Sprite.getSprite(1, 1), Sprite.getSprite(2, 1)}; // Gets the upper left images of my sprite sheet
  private BufferedImage[] walkingRight = {Sprite.getSprite(0, 2), Sprite.getSprite(1, 2), Sprite.getSprite(2, 2)};
  private BufferedImage[] walkingUp = {Sprite.getSprite(0, 3), Sprite.getSprite(1, 3), Sprite.getSprite(2, 3)};
  private BufferedImage[] walkingDown = {Sprite.getSprite(0, 0), Sprite.getSprite(1, 0), Sprite.getSprite(2, 0)};
  private BufferedImage[] standing = {Sprite.getSprite(1, 0)};

  private int frameDelay = 15;
// These are animation states
  private Animation walkLeft = new Animation(walkingLeft, frameDelay);
  private Animation walkRight = new Animation(walkingRight, frameDelay);
  private Animation walkUp = new Animation(walkingUp, frameDelay);
  private Animation walkDown = new Animation(walkingDown, frameDelay);
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
    playMusic();
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
    switch (code) {
      case KeyEvent.VK_DOWN:
        currentAnimation = walkDown;
        break;
      case KeyEvent.VK_UP:
        currentAnimation = walkUp;
        break;
      case KeyEvent.VK_LEFT:
        currentAnimation = walkLeft;
        walkDirection = PanelGameScene.WALK_LEFT;
        break;
      case KeyEvent.VK_RIGHT:
        currentAnimation = walkRight;
        walkDirection = PanelGameScene.WALK_RIGHT;
        break;
      default:
        break;
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

  public void playMusic() {
    AudioPlayer MGP = AudioPlayer.player;
    AudioStream BGM;
    AudioData MD;
    ContinuousAudioDataStream loop = null;
    try {
      BGM = new AudioStream(new FileInputStream("res/music.wav"));
      MD = BGM.getData();
      loop = new ContinuousAudioDataStream(MD);
    } catch (IOException error) {
      System.out.print("file not found or to big!");
      error.printStackTrace();
    }

    MGP.start(loop);
  }
  
}
