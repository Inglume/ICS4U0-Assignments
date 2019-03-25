package oopex1;

public class Student {
  public String name;
  public int mark1;
  public int mark2;
  public double average;

  // Default constructor
  public Student(String n) {
    name = n;
    mark1 = 0;
    mark2 = 0;
    average = 0.0;
  }

  // Sets mark1 and mark2
  public void setMarks(int x, int y) {
    mark1 = x;
    mark2 = y;
  }

  // Calculates student average of mark1 and mark2
  public void calcAverage() {
    average = (mark1 + mark2) / 2;
  }

  // Returns average in message
  public String message() {
    return name + "You got an " + average;
  }
} // Student class
