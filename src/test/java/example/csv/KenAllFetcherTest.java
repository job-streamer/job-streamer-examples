package example.csv;

import org.junit.Test;

/**
 * @author kawasima
 */
public class KenAllFetcherTest {
    @Test
    public void test() throws Exception {
        KenAllFetcher kenAllFetcher = new KenAllFetcher();
        kenAllFetcher.process();
    }
}
