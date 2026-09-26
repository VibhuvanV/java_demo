package arrays_strings;

import java.io.*;

public class ResultImportGenerator {

    public static void main(String[] args) {
        createResultsFile();
        System.out.println("\n===== RESULTS FILE CONTENT =====");
        readResultsFile();
    }

    public static void readAndAppend(String fileName,
                                     StringBuilder report) {

        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                report.append(line)
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void createResultsFile() {

        StringBuilder report = new StringBuilder();
        report.append("JAVA STUDENTS\n");
        readAndAppend("src/arrays_strings/java_students.txt", report);
        report.append("\nPYTHON STUDENTS\n");
        readAndAppend("src/arrays_strings/python_students.txt", report);

        try (BufferedWriter bw =
                     new BufferedWriter(
                             new FileWriter("results.txt"))) {
            bw.write(report.toString());
            System.out.println("results.txt created successfully");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readResultsFile() {
        try (BufferedReader br =
                     new BufferedReader(
                             new FileReader("results.txt"))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}