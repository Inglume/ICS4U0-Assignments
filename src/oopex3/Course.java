package oopex3;

public class Course {
  private String code;
  private String name;
  private String level;
  private float mark;
  private String status;
  private byte lates;
  private byte absences;
  static byte maxLates;
  static byte maxAbsences;

  public Course(String code, String name, String level) {
    this.code = code;
    this.name = name;
    this.level = level;
    mark = 0.0f;
    status = "";
    lates = 0;
    absences = 0;
  }

  public Course(String code, String name, String level, float mark, String status) {
    this.code = code;
    this.name = name;
    this.level = level;
    this.mark = mark;
    this.status = status;
    lates = 0;
    absences = 0;
  }

  public Course(String code, String name, String level, float mark, String status, byte lates,
      byte absences) {
    this.code = code;
    this.name = name;
    this.level = level;
    this.mark = mark;
    this.status = status;
    this.lates = lates;
    this.absences = absences;
  }

  public static String convertPercentToGrade(double p) {
    if (p >= 95)
      return "A+";
    else if (p >= 87)
      return "A";
    else if (p >= 80)
      return "A-";
    else if (p >= 76)
      return "B+";
    else if (p >= 73)
      return "B";
    else if (p >= 70)
      return "B-";
    else if (p >= 66)
      return "C+";
    else if (p >= 63)
      return "C";
    else if (p >= 60)
      return "C-";
    else if (p >= 56)
      return "D+";
    else if (p >= 53)
      return "D";
    else if (p >= 50)
      return "D-";
    else
      return "F";
  }

  public static double convertGradeToPercent(String g) {
    if (g.equals("A+"))
      return 95;
    else if (g.equals("A"))
      return 87;
    else if (g.equals("A-"))
      return 80;
    else if (g.equals("B+"))
      return 76;
    else if (g.equals("B"))
      return 73;
    else if (g.equals("B-"))
      return 70;
    else if (g.equals("C+"))
      return 66;
    else if (g.equals("C"))
      return 63;
    else if (g.equals("C-"))
      return 60;
    else if (g.equals("D+"))
      return 56;
    else if (g.equals("D"))
      return 53;
    else if (g.equals("D-"))
      return 50;
    else if (g.equals("F"))
      return 49;
    else
      return -1;
  }

  public float getMark() {
    return mark;
  }

  public String getStatus() {
    return status;
  }

  public String getLevel() {
    return level;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public byte getLates() {
    return lates;
  }

  public byte getAbsences() {
    return absences;
  }

  public void addLates() {
    lates++;
    if (lates > maxLates)
      System.out.println("You have too many lates!");
  }

  public void addLates(byte num) {
    lates += num;
    if (lates > maxLates)
      System.out.println("You have too many lates!");
  }

  public void addAbsences() {
    absences++;
    if (absences > maxAbsences)
      System.out.println("You have too many absences!");
  }

  public void addAbsences(byte num) {
    absences += num;
    if (absences > maxAbsences)
      System.out.println("You have too many absences!");
  }

  public boolean setMark(float m) {
    if (m >= 0 && m <= 100) {
      mark = m;
      return true;
    }
    return false;
  }

  public boolean setStatus(String s) {
    if (s.equals("completed") || s.equals("enrolled") || s.equals("failed")) {
      status = s;
      return true;
    }
    return false;
  }

  @Override
  public String toString() {
    return "Course " + code + ": " + name + " with mark of " + mark;
  }
}
