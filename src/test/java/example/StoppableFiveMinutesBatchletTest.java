package example;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.batch.runtime.BatchStatus;

import org.junit.Test;

public class StoppableFiveMinutesBatchletTest {
    private final static StoppableFiveMinutesBatchlet TARGET = new StoppableFiveMinutesBatchlet();

    @Test
    public void testItCanStop() throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(() -> {
            return TARGET.process();});
        TARGET.stop();
        assertThat(future.get(), is(BatchStatus.STOPPED.toString()));
    }

}
