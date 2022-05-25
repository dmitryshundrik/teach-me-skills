package tms.lesson13.university.service;

import tms.lesson13.university.controller.EntityType;
import tms.lesson13.university.entity.Group;
import tms.lesson13.university.entity.Student;
import tms.lesson13.university.entity.University;
import tms.lesson13.university.repository.GroupDataBase;
import tms.lesson13.university.repository.StudentDataBase;
import tms.lesson13.university.repository.UniversityDataBase;
import tms.lesson13.university.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppService {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private StudentDataBase studentDataBase = new StudentDataBase();
    private GroupDataBase groupDataBase = new GroupDataBase(studentDataBase);
    private UniversityDataBase universityDataBase = new UniversityDataBase();

    public void initializationDataBase() {
        studentDataBase.initialization();

        groupDataBase.initialization();

        universityDataBase.initialization();
    }

    public void add(EntityType entityType) {
        switch (entityType) {
            case STUDENT:
                try {
                    while (true) {
                        if (universityDataBase.getUniversities().size() == 0 || groupDataBase.getGroups().size() == 0) {
                            System.out.println("Чтобы зарегестрировать студента, перейдите в основное меню" +
                                    ", создайте университет и группу.");
                            break;
                        }
                        universityDataBase.getInformation();
                        System.out.println("Для регистрации студента выберите университет и группу, выберите ID(XXX) университета:");
                        String universityId = bufferedReader.readLine().trim();
                        if (universityDataBase.get(universityId).isPresent()) {
                            groupDataBase.printGroupsByUniversityId(universityId);
                            System.out.println("Выберите ID(XXX.XXX) группы в этом университете:");
                            String groupFullId = bufferedReader.readLine().trim();
                            if (groupDataBase.get(groupFullId).isPresent()) {
                                System.out.println("Заполните ФИО студента:");
                                Student student = new Student(studentDataBase.nextId(), groupFullId.split("\\.")[0],
                                        universityId, bufferedReader.readLine().trim(), new ArrayList<>());
                                student.setAverageScore("0");
                                studentDataBase.add(student);
                                System.out.printf("Студент %s создан, ID: %s.%s.%s;\n", student.getName(), student.getId(),
                                        student.getGroupId(), student.getUniversityId());
                                Util.pressEnter();
                                break;
                            } else {
                                System.out.println("Введите корректные данные!");
                            }
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case GROUP:
                try {
                    while (true) {
                        if (universityDataBase.getUniversities().size() == 0) {
                            System.out.println("Чтобы зарегестрировать группу, перейдите в основное меню" +
                                    " и создайте университет.");
                            break;
                        }
                        universityDataBase.getInformation();
                        System.out.println("Для регистрации группы выберите ID(XXX) университета:");
                        String universityId = bufferedReader.readLine().trim();
                        if (universityDataBase.get(universityId).isPresent()) {
                            System.out.println("Заполните название группы:");
                            Group group = new Group(groupDataBase.nextId(), universityId, bufferedReader.readLine().trim());
                            group.setAverageScore("0");
                            groupDataBase.add(group);
                            System.out.printf("Группа %s создана, ID: %s.%s;\n", group.getName(), group.getId(), group.getUniversityId());
                            Util.pressEnter();
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case UNIVERSITY:
                try {
                    System.out.println("Заполните название университета:");
                    University university = new University(universityDataBase.nextId(), bufferedReader.readLine().trim());
                    universityDataBase.add(university);
                    System.out.printf("Университет %s создан, ID: %s;\n", university.getName(), university.getId());
                    Util.pressEnter();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void delete(EntityType entityType) {
        switch (entityType) {
            case STUDENT:
                try {
                    while (true) {
                        if (studentDataBase.getStudents().size() == 0) {
                            System.out.println("База данных пуста.");
                            break;
                        }
                        studentDataBase.getInformation();
                        System.out.println("Выберите ID(XXX.XXX.XXX) студента:");
                        String studentId = bufferedReader.readLine().trim();
                        System.out.println("Данные студента будут удалены безвозвратно, продолжить?\n1 ДА\n2 НЕТ");
                        String answer = bufferedReader.readLine().trim();
                        if ("ДА".equalsIgnoreCase(answer) && studentDataBase.get(studentId).isPresent()) {
                            studentDataBase.delete(studentId);
                            System.out.println("Удаление завершено!");
                            studentDataBase.getInformation();
                            Util.pressEnter();
                            break;
                        } else if ("НЕТ".equalsIgnoreCase(answer)) {
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case GROUP:
                try {
                    while (true) {
                        if (groupDataBase.getGroups().size() == 0) {
                            System.out.println("База данных пуста.");
                            break;
                        }
                        groupDataBase.getInformation();
                        System.out.println("Выберите ID(XXX.XXX) группы:");
                        String groupId = bufferedReader.readLine().trim();
                        System.out.println("Данные ВСЕЙ группы будут удалены безвозвратно, продолжить?\n1 ДА\n2 НЕТ");
                        String answer = bufferedReader.readLine().trim();
                        if ("ДА".equalsIgnoreCase(answer) && groupDataBase.get(groupId).isPresent()) {
                            groupDataBase.delete(groupId);
                            studentDataBase.deleteStudentsByGroupId(groupId);
                            System.out.println("Удаление завершено!");
                            groupDataBase.getInformation();
                            Util.pressEnter();
                            break;
                        } else if ("НЕТ".equalsIgnoreCase(answer)) {
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case UNIVERSITY:
                try {
                    while (true) {
                        if (universityDataBase.getUniversities().size() == 0) {
                            System.out.println("База данных пуста.");
                            break;
                        }
                        universityDataBase.getInformation();
                        System.out.println("Выберите ID(XXX) университета:");
                        String universityId = bufferedReader.readLine().trim();
                        System.out.println("Данные ВСЕГО университета будут удалены безвозвратно, продолжить?\n1 ДА\n2 НЕТ");
                        String answer = bufferedReader.readLine().trim();
                        if ("ДА".equalsIgnoreCase(answer) && universityDataBase.get(universityId).isPresent()) {
                            universityDataBase.delete(universityId);
                            groupDataBase.deleteGroupsByUniversityId(universityId);
                            studentDataBase.deleteStudentsByUniversityId(universityId);
                            System.out.println("Удаление завершено!");
                            universityDataBase.getInformation();
                            Util.pressEnter();
                            break;
                        } else if ("НЕТ".equalsIgnoreCase(answer)) {
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void getInformation(EntityType entityType) {
        switch (entityType) {
            case STUDENT:
                while (true) {
                    if (studentDataBase.getStudents().size() == 0) {
                        System.out.println("База данных пуста.");
                        break;
                    }
                    System.out.println("ИНФОРМАЦИЯ:\n1 СПИСОК всех студентов\n2 ПРОФИЛЬ студента по ID\n3 СРЕДНИЙ балл студента по ID\n4 НАЗАД");
                    try {
                        String answer = bufferedReader.readLine().trim();
                        if ("СПИСОК".equalsIgnoreCase(answer)) {
                            studentDataBase.getInformation();
                            Util.pressEnter();
                        } else if ("ПРОФИЛЬ".equalsIgnoreCase(answer)) {
                            studentDataBase.getInformation();
                            System.out.println("Выберите ID(XXX.XXX.XXX) студента:");
                            String id = bufferedReader.readLine().trim();
                            if (studentDataBase.get(id).isPresent()) {
                                System.out.println(studentDataBase.get(id).get() + ", средний балл: " + studentDataBase.get(id).get().getAverageScore() +
                                        " " + studentDataBase.get(id).get().getAssessments().toString());
                                Util.pressEnter();
                            } else {
                                System.out.println("Неверный ID.");
                            }
                        } else if ("СРЕДНИЙ".equalsIgnoreCase(answer)) {
                            studentDataBase.getInformation();
                            System.out.println("Выберите ID(XXX.XXX.XXX) студента:");
                            String id = bufferedReader.readLine().trim();
                            if (studentDataBase.get(id).isPresent()) {
                                operationWithAssessments(entityType, id);
                                Util.pressEnter();
                            } else {
                                System.out.println("Неверный ID.");
                            }
                        } else if ("НАЗАД".equalsIgnoreCase(answer)) {
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case GROUP:
                while (true) {
                    if (groupDataBase.getGroups().size() == 0) {
                        System.out.println("База данных пуста.");
                        break;
                    }
                    System.out.println("ИНФОРМАЦИЯ:\n1 СПИСОК всех групп\n2 ПРОФИЛЬ группы по ID(сортировка студентов)\n3 НАЗАД");
                    try {
                        String answer = bufferedReader.readLine().trim();
                        if ("СПИСОК".equalsIgnoreCase(answer)) {
                            groupDataBase.getInformation();
                            Util.pressEnter();
                        } else if ("ПРОФИЛь".equalsIgnoreCase(answer)) {
                            groupDataBase.getInformation();
                            System.out.println("Выберите ID(XXX.XXX) группы:");
                            String groupId = bufferedReader.readLine().trim();
                            if (groupDataBase.get(groupId).isPresent() && studentDataBase.getStudentsByGroupId(groupId) != null) {
                                operationWithAssessments(entityType, groupId);
                                Util.pressEnter();
                            } else if (groupDataBase.get(groupId).isPresent() && studentDataBase.getStudentsByGroupId(groupId) == null) {
                                System.out.println("В группе нет студентов.");
                                Util.pressEnter();
                            } else {
                                System.out.println("Неверный ID.");
                            }
                        } else if ("НАЗАД".equalsIgnoreCase(answer)) {
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case UNIVERSITY:
                while (true) {
                    if (universityDataBase.getUniversities().size() == 0) {
                        System.out.println("База данных пуста.");
                        break;
                    }
                    System.out.println("ИНФОРМАЦИЯ:\n1 СПИСОК всех университетов\n2 ПРОФИЛЬ университета по ID(сортировка групп)\n3 НАЗАД");
                    try {
                        String answer = bufferedReader.readLine().trim();
                        if ("СПИСОК".equalsIgnoreCase(answer)) {
                            universityDataBase.getInformation();
                            Util.pressEnter();
                        } else if ("ПРОФИЛЬ".equalsIgnoreCase(answer)) {
                            universityDataBase.getInformation();
                            System.out.println("Выберите ID(XXX) университета:");
                            String universityId = bufferedReader.readLine().trim();
                            if (universityDataBase.get(universityId).isPresent() && groupDataBase.getGroupsByUniversityId(universityId) != null) {
                                operationWithAssessments(entityType, universityId);
                                System.out.println(universityDataBase.get(universityId).get().getName() + " список всех студентов:");
                                studentDataBase.printStudentsByUniversityId(universityId);
                                Util.pressEnter();
                            } else if (universityDataBase.get(universityId).isPresent() && groupDataBase.getGroupsByUniversityId(universityId) == null) {
                                System.out.println("В университете нет групп");
                                Util.pressEnter();
                            } else {
                                System.out.println("Неверный ID.");
                            }
                        } else if ("НАЗАД".equalsIgnoreCase(answer)) {
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    private void operationWithAssessments(EntityType entityType, String id) {
        switch (entityType) {
            case STUDENT:
                System.out.printf("Средний балл студента ID %s: ", id);
                System.out.println(studentDataBase.get(id).get().getAverageScore());
                break;
            case GROUP:
                while (true) {
                    try {
                        System.out.println("Отсортировать средний балл студентов по:\n1 ВОЗРАСТАНИЮ\n2 УБЫВАНИЮ");
                        String answer = bufferedReader.readLine();
                        if ("ВОЗРАСТАНИЮ".equalsIgnoreCase(answer)) {
                            System.out.println(groupDataBase.get(id).get().getName() + " список студентов:");
                            studentDataBase.getStudentsByGroupId(id).forEach(student -> System.out.println(student.toString()
                                    + " " + student.getAverageScore()));
                            break;
                        } else if ("УБЫВАНИЮ".equalsIgnoreCase(answer)) {
                            System.out.println(groupDataBase.get(id).get().getName() + " список студентов:");
                            List<Student> students = new ArrayList<>(studentDataBase.getStudentsByGroupId(id));
                            Collections.reverse(students);
                            students.forEach(student -> System.out.println(student.toString()
                                    + " " + student.getAverageScore()));
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case UNIVERSITY:
                while (true) {
                    try {
                        System.out.println("Отсортировать средний балл групп по:\n1 ВОЗРАСТАНИЮ\n2 УБЫВАНИЮ");
                        String answer = bufferedReader.readLine();
                        if ("ВОЗРАСТАНИЮ".equalsIgnoreCase(answer)) {
                            System.out.println(universityDataBase.get(id).get().getName() + " список групп:");
                            groupDataBase.getGroupsByUniversityId(id).forEach(group -> System.out.println(group.toString()
                                    + " " + group.getAverageScore()));
                            break;
                        } else if ("УБЫВАНИЮ".equalsIgnoreCase(answer)) {
                            System.out.println(universityDataBase.get(id).get().getName() + " список групп:");
                            List<Group> groups = new ArrayList<>(groupDataBase.getGroupsByUniversityId(id));
                            Collections.reverse(groups);
                            groups.forEach(group -> System.out.println(group.toString()
                                    + " " + group.getAverageScore()));
                            break;
                        } else {
                            System.out.println("Введите корректные данные!");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    public void recordData() {
        studentDataBase.record();
        groupDataBase.record();
        universityDataBase.record();
    }
}
