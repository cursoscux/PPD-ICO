package mx.uaemex.sprites;

import java.awt.image.BufferedImage;

public class FrameEnemy {

    FrameEnemy(BufferedImage frameEnemy, int posX, int posY) {
        this.frame = frameEnemy;
        this.posX = posX;
        this.posY = posY;
    }

    public BufferedImage getFrame() {
        return frame;
    }

    public void setFrame(BufferedImage frame) {
        this.frame = frame;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    private BufferedImage frame;
    private int posX;
    private int posY;

}
