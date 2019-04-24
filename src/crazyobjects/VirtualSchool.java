package crazyobjects;

/**
 * The VirtualSchool Class
 * 
 * @author Inglume
 */
public class VirtualSchool {

  public static void main(String[] args) {
    ClassRoom apics = new ClassRoom();

    Student good = new Student("Nicholas Glenn");
    good.myLocker.putAJacket(good.myJacket);
    good.books[0] = good.myLocker.getABook("ICS4U0");
    System.out.println("Student: " + good);
    apics.enterClassroom(good);

    Student bad1 = new Student("Andrey Starenky");
    System.out.println("Student: " + bad1);
    apics.enterClassroom(bad1);

    Student bad2 = new Student("Andreya Karentsky");
    bad2.myLocker.putAJacket(bad2.myJacket);
    System.out.println("Student: " + bad2);
    apics.enterClassroom(bad2);

    Student bad3 = new Student("Andy Stark");
    bad2.myLocker = null;
    System.out.println("Student: " + bad3);
    apics.enterClassroom(bad3);

    // piss me panst;
  }

}
