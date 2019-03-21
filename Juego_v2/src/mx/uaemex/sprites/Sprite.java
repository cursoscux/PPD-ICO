package mx.uaemex.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Sprite {

  private static BufferedImage spriteSheet;
  private static final int TILE_SIZE_X = 32;
  private static final int TILE_SIZE_Y = 32;
  
  public static BufferedImage loadSprite(String file) {

    BufferedImage sprite = null;

    try {
      sprite = ImageIO.read(new File("res/" + file + ".png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    return sprite;
  }

  public static BufferedImage getSprite(int xGrid, int yGrid) {

    if (spriteSheet == null) {
      spriteSheet = loadSprite("hero");
    }

    return spriteSheet.getSubimage(xGrid * TILE_SIZE_X, yGrid * TILE_SIZE_Y, TILE_SIZE_X, TILE_SIZE_Y);
  }
}
