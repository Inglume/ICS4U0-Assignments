package crazyobjects;

/**
 * The Book class
 * 
 * @author Nicholas Glenn
 */
public class Book {

  /**
   * The book title.
   */
  String title;

  /**
   * The course title.
   */
  String course;

  /**
   * Default constructor.
   */
  public Book() {}

  /**
   * Sets the title.
   * 
   * @param title - the book title
   */
  public void setTitle(String thisTitle) {
    title = thisTitle;
  }

  /**
   * Sets the course.
   * 
   * @param course - the book course
   */
  public void setCourse(String course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return title + " for " + course;
  }

}
