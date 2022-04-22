package tms.lesson16;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alcohol {
    @JsonProperty(value = "alcohol")
    String alcoholBrand;

    public Alcohol() {
    }

    public Alcohol(String alcoholBrand) {
        this.alcoholBrand = alcoholBrand;
    }

    public String getAlcoholBrand() {
        return alcoholBrand;
    }

    public void setAlcoholBrand(String alcoholBrand) {
        this.alcoholBrand = alcoholBrand;
    }

    @Override
    public String toString() {
        return "Alcohol{" +
                "alcoholBrand='" + alcoholBrand + '\'' +
                '}';
    }
}
