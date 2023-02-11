package platform.codingnomads.co.springdata.example.springdatajdbc;

import lombok.Data;

@Data
public class Snowboard {
    private long id;
    private String brand;
    private String type;
    private String length;

    public Snowboard(long id,String brand, String type, String length) {
        this.brand = brand;
        this.type = type;
        this.length = length;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
