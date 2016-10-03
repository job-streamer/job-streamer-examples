package example.csv;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author kawasima
 */
public class PostalLoaderTest {
    @Test
    @Ignore("oracle jdbc driver is not exist in maven central")
    public void test() throws Exception {
        PostalLoader postalLoader = new PostalLoader();
        postalLoader.setPersistenceUnitName("test");
        List<Object> postalAddresses = new ArrayList<>();
        PostalAddress postalAddress1 = new PostalAddress();
        postalAddress1.setPostalCd("1110051");
        postalAddress1.setPrefectureKana("トウキョウト");
        postalAddress1.setCityKana("タイトウク");
        postalAddress1.setTownKana("ミスジ");
        postalAddress1.setPrefectureName("東京都");
        postalAddress1.setCityName("台東区");
        postalAddress1.setTownName("三筋");
        postalAddresses.add(postalAddress1);

        postalLoader.open(0);
        try {
            postalLoader.writeItems(postalAddresses);
        } finally {
            postalLoader.close();
        }
    }
}
