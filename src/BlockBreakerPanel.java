import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * Created by Alucard on 06-Jul-15.
 */
public class BlockBreakerPanel extends JPanel implements KeyListener {

    ArrayList<Block> blocks = new ArrayList<>();
    Block mPaddle;
    Thread mThread;
    Animate mAnimate;

    BlockBreakerPanel(){

        mPaddle = new Block(175,480,150,25,"paddle.png");

        // setup top blocks
        for (int i = 0; i<8; i++) {
            blocks.add(new Block((i*60+2),0,60,25,"blue.png"));
        }
        // do the same for each kind of block, moving them 25px lower each time
        for (int i = 0; i<8; i++) {
            blocks.add(new Block((i*60+2),25,60,25,"red.png"));
        }
        for (int i = 0; i<8; i++) {
            blocks.add(new Block((i*60+2),50,60,25,"green.png"));
        }
        for (int i = 0; i<8; i++) {
            blocks.add(new Block((i*60+2),75,60,25,"yellow.png"));
        }
        // add these two lines to read key presses
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Block b : blocks) {//for every Block b in blocks
            b.draw(g, this);
        }
        mPaddle.draw(g,this);
    }

    public void update(){
        repaint(); //update screen
    }


    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

        // start game
        if(keyEvent.getKeyCode() == KeyEvent.VK_ENTER){
            mAnimate = new Animate(this);
            mThread = new Thread(mAnimate);
            mThread.start();
        }

        // Paddle controls
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT && mPaddle.x > 0){
            mPaddle.x -= 15;
        }
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && mPaddle.x < (getWidth()-mPaddle.width)){
            mPaddle.x += 15;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
