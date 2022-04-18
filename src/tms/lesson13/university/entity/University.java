package tms.lesson13.university.entity;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String id;
    private String name;
    private List<Group> groups = new ArrayList<>();

    public University(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "ID: " + id + " " + name;
    }
}
