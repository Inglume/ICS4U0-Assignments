package oopex2;

/**
 * The Course represents a high school course that tracks lates and absences, and the course mark.
 * 
 * @author Nicholas Glenn
 */
public class Course {
  private String code;
  private String name;
  private String level;
  private float mark;
  private String status;
  private byte lates;
  private byte absences;

  /**
   * Default constructor for a {@link Course}.
   * 
   * @param c The course code.
   * @param n The course name.
   * @param lev The grade level of this course.
   */
  public Course(String c, String n, String lev) {
    code = c;
    name = n;
    level = lev;
    mark = 0.0f;
    status = "";
    lates = 0;
    absences = 0;
  }

  /**
   * Gets mark as letter grade.
   * 
   * @return String - mark in letter format
   */
  public String getMarkG() {
    if (mark >= 95)
      return "A+";
    else if (mark >= 87)
      return "A";
    else if (mark >= 80)
      return "A-";
    else if (mark >= 76)
      return "B+";
    else if (mark >= 73)
      return "B";
    else if (mark >= 70)
      return "B-";
    else if (mark >= 66)
      return "C+";
    else if (mark >= 63)
      return "C";
    else if (mark >= 60)
      return "C-";
    else if (mark >= 56)
      return "D+";
    else if (mark >= 53)
      return "D";
    else if (mark >= 50)
      return "D-";
    else
      return "F";
  }

  /**
   * Gets course mark.
   * 
   * @return float - mark
   */
  public float getMark() {
    return mark;
  }

  /**
   * Gets course status.
   * 
   * @return String - status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets course grade level.
   * 
   * @return String - level
   */
  public String getLevel() {
    return level;
  }

  /**
   * Gets course code.
   * 
   * @return String - code
   */
  public String getCode() {
    return code;
  }

  /**
   * Gets course name
   * 
   * @return String - name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets number of lates.
   * 
   * @return byte - lates
   */
  public byte getLates() {
    return lates;
  }

  /**
   * Gets number of absences.
   * 
   * @return byte - absences
   */
  public byte getAbsences() {
    return absences;
  }

  /**
   * Adds num to number of lates.
   * 
   * @param num
   */
  public void addLates(byte num) {
    lates += num;
  }

  /**
   * Adds num to number of absences.
   * 
   * @param num
   */
  public void addAbsences(byte num) {
    absences += num;
  }

  /**
   * Sets mark to m if it is in the range 0-100 (inclusive).
   * 
   * @param m
   * @return true iff mark was set successfully.
   */
  public boolean setMark(float m) {
    if (m >= 0 && m <= 100) {
      mark = m;
      return true;
    }
    return false;
  }

  /**
   * Sets status to s.
   * 
   * @param s
   * @return true iff status was set successfully.
   */
  public boolean setStatus(String s) {
    if (s.equals("completed") || s.equals("enrolled") || s.equals("failed")) {
      status = s;
      return true;
    }
    return false;
  }
}
