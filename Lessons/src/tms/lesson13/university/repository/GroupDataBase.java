package tms.lesson13.university.repository;

import tms.lesson13.university.entity.Group;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupDataBase implements DataBase<Group> {
    private List<Group> groups = new ArrayList<>();
    private StudentDataBase studentDataBase;

    public GroupDataBase(StudentDataBase studentDataBase) {
        this.studentDataBase = studentDataBase;
    }

    @Override
    public void initialization() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("group.txt"))) {
            while (fileReader.ready()) {
                String groupInfo = fileReader.readLine().trim();
                groups.add(new Group(groupInfo.split(" ")[0], groupInfo.split(" ")[1], groupInfo.split(" ")[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        initializationGroupsAndScore();
    }

    @Override
    public void add(Group group) {
        groups.add(group);
    }

    @Override
    public void delete(String id) {
        groups.removeIf(group -> (group.getId() + "." + group.getUniversityId()).equals(id));
    }

    public void deleteGroupsByUniversityId(String universityId) {
        groups.removeIf(group -> group.getUniversityId().equals(universityId));
    }

    @Override
    public Optional<Group> get(String fullId) {
        return groups.stream().filter(group -> (group.getFullId()).equals(fullId)).findFirst();
    }

    @Override
    public void getInformation() {
        int quantity = groups.size();
        System.out.printf("В базе данных %s %s, список:\n", quantity, groupFormatter(quantity));
        groups.forEach(System.out::println);
    }

    public List<Group> getGroupsByUniversityId(String universityId) {
        return groups.stream().filter(group -> ( group.getUniversityId()).equals(universityId)).
                sorted(Comparator.comparingDouble(group -> group.getAverageScore() != null ?
                        Double.parseDouble(group.getAverageScore()) : 0.0)).collect(Collectors.toList());
    }

    public void printGroupsByUniversityId(String universityId) {
        getGroupsByUniversityId(universityId).forEach(System.out::println);
    }


    @Override
    public void record() {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("group.txt"))) {
            for (Group group : groups) {
                fileWriter.write(group.getId() + " " + group.getUniversityId() + " " + group.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializationGroupsAndScore() {
        groups.forEach(group -> {
            group.setStudents(studentDataBase.getStudentsByGroupId(group.getFullId()));
            if (group.getStudents().size() > 0) {
                group.setAverageScore(String.valueOf(group.getStudents().stream().mapToDouble(student -> Double.parseDouble(student.getAverageScore())).sum() /
                        group.getStudents().size()));
            } else {
                group.setAverageScore("0");
            }
        });

    }

    public String nextId() {
        StringBuilder id;
        if (groups.size() == 0) {
            id = new StringBuilder("1");
        } else {
            id = new StringBuilder(String.valueOf(Integer.parseInt(groups.get(groups.size() - 1).getId()) + 1));
        }
        while (id.length() < 3) {
            id.insert(0, "0");
        }
        return id.toString();
    }

    private String groupFormatter(int quantity) {
        String string;
        int value100 = quantity % 100;
        int value10 = value100 % 10;
        if (value100 == 0 || value100 > 4 && value100 < 21) {
            string = "групп";
        } else if (value10 > 1 && value10 < 5) {
            string = "группы";
        } else {
            string = "группа";
        }
        return string;
    }

    public List<Group> getGroups() {
        return groups;
    }
}
