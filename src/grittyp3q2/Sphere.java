package grittyp3q2;

public class Sphere extends Solid {
  private double radius;
  private final double PI = 3.14;

  public Sphere(String name, double radius) {
    super(name);
    this.radius = radius;
  }

  @Override
  public double volume() {
    return 4 / 3 * PI * radius * radius * radius;
  }

  @Override
  public double perimeter() {
    return surfaceArea();
  }

  @Override
  public double surfaceArea() {
    return 4 * PI * radius * radius;
  }
}
