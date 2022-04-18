package tms.lesson13.university.entity;

import java.util.List;

public class Student {
    private String id;
    private String groupId;
    private String universityId;
    private String name;
    private List<String> assessments;
    private String averageScore;

    public Student(String id, String groupId, String universityId, String name, List<String> assessments) {
        this.id = id;
        this.groupId = groupId;
        this.universityId = universityId;
        this.name = name;
        this.assessments = assessments;
    }

    public String getId() {
        return id;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getUniversityId() {
        return universityId;
    }

    public String getFullId() {
        return id + "." + groupId + "." + universityId;
    }

    public String getName() {
        return name;
    }

    public List<String> getAssessments() {
        return assessments;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "ID: " + id + "." + groupId + "." + universityId + " " + name;
    }
}
