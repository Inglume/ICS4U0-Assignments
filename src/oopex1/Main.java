package oopex1;

import java.util.Random;

public class Main {
  // Runs all methods
  public static void main(String[] args) {
    // Demonstration of Student
    Student[] kids = new Student[5];
    kids[0] = new Student("Mark");
    kids[1] = new Student("Jess");
    kids[2] = new Student("Teri");
    kids[3] = new Student("Aron");
    kids[4] = new Student("Drew");
    for (int i = 0; i < 5; i++) {
      Random r = new Random();
      kids[i].setMarks(r.nextInt(100), r.nextInt(100));
      kids[i].calcAverage();
      System.out.println(kids[i].message());
    }
    System.out.println();
    Student[] temp = new Student[5];
    for (int i = 0; i < 5; i++) {
      temp[i] = kids[i];
    }
    kids = new Student[10];
    for (int i = 0; i < 5; i++) {
      kids[i] = temp[i];
    }
    kids[7] = new Student("Kris");
    double average = 0.0;
    for (int i = 0; i < 10; i++) {
      if (kids[i] != null) {
        Random r = new Random();
        kids[i].setMarks(r.nextInt(100), r.nextInt(100));
        kids[i].calcAverage();
        System.out.print(kids[i].name);
        System.out.print("\tMark 1: " + kids[i].mark1);
        System.out.print("\tMark 2: " + kids[i].mark2);
        System.out.println("\tAverage: " + kids[i].average);
        average += kids[i].average;
      }
    }
    average /= 6; // 6 students in class
    System.out.printf("Class average is: %.2f\n\n", average);

    // Demonstration of Car
    Car uglyCar = new Car("Toyota", "Corolla", 50, 100);
    Car myCar = new Car("Volvo", "XC90", 90, 200);
    Car truck = new Car("Mack", "Big", 1000, 2000);
    Car van = new Car("Van", "White", 9000, 60000);
    Car bulldozer = new Car("Cat", "Bulldozer", 30, 70);
    myCar.drive(900);
    myCar.gasUp();

    // Demonstration of House
    House condo = new House(696, "Main Street", "Toronto", "Ontario", "D6W 9F3", 800, true, 1);
    House townhouse =
        new House(35806, "Second Street", "New York", "New York", "84259", 6, false, 1);
    House woodCabin = new House(0, null, "Cold Lake", "Alberta", null, 18790, true, 9);
    House cave = new House(0, null, "Codajas", "Brazil", null, 600, true, 1);
    House apartment = new House(40, "56th Street", "Glasgow", "Scotland", "G1 TNG", 9000, false, 1);
    condo.displayAddress();

    // Demonstration of Animal
    Animal dog = new Animal("Rex", 80.1);
    Animal tiger = new Animal("Richard Parker", 300);
    Animal lion = new Animal("Mufasa", 200);
    Animal gorilla = new Animal("Derek", 800);
    Animal human = new Animal("Katie", 50);
    human.feed("vegetables");
    human.feed("meat");
    human.sleep();
  }
}
