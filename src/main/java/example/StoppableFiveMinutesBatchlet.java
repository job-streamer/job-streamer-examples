package example;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sleep 5 minutes.
 * 
 * @author kawasima
 */
public class StoppableFiveMinutesBatchlet extends AbstractStoppableBatchlet {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractStoppableBatchlet.class);

    @Override
    public void containerProcess() throws Exception{
        for (int i = 0; i < 5; i++) {
            TimeUnit.MINUTES.sleep(1);
            LOG.info(i + "minutes.");
        }
    }

    @Override
    public void whenStop() {
        LOG.info("stopped.");
    }
}
