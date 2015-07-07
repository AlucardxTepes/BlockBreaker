import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Created by Alucard on 06-Jul-15.
 */
public class Block extends Rectangle {
    Image pic;
    // movement speed
    int dx = 3;
    int dy = -3;
    Rectangle left, right;


    boolean destroyed = false;

    Block(int a, int b, int w, int h, String s){
        x = a;
        y = b;
        width = w;
        height = h;
        left = new Rectangle(a-1, b, 1, h);
        right = new Rectangle(a+w+1, b, 1, h);
        pic = Toolkit.getDefaultToolkit().getImage(s);
    }

    public void draw(Graphics g, Component c){
        if(!destroyed) { // draw if not destroyed
            g.drawImage(pic, x, y, width, height, c);
        }
    }

}
