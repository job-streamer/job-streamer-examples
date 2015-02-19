package example;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import java.util.Random;

/**
 * @author kawasima
 */
public class HelloBatch extends AbstractBatchlet {
    @Override
    public String process() throws Exception {
        Thread.sleep(new Random().nextInt(10000));
        return BatchStatus.COMPLETED.name();
    }
}
