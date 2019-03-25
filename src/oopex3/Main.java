package oopex3;

public class Main {
  public static void main(String[] args) {
    Person man = new Person("John", "Smith");
    Person woman = new Person("Jane", "Doe", "01/01/2000");

    man.setWeight(234.234);
    System.out.println(Person.convertKgToLbs(man.getWeight()));

    woman.setHeight(3.2);
    System.out.println(Person.convertMetersToInches(woman.getHeight()));
    System.out.println(woman.getDOB());

    Course.maxLates = 99;
    Course.maxAbsences = 33;
    Course apICS =
        new Course("ICS4U0", "AP ICS", "Grade 12", 49.3f, "failed", (byte) 39, (byte) 34);
    Course gr9Math =
        new Course("MPM1D1", "Principles of Mathematics", "Grade 9", 90.0f, "enrolled");

    System.out.println(apICS.toString());
    apICS.addLates();
    apICS.addAbsences((byte) 32);

    System.out.println(gr9Math.toString());
    gr9Math.addLates((byte) 3);
    gr9Math.addAbsences();
  }
}
