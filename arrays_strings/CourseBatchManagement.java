package arrays_strings;

import java.util.Scanner;

public class CourseBatchManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] courses = {
                new String[5],   // Java
                new String[3],   // Python
                new String[8]    // Testing
        };

        String[] courseNames = {
                "Java",
                "Python",
                "Testing"
        };


        System.out.println("=== Student Registration ===");

        for (int i = 0; i < courses.length; i++) {
            System.out.println("\nEnter students for " + courseNames[i] + " Course:");

            for (int j = 0; j < courses[i].length; j++) {
                System.out.print("Student " + (j + 1) + ": ");
                courses[i][j] = sc.nextLine();
            }
        }


        System.out.println("\n=== Batch Details ===");

        for (int i = 0; i < courses.length; i++) {

            System.out.println(courseNames[i] + " Batch:");

            for (int j = 0; j < courses[i].length; j++) {
                System.out.println(courses[i][j]);
            }

            System.out.println();
        }

        int largestIndex = 0;

        for (int i = 1; i < courses.length; i++) {
            if (courses[i].length > courses[largestIndex].length) {
                largestIndex = i;
            }
        }

        System.out.println("Largest Batch : "
                + courseNames[largestIndex]
                + " (" + courses[largestIndex].length + " Students)");

        int smallestIndex = 0;

        for (int i = 1; i < courses.length; i++) {
            if (courses[i].length < courses[smallestIndex].length) {
                smallestIndex = i;
            }
        }

        System.out.println("Smallest Batch : "
                + courseNames[smallestIndex]
                + " (" + courses[smallestIndex].length + " Students)");

        sc.close();
    }
}