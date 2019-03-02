package sdi.training.dto;

import java.util.List;

public class CatPassportContent {

    private String name;
    private String passportId;
    private Long age;
    private List<String> vaccine;
    private String image;

    public CatPassportContent(String name, String passportId, Long age,
                              List<String> vaccine, String image) {
        this.name = name;
        this.passportId = passportId;
        this.age = age;
        this.vaccine = vaccine;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public List<String> getVaccine() {
        return vaccine;
    }

    public void setVaccine(List<String> vaccine) {
        this.vaccine = vaccine;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
