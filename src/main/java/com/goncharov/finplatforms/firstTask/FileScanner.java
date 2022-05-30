package com.goncharov.finplatforms.firstTask;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Service
public class FileScanner {

    private Path path;

    /**
     * Метод скинурет и сортирует в алфавитном порядке все файлы с расширением.txt в переданной директории.
     *
     * @return List<Path>
     * @throws IOException
     */
    private List<Path> readFile() throws IOException {
        return Files.walk(path)
                .filter(Files::isRegularFile)
                .filter(p -> p.getFileName().toString().endsWith(".txt"))
                .sorted(Comparator.comparing(Path::getFileName)).toList();
    }

    /**
     * Метод создаёт и записывает данные в файл result.txt.
     *
     * @param pathList
     * @throws IOException
     */
    private void writeFile(List<Path> pathList) throws IOException {
        Path output = Paths.get(path + "\\result.txt");

        for (Path path : pathList) {
            Files.write(output,
                    Files.lines(path).collect(Collectors.toList()),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }
    }

    /**
     * Консольный UI.
     */
    public void UI() {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter your directory or type \"exit\" if you want to close the app");

            String str = scanner.nextLine();

            if (str.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            path = Path.of(str);

            try {
                writeFile(readFile());
                exit = true;
            } catch (IOException e) {
                System.out.println("Directory doesnt exist");
            }

        } while (!exit);

        System.out.println("Done!");
    }
}
