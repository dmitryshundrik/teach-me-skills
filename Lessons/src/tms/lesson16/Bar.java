package tms.lesson16;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Bar {
    private Human human;
    private List<Alcohol> alcoholList;
    @JsonIgnore
    private String address;

    public Bar() {
    }

    public Bar(Human human, List<Alcohol> alcoholList, String address) {
        this.human = human;
        this.alcoholList = alcoholList;
        this.address = address;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public List<Alcohol> getAlcoholList() {
        return alcoholList;
    }

    public void setAlcoholList(List<Alcohol> alcoholList) {
        this.alcoholList = alcoholList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "human=" + human +
                ", alcoholList=" + alcoholList +
                ", address='" + address + '\'' +
                '}';
    }
}

