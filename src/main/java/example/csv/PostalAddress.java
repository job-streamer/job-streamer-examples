package example.csv;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author kawasima
 */
@Entity
public class PostalAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "postal_id_gen")
    @SequenceGenerator(name="postal_id_gen", sequenceName = "postal_id_seq", allocationSize = 1)
    private Long postalId;
    private String postalCd;
    private String prefectureKana;
    private String cityKana;
    private String townKana;
    private String prefectureName;
    private String cityName;
    private String townName;

    public String getPostalCd() {
        return postalCd;
    }

    public void setPostalCd(String postalCd) {
        this.postalCd = postalCd;
    }

    public String getPrefectureKana() {
        return prefectureKana;
    }

    public void setPrefectureKana(String prefectureKana) {
        this.prefectureKana = prefectureKana;
    }

    public String getCityKana() {
        return cityKana;
    }

    public void setCityKana(String cityKana) {
        this.cityKana = cityKana;
    }

    public String getTownKana() {
        return townKana;
    }

    public void setTownKana(String townKana) {
        this.townKana = townKana;
    }

    public String getPrefectureName() {
        return prefectureName;
    }

    public void setPrefectureName(String prefectureName) {
        this.prefectureName = prefectureName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
