package mx.uaemex.animaciones;

import java.awt.geom.Rectangle2D;

public class PelotaRebotadora {
    
    // Mueve la pelota invirtiendo posición si choca con límites
    public void mueve_pelota(Rectangle2D limites) {

        x += dx;
        y += dy;
        if (x < limites.getMinX()) {         
            x = (int) limites.getMinX();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            x = (int) (limites.getMaxX() - TAMX);
            dx = -dx;
        }

        if (y < limites.getMinY()) {
            y = (int) limites.getMinY();
            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {
            y = (int) (limites.getMaxY() - TAMY);
            dy = -dy;
        }
    }
            
    public static final int TAMX = 32;
    public static final int TAMY = 32;
    public int x = 0;
    public int y = 0;
    private int dx = 1;
    private int dy = 1;
}
