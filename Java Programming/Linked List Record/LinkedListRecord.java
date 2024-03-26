import java.util.LinkedList;
import java.util.Scanner;

public class DataStructureRecord {

    public record Person(String name, int age) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jumlah orang yang ingin dimasukkan: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        LinkedList<Person> peopleList = new LinkedList<>();

        for (int i = 0; i < numPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Masukkan umur orang ke-" + (i + 1) + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            Person person = new Person(name, age);
            peopleList.add(person);
        }

        System.out.println("People in the list:");
        for (Person person : peopleList) {
            System.out.println("Name: " + person.name() + ", Age: " + person.age());
        }

        scanner.close();
    }
}