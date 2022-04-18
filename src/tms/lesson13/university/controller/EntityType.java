package tms.lesson13.university.controller;

public enum EntityType {

    STUDENT("СТУДЕНТ"), GROUP("ГРУППА"), UNIVERSITY("УНИВЕРСИТЕТ");

    private String name;

    EntityType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
