package crazyobjects;

/**
 * The VirtualSchool Class
 * 
 * @author Inglume
 */
public class VirtualSchool {

  /**
   * Main method.
   * 
   * @param args - command-line arguments
   */
  public static void main(String[] args) {
    ClassRoom apics = new ClassRoom();

    Student good = new Student("Nicholas Glenn");
    good.myLocker.putJacket(good.myJacket);
    good.books[0] = good.myLocker.getABook("ICS4U0");
    System.out.println("Student: " + good);
    if (apics.enterClassroom(good)) {
      System.out.println(good + " was allowed into class");
    } else {
      System.out.println(good + " was not allowed into class");
    }
    System.out.println();

    Student bad1 = new Student("Andrey Starenky");
    System.out.println("Student: " + bad1);
    if (apics.enterClassroom(bad1)) {
      System.out.println(bad1 + " was allowed into class");
    } else {
      System.out.println(bad1 + " was not allowed into class");
    }
    System.out.println();

    Student bad2 = new Student("Andreya Karentsky");
    bad2.myLocker.putJacket(bad2.myJacket);
    System.out.println("Student: " + bad2);
    if (apics.enterClassroom(bad2)) {
      System.out.println(bad2 + " was allowed into class");
    } else {
      System.out.println(bad2 + " was not allowed into class");
    }
    System.out.println();

    Student bad3 = new Student("Andy Stark");
    bad3.myLocker = null;
    System.out.println("Student: " + bad3);
    if (apics.enterClassroom(bad3)) {
      System.out.println(bad3 + " was allowed into class");
    } else {
      System.out.println(bad3 + " was not allowed into class");
    }
  }

}
