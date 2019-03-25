package oopex1;

public class Animal {
  private String name;
  private boolean tired;
  private boolean hungry;
  private double weight;

  // Default constructor
  public Animal(String n, double w) {
    name = n;
    tired = true;
    hungry = true;
    weight = w;
  }

  // 'Feeds' animal by making it full and increasing its weight
  // Weight increase depends on type of food
  public void feed(String v) {
    hungry = false;
    if (v.equals("vegetables"))
      weight += 2;
    else if (v.equals("meat"))
      weight += 4;
    else
      weight += 1;
  }

  // Makes animal sleep
  public void sleep() {
    tired = false;
    weight -= 3;
  }
} // Animal class
