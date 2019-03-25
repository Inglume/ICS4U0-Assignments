package oopex2;

/**
 * The Person represents a human person with a name, height, weight, and date of birth.
 * 
 * @author Inglume
 */
public class Person {
  private String fname;
  private String lname;
  private String DOB;
  private double height;
  private double weight;

  /**
   * Default constructor for a {@link Person}.
   * 
   * @param first
   * @param last
   * @param dob
   * @param h
   * @param w
   */
  public Person(String first, String last, String dob, double h, double w) {
    fname = first;
    lname = last;
    DOB = dob;
    height = h;
    weight = w;
  }

  /**
   * Sets first and last name.
   * 
   * @param first
   * @param last
   */
  public void setName(String first, String last) {
    fname = first;
    lname = last;
  }

  /**
   * Sets weight.
   * 
   * @param w
   * @return boolean - true iff weight was set successfully
   */
  public boolean setWeight(double w) {
    if (w >= 0) {
      weight = w;
      return true;
    }
    return false;
  }

  /**
   * Sets height.
   * 
   * @param h
   * @return boolean - true iff height was set successfully
   */
  public boolean setHeight(double h) {
    if (h >= 0) {
      height = h;
      return true;
    }
    return false;
  }

  /**
   * Gets first name + last name.
   * 
   * @return String - fname + lname
   */
  public String getName() {
    return fname + " " + lname;
  }

  /**
   * Gets date of birth.
   * 
   * @return String - DOB
   */
  public String getDOB() {
    return DOB;
  }

  /**
   * Gets year of birth.
   * 
   * @return int - DOB year
   */
  public int getDOB_year() {
    return Integer.parseInt(DOB.substring(6));
  }

  /**
   * Gets month of birth.
   * 
   * @return int - DOB month
   */
  public int getDOB_month() {
    return Integer.parseInt(DOB.substring(0, 2));
  }

  /**
   * Gets day of birth.
   * 
   * @return int - DOB day
   */
  public int getDOB_day() {
    return Integer.parseInt(DOB.substring(3, 5));
  }

  /**
   * Gets height
   * 
   * @return double - height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Gets weight
   * 
   * @return double - weight
   */
  public double getWeight() {
    return weight;
  }
}
