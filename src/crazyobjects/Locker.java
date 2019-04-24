package crazyobjects;

/**
 * The Locker class
 * 
 * @author Nicholas Glenn
 */
public class Locker {

  /**
   * Locker number.
   */
  int number;

  /**
   * Locker owner.
   */
  Student owner;

  /**
   * Jacket inside Locker.
   */
  private Jacket studentJacket;

  /**
   * Books inside Locker.
   */
  private Book books[];

  public Locker(Student me) {
    number = (int) (Math.random() * 10000);
    owner = me;
    studentJacket = me.myJacket;
    books = new Book[] {new Book(), new Book(), new Book(), new Book()};
    books[0].setTitle("Othello");
    books[0].setCourse("ENG2D3");
    books[1].setTitle("Notebook");
    books[1].setCourse("BBI201");
    books[2].setTitle("Barron's AP Textbook: 8th Edition");
    books[2].setCourse("ICS4U0");
    books[3].setTitle("Nelson Grade 10 Math");
    books[3].setCourse("MPM2D3");
  }

  /**
   * 
   * 
   * @param course
   * @return
   */
  public Book getABook(String course) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] != null && books[i].course.equals(course)) {
        Book temp = new Book();
        temp.setTitle(books[i].title);
        temp.setCourse(books[i].course);
        books[i] = null;
        return temp;
      }
    }
    return null;
  }

  /**
   * Puts a book into Locker.
   * 
   * @param book - the book to place
   */
  public void putABook(Book book) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] == null) {
        books[i] = new Book();
        books[i].setTitle(book.title);
        books[i].setCourse(book.course);
        book = null;
        return;
      }
    }
  }

  /**
   * Takes Jacket from Locker.
   * 
   * @return studentJacket if it isn't null, else, null
   */
  public Jacket getJacket() {
    if (studentJacket != null) {
      Jacket temp = new Jacket(studentJacket.owner);
      studentJacket = null;
      return temp;
    }
    return null;
  }

  /**
   * Checks the status of jacket.
   * 
   * @return studentJacket
   */
  public Jacket checkJacket() {
    return studentJacket;
  }

  /**
   * 
   * 
   * @param thisJacket
   */
  public void putAJacket(Jacket thisJacket) {
    studentJacket = new Jacket(thisJacket.owner);
    thisJacket.owner.myJacket = null;
  }

  @Override
  public String toString() {
    return "Locker #" + number + " owned by " + owner;
  }

}
