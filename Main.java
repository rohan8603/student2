import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    int age = ValidationUtils.readPositiveInt(scanner, "Enter Age: ");
                    double grade = ValidationUtils.readGrade(scanner);

                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();

                    manager.addStudent(new Student(id, name, age, grade, contact));
                }

                case 2 -> manager.viewAll();

                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    Student s = manager.searchById(scanner.nextLine());
                    if (s != null) s.display();
                    else System.out.println("❌ Student not found!");
                }

                case 4 -> {
                    System.out.print("Enter Student ID to delete: ");
                    boolean deleted = manager.deleteStudent(scanner.nextLine());
                    System.out.println(deleted ? "✅ Deleted successfully!" : "❌ Student not found!");
                }

                case 5 -> {
                    running = false;
                    System.out.println("👋 Thank you!");
                }

                default -> System.out.println("❌ Invalid choice!");
            }
        }
        scanner.close();
    }
}
