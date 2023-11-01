import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DataStructureRecord {

    public record Person(String name, int age) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jumlah orang yang ingin dimasukkan: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        // Membuat PriorityQueue dengan urutan prioritas berdasarkan usia (age)
        PriorityQueue<Person> peopleQueue = new PriorityQueue<>(Comparator.comparingInt(Person::age));

        for (int i = 0; i < numPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Masukkan umur orang ke-" + (i + 1) + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            peopleQueue.add(new Person(name, age));
        }

        System.out.println("People in the PriorityQueue (ordered by age):");

        while (!peopleQueue.isEmpty()) {
            Person person = peopleQueue.poll();
            System.out.println("Name: " + person.name() + ", Age: " + person.age());
        }

        scanner.close();
    }
}
