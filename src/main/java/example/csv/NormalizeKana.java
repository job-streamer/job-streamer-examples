package example.csv;


import org.apache.commons.csv.CSVRecord;

import javax.batch.api.chunk.ItemProcessor;
import java.text.Normalizer;

/**
 * @author kawasima
 */
public class NormalizeKana implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        if (!(item instanceof CSVRecord)) {
            throw new CSVFormatException(item + " isn't CSVRecord");
        }

        CSVRecord record = (CSVRecord) item;
        PostalAddress dto = new PostalAddress();
        dto.setPostalCd(record.get("POSTAL_CD"));

        dto.setPrefectureKana(
                Normalizer.normalize(record.get("PREFECTURE_KANA"), Normalizer.Form.NFKC));
        dto.setCityKana(
                Normalizer.normalize(record.get("CITY_KANA"), Normalizer.Form.NFKC));
        dto.setTownKana(
                Normalizer.normalize(record.get("TOWN_KANA"), Normalizer.Form.NFKC));
        dto.setPrefectureName(record.get("PREFECTURE_NAME"));
        dto.setCityName(record.get("CITY_NAME"));
        dto.setTownName(record.get("TOWN_NAME"));

        return dto;
    }
}
