package example.csv;

import org.junit.Test;

/**
 * @author kawasima
 */
public class PostalReaderTest {
    @Test
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
