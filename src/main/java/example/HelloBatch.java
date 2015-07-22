package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import java.util.Random;

/**
 * @author kawasima
 */
public class HelloBatch extends AbstractBatchlet {
    private static Logger LOG = LoggerFactory.getLogger(HelloBatch.class);
    @Override
    public String process() throws Exception {
        LOG.info("start hello.");
        Thread.sleep(new Random().nextInt(10000));
        LOG.info("end hello.");
        return BatchStatus.COMPLETED.name();
    }
}
