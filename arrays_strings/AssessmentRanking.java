package arrays_strings;

import java.util.Arrays;
import java.util.Scanner;

public class AssessmentRanking {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of students: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter marks of each student: ");
        for(int i =0;i<n;i++){
            marks[i] = scanner.nextInt();
        }

        int maxi = marks[0] , mini = marks[0];
        for(int m : marks) {
            if(m > maxi) {
                maxi = m;
            }
        }

        for(int m : marks) {
            if(m < mini) {
                mini = m;
            }
        }

        System.out.println("Highest marks are : " + maxi+ "\t Lowest marks are: " + mini);

        //sorting and cloning
        int[] sortedArray = marks.clone();
        Arrays.sort(sortedArray);
        System.out.println(Arrays.toString(sortedArray));

        int i = Arrays.binarySearch(sortedArray, 14);


    }

}
