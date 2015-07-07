/**
 * Created by Alucard on 06-Jul-15.
 */
public class Animate implements Runnable {

    BlockBreakerPanel mBlockBreakerPanel;

    Animate(BlockBreakerPanel b){
        mBlockBreakerPanel = b;
    }

    @Override
    public void run() {
        while (true){
            mBlockBreakerPanel.update();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
