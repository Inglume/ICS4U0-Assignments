package oopex3;

public class Person {
  private String fname;
  private String lname;
  private String DOB;
  private double height;
  private double weight;

  public Person(String first, String last) {
    fname = first;
    lname = last;
    DOB = "";
    height = 0;
    weight = 0;
  }

  public Person(String first, String last, String DOB) {
    fname = first;
    lname = last;
    this.DOB = DOB;
    height = 0;
    weight = 0;
  }

  public Person(String first, String last, String dob, double h, double w) {
    fname = first;
    lname = last;
    DOB = dob;
    height = h;
    weight = w;
  }

  public void setName(String first, String last) {
    fname = first;
    lname = last;
  }

  public static double convertKgToLbs(double kg) {
    return kg * 2.20462;
  }


  public boolean setWeight(double w) {
    if (w >= 0) {
      weight = w;
      return true;
    }
    return false;
  }

  public static double convertMetersToInches(double m) {
    return m * 39.3701;
  }

  public boolean setHeight(double h) {
    if (h >= 0) {
      height = h;
      return true;
    }
    return false;
  }

  public String getName() {
    return fname + " " + lname;
  }

  public String getDOB() {
    return DOB;
  }

  public int getDOB(String type) {
    if (type.equals("year"))
      return Integer.parseInt(DOB.substring(6));
    else if (type.contentEquals("month"))
      return Integer.parseInt(DOB.substring(0, 2));
    else if (type.contentEquals("day"))
      return Integer.parseInt(DOB.substring(3, 5));
    return -1;
  }

  public double getHeight() {
    return height;
  }

  public double getWeight() {
    return weight;
  }
}
