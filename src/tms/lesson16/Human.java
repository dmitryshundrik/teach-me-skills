package tms.lesson16;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Human {
    @JsonProperty(value = "nameOfVisitor")
    private String name;
    @JsonProperty(value = "ageOfVisitor")
    private String age;

    public Human() {
    }

    public Human(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
