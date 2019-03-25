package oopex2;

/**
 * Main creates 2 objects of each class and runs all their methods
 * 
 * @author Inglume
 */
public class Main {

  public static void main(String[] args) {
    Person man = new Person("John", "Smith", "12/30/1999", 90, 90);
    Person woman = new Person("Jane", "Doe", "01/01/2000", 90, 90);

    man.setName("sdddd", "wikhvou");
    man.setWeight(83495.4);
    man.setHeight(488);
    System.out.println(man.getName());
    System.out.println(man.getDOB());
    System.out.println(man.getDOB_year());
    System.out.println(man.getDOB_month());
    System.out.println(man.getDOB_day());
    System.out.println(man.getHeight());
    System.out.println(man.getWeight());

    woman.setName("jgnevjr", "nsccnc");
    woman.setWeight(8.4);
    woman.setHeight(433338);
    System.out.println(woman.getName());
    System.out.println(woman.getDOB());
    System.out.println(woman.getDOB_year());
    System.out.println(woman.getDOB_month());
    System.out.println(woman.getDOB_day());
    System.out.println(woman.getHeight());
    System.out.println(woman.getWeight());

    Wheel round = new Wheel("Wheel Co.", "Round Wheel", 30, "all season");
    Wheel square = new Wheel("Wheel Inc.", "Square Wheel", 12, "winter");

    round.update_KM_usage(333333);
    System.out.println(round.getBrand());
    System.out.println(round.getModel());
    System.out.println(round.getSize());
    System.out.println(round.getSeason());
    System.out.println(round.getKM());

    square.update_KM_usage(2221);
    System.out.println(square.getBrand());
    System.out.println(square.getModel());
    System.out.println(square.getSize());
    System.out.println(square.getSeason());
    System.out.println(square.getKM());

    Course apICS = new Course("ICS4U0", "AP ICS", "Grade 12");
    Course gr9Math = new Course("MPM1D1", "Principles of Mathematics", "Grade 9");


    apICS.addLates((byte) 2);
    apICS.addAbsences((byte) 333);
    if (apICS.setMark(99.9f))
      System.out.println("Mark set successfully");
    else
      System.out.println("Error encountered while setting mark");
    System.out.println(apICS.getMarkG());
    System.out.println(apICS.getMark());
    System.out.println(apICS.getStatus());
    System.out.println(apICS.getLevel());
    System.out.println(apICS.getCode());
    System.out.println(apICS.getName());
    System.out.println(apICS.getLates());
    System.out.println(apICS.getAbsences());

    gr9Math.addLates((byte) 22);
    gr9Math.addAbsences((byte) 1);
    if (gr9Math.setMark(-3.9f))
      System.out.println("Mark set successfully");
    else
      System.out.println("Error encountered while setting mark");
    if (gr9Math.setMark(31.3f))
      System.out.println("Mark set successfully");
    else
      System.out.println("Error encountered while setting mark");
    System.out.println(gr9Math.getMarkG());
    System.out.println(gr9Math.getMark());
    System.out.println(gr9Math.getStatus());
    System.out.println(gr9Math.getLevel());
    System.out.println(gr9Math.getCode());
    System.out.println(gr9Math.getName());
    System.out.println(gr9Math.getLates());
    System.out.println(gr9Math.getAbsences());

    Vehicle truck = new Vehicle("truck", "Mack", "Big", (short) 2099, "pink", (byte) 6, 9999.9f);
    Vehicle van =
        new Vehicle("van", "The Van Bros.", "White", (short) 1867, "white", (byte) 2, 67.2f);

    truck.paint("turquoise");
    truck.gasUp(32579258);
    if (truck.drive(444444444))
      System.out.println("Drove successfully");
    else
      System.out.println("Did not drive successfully");
    System.out.println(truck.getType());
    System.out.println(truck.getManufact());
    System.out.println(truck.getModel());
    System.out.println(truck.getYear());
    System.out.println(truck.getColour());
    System.out.println(truck.getDoors());
    System.out.println(truck.getTankSize());

    van.paint("magenta");
    van.gasUp(325723258);
    if (van.drive(424))
      System.out.println("Drove successfully");
    else
      System.out.println("Did not drive successfully");
    System.out.println(van.getType());
    System.out.println(van.getManufact());
    System.out.println(van.getModel());
    System.out.println(van.getYear());
    System.out.println(van.getColour());
    System.out.println(van.getDoors());
    System.out.println(van.getTankSize());

    Account rich = new Account(28458725, "savings", 999999.3859);
    Account david = new Account(56409953, "chequing", -993333333.3);

    rich.setInterestRate(0.5f);
    rich.calcInterest();
    rich.deposit(34234.800);
    if (rich.withdraw(987))
      System.out.println("Withdrew succesfully");
    else
      System.out.println("Error withdrawing");
    System.out.println(rich.getBalance());
    System.out.println(rich.getAccount());
    System.out.println(rich.getType());

    david.setInterestRate(0.01f);
    david.calcInterest();
    david.deposit(3.800);
    if (david.withdraw(99987))
      System.out.println("Withdrew succesfully");
    else
      System.out.println("Error withdrawing");
    System.out.println(david.getBalance());
    System.out.println(david.getAccount());
    System.out.println(david.getType());
  }
}
