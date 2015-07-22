package example;

import javax.batch.api.AbstractBatchlet;
import java.util.Random;

/**
 * @author kawasima
 */
public class RandomStatus extends AbstractBatchlet {
    @Override
    public String process() throws Exception {
        return "STATE" + (new Random().nextInt(5));
    }
}
