package tms.lesson13.university.repository;

import tms.lesson13.university.entity.Student;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentDataBase implements DataBase<Student> {
    private List<Student> students = new ArrayList<>();

    @Override
    public void initialization() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("student.txt"))) {
            while (fileReader.ready()) {
                String string = fileReader.readLine().trim();
                String[] information = string.split("&");
                if (information.length < 5) {
                    students.add(new Student(information[0], information[1], information[2], information[3], new ArrayList<>()));
                } else {
                    students.add(new Student(information[0], information[1], information[2], information[3], getAssessments(information[4])));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        averageStudentScore();
    }

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void delete(String id) {
        students.removeIf(student -> (student.getId() + "." + student.getGroupId() + "." + student.getUniversityId()).equals(id));
    }

    public void deleteStudentsByGroupId(String groupId) {
        students.removeIf(student -> (student.getGroupId() + "." + student.getUniversityId()).equals(groupId));
    }

    public void deleteStudentsByUniversityId(String universityId) {
        students.removeIf(student -> student.getUniversityId().equals(universityId));
    }

    @Override
    public Optional<Student> get(String fullId) {
        return students.stream().filter(student -> (student.getId() + "." + student.getGroupId() + "." +
                student.getUniversityId()).equals(fullId)).findFirst();
    }

    @Override
    public void getInformation() {
        int quantity = students.size();
        System.out.printf("В базе данных %s %s, список:\n", quantity, studentFormatter(quantity));
        students.forEach(System.out::println);
    }

    public List<Student> getStudentsByGroupId(String groupId) {
        return students.stream().filter(student -> (student.getGroupId() + "." + student.getUniversityId()).equals(groupId)).
                sorted(Comparator.comparingDouble(student -> Double.parseDouble(student.getAverageScore()))).collect(Collectors.toList());
    }

    public void printStudentsByUniversityId(String universityId) {
        students.stream().filter(student -> student.getUniversityId().equals(universityId)).forEach(System.out::println);
    }

    @Override
    public void record() {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("student.txt"))) {
            for (Student student : students) {
                fileWriter.write(student.getId() + "&" + student.getGroupId() + "&" + student.getUniversityId()
                        + "&" + student.getName() + "&" + writeAssessments(student.getAssessments()) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void averageStudentScore() {
        students.forEach(student -> {
            if (student.getAssessments().size() > 0) {
                student.setAverageScore(String.valueOf((double) student.getAssessments().stream().
                        mapToInt(Integer::valueOf).sum() / student.getAssessments().size()));
            } else {
                student.setAverageScore("0");
            }
        });
    }

    public String nextId() {
        StringBuilder id;
        if (students.size() == 0) {
            id = new StringBuilder("1");
        } else {
            id = new StringBuilder(String.valueOf(Integer.parseInt(students.get(students.size() - 1).getId()) + 1));
        }
        while (id.length() < 3) {
            id.insert(0, "0");
        }
        return id.toString();
    }

    private void addAssessment(String id, String assessment) {
        get(id).get().getAssessments().add(assessment);
    }

    private List<String> getAssessments(String string) {
        String[] assessments = string.split(",");
        return Arrays.asList(assessments);
    }

    private String writeAssessments(List<String> assessments) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String assess : assessments) {
            stringBuilder.append(assess).append(",");
        }
        return stringBuilder.toString();
    }

    private String studentFormatter(int quantity) {
        String string;
        int value100 = quantity % 100;
        int value10 = value100 % 10;
        if (value100 == 0 || value100 > 4 && value100 < 21) {
            string = "студентов";
        } else if (value10 > 1 && value10 < 5) {
            string = "студента";
        } else {
            string = "студент";
        }
        return string;
    }

    public List<Student> getStudents() {
        return students;
    }
}
