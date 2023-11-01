import java.util.Scanner;

public class DataStructureRecord {

    public record Person(String name, int age) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jumlah orang yang ingin dimasukkan: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        Person[] people = new Person[numPeople];

        for (int i = 0; i < numPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Masukkan umur orang ke-" + (i + 1) + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            people[i] = new Person(name, age);
        }

        System.out.println("People in the array:");
        for (Person person : people) {
            System.out.println("Name: " + person.name() + ", Age: " + person.age());
        }

        scanner.close();
    }
}
