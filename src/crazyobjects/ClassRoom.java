package crazyobjects;

public class ClassRoom {

  String course;
  String teacher;

  public ClassRoom() {
    course = "ICS4U0";
    teacher = "Ms. Krasteva";
  }

  public void enterClassroom(Student student) {
    System.out.println(student + " in course " + course + " with teacher " + teacher);
    boolean hasBook = false;

    for (int i = 0; i < student.books.length; i++) {
      if (student.books[i] != null && student.books[i].course.equals(course)) {
        hasBook = true;
      }
    }
    if (student.myLocker == null) {
      student.sentToOffice("Does not have a locker.");
    } else if (student.myJacket != null) {
      student.sentToOffice("Cannot come to class with a jacket.");
    } else if (!hasBook) {
      student.sentToOffice("Missing the necessary textbook(s) for the course.");
    }
  }

}
