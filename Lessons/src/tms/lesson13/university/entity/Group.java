package tms.lesson13.university.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String id;
    private String universityId;
    private String name;
    private List<Student> students = new ArrayList<>();
    private String averageScore;

    public Group(String id, String universityId, String name) {
        this.id = id;
        this.universityId = universityId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUniversityId() {
        return universityId;
    }

    public String getFullId() {
        return id + "." + universityId;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "ID: " + id + "." + universityId + " " + name;
    }
}
