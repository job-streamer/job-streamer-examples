package example;

import javax.batch.api.AbstractBatchlet;
import java.util.Random;

/**
 * @author kawasima
 */
public class RandomFailure extends AbstractBatchlet {
    @Override
    public String process() throws Exception {
        if (new Random().nextBoolean()) {
            return "SUCCESS";
        } else {
            throw new Exception("Failure");
        }

    }
}
