package crazyobjects;

/**
 * The Student class
 * 
 * @author Nicholas Glenn
 */
public class Student {

  /**
   * Student number.
   */
  String number;

  /**
   * Student name.
   */
  String name;

  /**
   * Student Locker.
   */
  Locker myLocker;

  /**
   * Student Jacket.
   */
  Jacket myJacket;

  /**
   * Student Books.
   */
  Book books[];

  /**
   * Default constructor.
   * 
   * @param name - Student name
   */
  public Student(String name) {
    this.name = name;
    number = Long.toString((long) (Math.random() * 1000000000L));
    myJacket = new Jacket(this);
    myLocker = new Locker(this);
    books = new Book[4];
  }

  /**
   * Sends student to the office and prints the reason why.
   * 
   * @param reason - reason why student was sent to office
   */
  public void sentToOffice(String reason) {
    System.out.println(name + " was sent to the office: " + reason);
  }

  @Override
  public String toString() {
    return name;
  }

}
