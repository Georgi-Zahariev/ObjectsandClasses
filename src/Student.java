import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Stud> listOfStudents = new ArrayList<>();
        int countStudents = Integer.parseInt(scanner.nextLine());
        for (int student = 1; student <= countStudents; student++) {
            String studentInfo = scanner.nextLine();
            //"{first name} {second name} {grade}".split(" ")
            //-> ["{firstName}", "{secondName}", "{grade}"]
            String firstName = studentInfo.split(" ")[0];
            String secondName = studentInfo.split(" ")[1];
            double grade = Double.parseDouble(studentInfo.split(" ")[2]);

            Stud studentObj = new Stud(firstName, secondName, grade);
            listOfStudents.add(studentObj);
        }

        //сортираме по оценка -> ascending
        //listOfStudents.sort(Comparator.comparing(Student::getGrade));

        //сортираме по оценка -> descending
        listOfStudents.sort(Comparator.comparing(Stud::getGrade).reversed());


        for (Stud student : listOfStudents) {
            System.out.println(student);
        }
    }
}
class Stud {
    //полета -> характеристики
    private String firstName;
    private String secondName;
    private double grade;

    //конструктор
    public Stud(String firstName, String secondName, double grade) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.grade = grade;
    }

    //getter -> grade
    public double getGrade() {
        return this.grade;
    }

    @Override
    public String toString() {
        //обект -> текст
        //"{first name} {second name}: {grade}"
        return String.format("%s %s: %.2f", this.firstName, this.secondName, this.grade);
    }
}
 