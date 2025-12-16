import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("✅ Student added successfully!");
    }

    public void viewAll() {
        if (students.isEmpty()) {
            System.out.println("❌ No students found!");
            return;
        }

        System.out.printf("%-10s %-20s %-5s %-7s %-15s%n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-".repeat(65));

        for (Student s : students) {
            System.out.printf("%-10s %-20s %-5d %-7.2f %-15s%n",
                    s.getStudentId(), s.getName(),
                    s.getAge(), s.getGrade(), s.getContact());
        }
    }

    public Student searchById(String id) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(String id) {
        Student s = searchById(id);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}
