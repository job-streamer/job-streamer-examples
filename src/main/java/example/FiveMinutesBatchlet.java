package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import java.util.concurrent.TimeUnit;

/**
 * Sleep 5 minutes.
 * @author kawasima
 */
public class FiveMinutesBatchlet extends AbstractBatchlet {
    private static final Logger LOG = LoggerFactory.getLogger("job-streamer");

    @Override
    public String process() throws Exception {
        for (int i=0; i<5; i++) {
            TimeUnit.MINUTES.sleep(1);
            LOG.info(i + "minutes.");
        }
        return BatchStatus.COMPLETED.toString();
    }
}
