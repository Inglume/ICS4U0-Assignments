package oopex1;

public class Car {
  private String brand;
  private String model;
  private int kilometres;
  private double gas;
  private double tankCapacity;

  // Default constructor
  public Car(String b, String m, double g, double tCap) {
    brand = b;
    model = m;
    kilometres = 0;
    gas = g;
    tankCapacity = tCap;
  }

  // 'Drives' car by increasing kilometres and consuming gas
  public void drive(double distance) {
    kilometres += distance;
    gas -= distance / 5;
  }

  // Fills gas to tank capacity
  public void gasUp() {
    gas = tankCapacity;
  }

} // Car class
