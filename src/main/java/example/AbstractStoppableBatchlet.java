package example;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;

/**
 * 
 * @author Yuki Seki
 *
 */
public abstract class AbstractStoppableBatchlet extends AbstractBatchlet{
    private static final int THREAD_SLEEP = 1000;
    private volatile boolean running = false;

    @Override
    public void stop() throws Exception{
        running = false;
        super.stop();
    }

    @Override
    public String process() throws Exception{
        running = true;
        ContainerRunner containerRunner = new ContainerRunner();
        Thread containerThread = new Thread(containerRunner);
        containerThread.start();
        while (running) {
            try {
                containerThread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e){
                whenStop();
                return BatchStatus.STOPPED.toString();
            }
        }
        running = false;
        return BatchStatus.COMPLETED.toString();
    }
    
    public abstract void whenStop();

    public abstract void containerProcess() throws Exception;

    public class ContainerRunner implements Runnable{

        @Override
        public void run(){
            try {
                containerProcess();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }


}
