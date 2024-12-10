import java.util.*;

// Model
class Student {
    String name;
    String roll;
    int marks;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setRoll(String roll) {
        this.roll = roll;
    }

    String getRoll() {
        return roll;
    }

    void setMarks(int marks) {
        this.marks = marks;
    }

    int getMarks() {
        return marks;
    }
}

// View
class StudentDetails {
    void display(String name, String roll, int marks) {
        System.out.println("Name = " + name + " | Roll = " + roll + " | Marks = " + marks);
    }
}

// Controller
class StudentController {
    Student model;
    StudentDetails view;
    StudentController(Student model, StudentDetails view) {
        this.model = model;
        this.view = view;
    }

    void setDetails(String name, String roll, int marks) {
        model.setName(name);
        model.setRoll(roll);
        model.setMarks(marks);
    }

    void getDetails() {
        view.display(model.getName(), model.getRoll(), model.getMarks());
    }
}

public class MVCDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Roll:");
        String roll = sc.nextLine();
        System.out.println("Enter Marks:");
        int marks = sc.nextInt();

        Student model = new Student();
        StudentDetails view = new StudentDetails();
        StudentController controller = new StudentController(model, view);

        controller.setDetails(name, roll, marks);
        controller.getDetails();
    }
}