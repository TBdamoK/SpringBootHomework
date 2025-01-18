package kz.bitlab.springboot.homeworkweek13.services;

import kz.bitlab.springboot.homeworkweek13.models.Student;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Database {

    @Getter
    private static List<Student> studentList = new ArrayList<Student>();

    public static void addStudent(String name, String surname, int examScore) {
        Student newStudent = Student
                .builder()
                .name(name)
                .surname(surname)
                .examScore(examScore)
                .id(studentList.size() + 1L)
                .build();

        newStudent.calculateMark();
        studentList.add(newStudent);
    }

    public static void addStudent(Student student){
        student.setId(studentList.size() + 1L);
        student.calculateMark();
        studentList.add(student);
    }
}
