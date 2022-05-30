package com.goncharov.finplatforms.secondTask.UI;

import com.goncharov.finplatforms.secondTask.entity.Student;
import com.goncharov.finplatforms.secondTask.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentBase {
    private final StudentService studentService;

    @Autowired
    public StudentBase(StudentService studentService) {
        this.studentService = studentService;
    }

    Scanner scanner = new Scanner(System.in);

    private void addStudent() {
        try {
            Student student = new Student();

            System.out.println("Enter name:");
            student.setName(scanner.nextLine());

            System.out.println("Enter surname:");
            student.setSurname(scanner.nextLine());

            System.out.println("Enter patronymic:");
            student.setPatronymic(scanner.nextLine());

            System.out.println("Enter group:");
            student.setGroup(scanner.nextLine());

            System.out.println("Enter birthday in format: \"yyyy-MM-dd\"");
            String str = scanner.nextLine();
            LocalDate date = LocalDate.parse(str);
            student.setBirthday(date);

            studentService.addStudent(student);
        } catch (Exception e) {
            System.out.println("\nERROR: Data entry error, try again \n");
        }
    }

    private void removeStudent() {
        System.out.println("Enter student id");
        long id = Long.parseLong(scanner.nextLine());
        try {
            studentService.deleteStudent(id);
        } catch (Exception e) {
            System.out.println("Student doesnt exist");
        }
    }

    private void findAllStudents() {
        List<Student> studentList = studentService.findAll();
        studentList.forEach(System.out::println);
    }

    public void UI() {
        String str;

        while (true) {
            String info = ("""
                    Select from the list:\s
                    1: add student\s
                    2: remove student by ID\s
                    3: show all students\s
                    4: close the app""");
            System.out.println(info);

            str = scanner.nextLine();

            switch (str) {
                case ("1") -> addStudent();
                case ("2") -> removeStudent();
                case ("3") -> findAllStudents();
                case ("4") -> System.exit(0);
                default -> System.out.println("Unknown command");
            }
        }
    }
}
