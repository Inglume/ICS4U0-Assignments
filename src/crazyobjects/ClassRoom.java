package crazyobjects;

/**
 * The ClassRoom Class
 * 
 * @author Nicholas Glenn
 */
public class ClassRoom {

  /**
   * The ClassRoom course.
   */
  String course;

  /**
   * The ClassRoom teacher.
   */
  String teacher;

  /**
   * Default constructor.
   */
  public ClassRoom() {
    course = "ICS4U0";
    teacher = "Ms. Krasteva";
  }

  /**
   * Checks if student can enter the classroom.
   * 
   * @param student
   * @return true iff student entered the classroom successfully
   */
  public boolean enterClassroom(Student student) {
    System.out.println(student + " in course " + course + " with teacher " + teacher);
    boolean hasBook = false;
    for (int i = 0; i < student.books.length; i++) {
      if (student.books[i] != null && student.books[i].course.equals(course)) {
        hasBook = true;
      }
    }
    if (student.myLocker == null) {
      student.sentToOffice("Does not have a locker.");
      return false;
    } else if (student.myJacket != null) {
      return false;
    } else if (!hasBook) {
      student.sentToOffice("Missing the necessary textbook(s) for the course.");
      return false;
    }
    return true;
  }

}
