/*
 * esta clase dibuja triángulos

 */
package codigo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

/**
 *
 * @author Jorge Cisneros
 */
public class Triangulo extends Polygon {

    public Color color = null;
    public boolean relleno = false;

    public Triangulo(int _posX, int _posY, int _altura, Color _color, boolean _relleno) {
        this.npoints = 3;
        //primera coordenada del triángulo, el punto (X0 Y0)
        this.xpoints[0] = _posX;
        this.ypoints[0] = _posY;

        //escribo las Y que coinciden con el valor de la altura
        this.ypoints[1] = _posY + _altura;
        this.ypoints[2] = _posY + _altura;

        int mediaBase = (int) (_altura / Math.tan(Math.toRadians(60)));

        this.xpoints[1] = _posX + mediaBase;
        this.xpoints[2] = _posX - mediaBase;

        color = _color;
        relleno = _relleno;
    }

    public void dibujate(Graphics2D g2, int _posY) {
        //redibujas el triángulo
        int altura = Math.abs((int) ypoints[0] - _posY);
        this.ypoints[1] = _posY + altura;
        this.ypoints[2] = _posY + altura;

        int mediaBase = (int) (altura / Math.sin(Math.toRadians(60)));

        this.xpoints[1] = this.xpoints[0] + mediaBase;
        this.xpoints[2] = this.xpoints[0] - mediaBase;        

        g2.setColor(color);
        if (relleno) {
            g2.fill(this);
        } else {
            g2.draw(this);
        }
    }
}
