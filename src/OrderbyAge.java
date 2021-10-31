import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderbyAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String personalInformation = scanner.nextLine();
        List<Person1> listOfPeople = new ArrayList<>();
        while(!personalInformation.equals("End")) {
            //"George 123456 20".split(" ") -> ["George", "123456", "20"]
            String name = personalInformation.split(" ")[0];
            String id = personalInformation.split(" ")[1];
            int age = Integer.parseInt(personalInformation.split(" ")[2]);

            Person1 person = new Person1(name, id, age);
            listOfPeople.add(person);

            personalInformation = scanner.nextLine();
        }

        //списък с хората
        //сортиране по възраст в нарастващ ред (ascending order)
        listOfPeople.sort(Comparator.comparing(Person1::getAge));

        for (Person1 person : listOfPeople) {
            System.out.println(person.toString());
        }

    }
}
class Person1 {
    //полета -> характеристики
    private String name;
    private String id;
    private int age;

    //конструктор
    public Person1(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    //getter -> age
    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        //"{name} with ID: {id} is {age} years old."
        return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
    }
}
