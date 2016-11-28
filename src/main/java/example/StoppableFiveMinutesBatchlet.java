package example;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sleep 5 minutes.
 * It can stop.
 * 
 * @author Yuki Seki
 */
public class StoppableFiveMinutesBatchlet extends AbstractBatchlet {
    private static final int THREAD_SLEEP = 1000;
    private static final int MINUTES_TO_MS = 60000;
    private static final Logger LOG = LoggerFactory.getLogger(StoppableFiveMinutesBatchlet.class);
    private AtomicBoolean running = new AtomicBoolean();

    @Override public String process() throws Exception {
        running.compareAndSet(false, true);
        int threadSleapCount = 0;
        int minutes = 0;
        while (minutes != 5) {
            if(!running.get()){
                return BatchStatus.STOPPED.toString();
            }
            Thread.sleep(THREAD_SLEEP);
            threadSleapCount++;
            if((threadSleapCount * THREAD_SLEEP) % MINUTES_TO_MS == 0){
                minutes++;
                LOG.info("It takes {} minutes", minutes);
            }
        }
        return BatchStatus.COMPLETED.toString();
    }

    @Override
    public void stop() throws Exception {
        LOG.info("stop the batchlet");
        running.compareAndSet(true, false);
    }
}
