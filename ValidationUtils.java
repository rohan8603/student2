import java.util.Scanner;

public class ValidationUtils {

    public static int readPositiveInt(Scanner sc, String message) {
        int value;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();
                if (value > 0) return value;
            } else {
                sc.nextLine();
            }
            System.out.println("❌ Invalid input! Enter a positive number.");
        }
    }

    public static double readGrade(Scanner sc) {
        double grade;
        while (true) {
            System.out.print("Enter Grade (0-100): ");
            if (sc.hasNextDouble()) {
                grade = sc.nextDouble();
                sc.nextLine();
                if (grade >= 0 && grade <= 100) return grade;
            } else {
                sc.nextLine();
            }
            System.out.println("❌ Grade must be between 0 and 100.");
        }
    }
}
