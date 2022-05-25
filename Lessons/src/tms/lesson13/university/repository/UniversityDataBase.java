package tms.lesson13.university.repository;

import tms.lesson13.university.entity.University;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UniversityDataBase implements DataBase<University> {
    private List<University> universities = new ArrayList<>();

    @Override
    public void initialization() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("university.txt"))) {
            while (fileReader.ready()) {
                String universityInfo = fileReader.readLine().trim();
                universities.add(new University(universityInfo.split(" ")[0], universityInfo.split(" ")[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(University university) {
        universities.add(university);
    }

    @Override
    public void delete(String id) {
        universities.removeIf(university -> university.getId().equals(id));
    }

    @Override
    public Optional<University> get(String id) {
        return universities.stream().filter(university -> university.getId().equals(id)).findFirst();
    }

    @Override
    public void getInformation() {
        int quantity = universities.size();
        System.out.printf("В базе данных %s %s, список:\n", quantity, universityFormatter(quantity));
        universities.forEach(System.out::println);
    }

    @Override
    public void record() {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("university.txt"))) {
            for (University university : universities) {
                fileWriter.write(university.getId() + " " + university.getName() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String nextId() {
        StringBuilder id;
        if (universities.size() == 0) {
            id = new StringBuilder("1");
        } else {
            id = new StringBuilder(String.valueOf(Integer.parseInt(universities.get(universities.size() - 1).getId()) + 1));
        }
        while (id.length() < 3) {
            id.insert(0, "0");
        }
        return id.toString();
    }

    private String universityFormatter(int quantity) {
        String string;
        int value100 = quantity % 100;
        int value10 = value100 % 10;
        if (value100 == 0 || value100 > 4 && value100 < 21) {
            string = "университетов";
        } else if (value10 > 1 && value10 < 5) {
            string = "университета";
        } else {
            string = "университет";
        }
        return string;
    }

    public List<University> getUniversities() {
        return universities;
    }
}
