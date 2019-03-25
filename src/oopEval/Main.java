package oopEval;

public class Main {
  public static void main(String[] args) {
    Bank_Account schoolFunds = new Bank_Account(24857, 539.33, "Savings", 0.1f);
    Bank_Account highInterest = new Bank_Account(4285976, 18758732.354, "Chequing", 0.5f);

    schoolFunds.applyInterest();
    if (schoolFunds.withdrawal(539.34))
      System.out.println("Withdrew successfully");
    else
      System.out.println("Error withdrawing");
    schoolFunds.deposit(2.99);
    System.out.println(schoolFunds.getType());
    System.out.println(schoolFunds.getBalance());

    highInterest.applyInterest();
    if (highInterest.withdrawal(539.34))
      System.out.println("Withdrew successfully");
    else
      System.out.println("Error withdrawing");
    highInterest.deposit(2.99);
    System.out.println(highInterest.getType());
    System.out.println(highInterest.getBalance());

    Car prius = new Car("Toyota", "Prius", 30, 60);
    Car pickUp = new Car("Ford", "F150", 400, 800);

    prius.drive(486.8);
    prius.gasUp();
    prius.getInfo();

    pickUp.drive(35.33);
    pickUp.gasUp();
    pickUp.getInfo();
  }
}
