package com.goncharov.finplatforms;

import com.goncharov.finplatforms.firstTask.FileScanner;
import com.goncharov.finplatforms.secondTask.UI.StudentBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;

@SpringBootApplication
public class FinplatformsApplication implements CommandLineRunner {

    final StudentBase studentBase;
    final FileScanner fileScanner;

    @Autowired
    public FinplatformsApplication(StudentBase studentBase, FileScanner fileScanner) {
        this.studentBase = studentBase;
        this.fileScanner = fileScanner;
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(FinplatformsApplication.class).web(WebApplicationType.NONE)
                .run(args);
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) throws Exception {
        System.out.println("""

                Do you want to run the first (enter 1) or second (enter 2) task?
                For exit enter 3""");
        int i = scanner.nextInt();
        while (true) {
            switch (i) {
                case (1) -> fileScanner.UI();
                case (2) -> studentBase.UI();
                case (3) -> System.exit(0);
                default -> System.out.println("Unknown command");
            }
        }
    }
}
