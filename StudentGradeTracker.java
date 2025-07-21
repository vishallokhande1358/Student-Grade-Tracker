import java.util.ArrayList;
import java.util.Scanner;

// Student class to store and calculate grades
class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = grades.get(0);
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = grades.get(0);
        for (int g : grades) if (g < min) min = g;
        return min;
    }

    void printSummary() {
        System.out.println("\nStudent: " + name);
        System.out.println("Grades: " + grades);
        System.out.printf("Average Score: %.2f\n", getAverage());
        System.out.println("Highest Score: " + getHighest());
        System.out.println("Lowest Score: " + getLowest());
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine(); // clear newline

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int gradeCount = scanner.nextInt();

            for (int j = 0; j < gradeCount; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }

            scanner.nextLine(); // clear buffer
            students.add(student);
        }

        // Display report
        System.out.println("\n===== Student Grade Summary Report =====");
        for (Student student : students) {
            student.printSummary();
        }

        scanner.close();
    }
}