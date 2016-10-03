package example.csv;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kawasima
 */
public class PostalReaderTest {
    @Test
    @Ignore("oracle jdbc driver is not exist in maven central")
    public void test() throws Exception {
        PostalReader reader = new PostalReader();
        try {
            reader.open(0);
            System.out.println(reader.readItem());
        } finally {
            reader.close();
        }
    }
}
