package arrays_strings;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class BackupCenter {

    public static void main(String[] args) {

        Student[] original = {
                new Student(101, "James"),
                new Student(102, "John")
        };

        // Assignment
        Student[] assignmentBackup = original;

        // Shallow Clone
        Student[] shallowClone = original.clone();

        // Deep Clone
        Student[] deepClone = new Student[original.length];

        for (int i = 0; i < original.length; i++) {
            deepClone[i] =
                    new Student(
                            original[i].id,
                            original[i].name
                    );
        }

        System.out.println("Before Modification");

        display(original, "Original");
        display(assignmentBackup, "Assignment");
        display(shallowClone, "Shallow Clone");
        display(deepClone, "Deep Clone");

        // Modify original object
        original[0].name = "Modified Student";

        System.out.println("\nAfter Modification");

        display(original, "Original");
        display(assignmentBackup, "Assignment");
        display(shallowClone, "Shallow Clone");
        display(deepClone, "Deep Clone");
    }

    static void display(Student[] arr, String title) {

        System.out.println("\n" + title);

        for (Student s : arr) {
            System.out.println(s.id + " " + s.name);
        }
    }
}