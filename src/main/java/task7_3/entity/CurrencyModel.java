package task7_3.entity;

import jakarta.persistence.*;

@Entity
@Table(name="currencies")
public class CurrencyModel {

    @Id
    String abbreviation;
    String name;
    double conversion_rate;

    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getConversion_rate() {
        return conversion_rate;
    }

    public CurrencyModel(String abbreviation, String name, double conversion_rate) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversion_rate = conversion_rate;
    }

    public CurrencyModel() {

    }
}