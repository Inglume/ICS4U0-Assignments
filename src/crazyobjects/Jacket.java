package crazyobjects;

/**
 * The Jacket class
 * 
 * @author Nicholas Glenn
 */
public class Jacket {

  /**
   * The owner of the Jacket.
   */
  Student owner;

  /**
   * Default constructor.
   * 
   * @param me - the Student who owns the Jacket
   */
  public Jacket(Student me) {
    owner = me;
  }

  @Override
  public String toString() {
    return "Jacket owned by: " + owner;
  }

}
