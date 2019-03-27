package mx.uaemex.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author René Cruz Flores - Ph.D.
 */
public class SpriteEnemy {
private static BufferedImage spriteSheet;
  private static final int TILE_SIZE_X = 48;
  private static final int TILE_SIZE_Y = 64;


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
      spriteSheet = loadSprite("enemy");
    }

    return spriteSheet.getSubimage(xGrid * TILE_SIZE_X, yGrid * TILE_SIZE_Y, TILE_SIZE_X, TILE_SIZE_Y);
  }
}
