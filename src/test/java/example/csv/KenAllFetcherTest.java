package example.csv;

import javax.enterprise.inject.spi.CDI;

import org.jboss.weld.environment.se.Weld;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kawasima
 */
public class KenAllFetcherTest {
    @BeforeClass
    public static void initContainer() {
        new Weld().initialize();
    }
    @Test
    @Ignore("oracle jdbc driver is not exist in maven central")
    public void test() throws Exception {
        KenAllFetcher kenAllFetcher = CDI.current().select(KenAllFetcher.class).get();
        kenAllFetcher.process();
    }
}
