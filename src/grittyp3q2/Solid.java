package grittyp3q2;

public abstract class Solid {
  private String name;

  public Solid(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract double volume();

  public abstract double perimeter();

  public abstract double surfaceArea();
}
