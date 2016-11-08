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
    private volatile Thread containerThread;

    @Override
    public void stop() throws Exception{
        super.stop();
        containerThread = null;
    }

    @Override
    public String process() throws Exception{
        ContainerRunner containerRunner = new ContainerRunner();
        containerThread = new Thread(containerRunner);
        containerThread.start();
        Thread thisThread = Thread.currentThread();
        while (containerThread == thisThread) {
            try {
                containerThread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e){
                whenStop();
                return BatchStatus.STOPPED.toString();
            }
        }
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
