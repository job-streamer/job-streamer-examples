package example;

import javax.batch.api.AbstractBatchlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sleep 5 minutes It can stop.
 * 
 * @author Yuki Seki
 */
public class StoppableFiveMinutesBatchlet extends AbstractBatchlet {
    private static final int THREAD_SLEEP = 1000;
    private static final int MINUTES_TO_MS = 60000;
    private static final Logger LOG = LoggerFactory.getLogger(StoppableFiveMinutesBatchlet.class);
    private volatile boolean running;

    @Override public String process() throws Exception {
        running = true;
        int threadSleapCount = 0;
        int minutes = 0;
        while (running) {
            Thread.sleep(THREAD_SLEEP);
            threadSleapCount++;
            if(threadSleapCount % MINUTES_TO_MS == 0){
                minutes++;
                LOG.info("It takes {} minutes", minutes);
            }
        }
        return null;
    }

    @Override
    public void stop() throws Exception {
        running = false;
    }
}
