import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Enter number only.");
                sc.next();
                continue;
            }

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    searchStudent(sc);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    // Add Student
    public static void addStudent(Scanner sc) {

        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String roll = sc.next();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(name, roll, marks));
        System.out.println("Student added successfully!");
    }

    // View All Students
    public static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.display();
        }
    }

    // Update Student
    public static void updateStudent(Scanner sc) {

        System.out.print("Enter Roll Number to update: ");
        String roll = sc.next();

        for (Student s : students) {
            if (s.getRollNumber().equals(roll)) {

                sc.nextLine();
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Marks: ");
                double marks = sc.nextDouble();

                s.update(name, marks);
                System.out.println("Student updated successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Delete Student
    public static void deleteStudent(Scanner sc) {

        System.out.print("Enter Roll Number to delete: ");
        String roll = sc.next();

        for (Student s : students) {
            if (s.getRollNumber().equals(roll)) {
                students.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Search Student
    public static void searchStudent(Scanner sc) {

        System.out.print("Enter Roll Number to search: ");
        String roll = sc.next();

        for (Student s : students) {
            if (s.getRollNumber().equals(roll)) {
                s.display();
                return;
            }
        }

        System.out.println("Student not found!");
    }
}