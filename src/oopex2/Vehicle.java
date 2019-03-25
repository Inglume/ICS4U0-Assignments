package oopex2;

/**
 * The Vehicle represents a vehicle that can drive, change paint colour, and refill gas.
 * 
 * @author Inglume
 */
public class Vehicle {

  private String type;
  private String manufacturer;
  private String model;
  private short year;
  private String colour;
  private byte numOfDoors;
  private float gasTankSize;
  private float gas;
  private int km;

  /**
   * Default constructor for a {@link Vehicle}.
   * 
   * @param typ
   * @param manu
   * @param mod
   * @param yea
   * @param col
   * @param nDoors
   * @param tankS
   */
  public Vehicle(String typ, String manu, String mod, short yea, String col, byte nDoors,
      float tankS) {
    type = typ;
    manufacturer = manu;
    model = mod;
    year = yea;
    colour = col;
    numOfDoors = nDoors;
    gasTankSize = tankS;
    gas = 0.0f;
    km = 0;
  }

  /**
   * Sets colour.
   * 
   * @param colour
   */
  public void paint(String colour) {
    this.colour = colour;
  }

  /**
   * Refills gas by amount of litres.
   * 
   * @param litres
   */
  public void gasUp(int litres) {
    gas += litres;
    if (gas > gasTankSize)
      gas = gasTankSize;
  }

  /**
   * Drives car which consumes gas and increases kilometre count.
   * 
   * @param distance
   * @return boolean - true iff gas was not depleted during drive.
   */
  public boolean drive(int distance) {
    km += distance;
    gas -= distance / 5;
    if (gas < 0) {
      gas = 0;
      return false;
    }
    return true;
  }

  /**
   * Gets the type of vehicle.
   * 
   * @return String - type
   */
  public String getType() {
    return type;
  }

  /**
   * Gets the manufacturer.
   * 
   * @return String - manufacturer
   */
  public String getManufact() {
    return manufacturer;
  }

  /**
   * Gets the vehicle model.
   * 
   * @return String - model
   */
  public String getModel() {
    return model;
  }

  /**
   * Gets the year of the vehicle.
   * 
   * @return short - year
   */
  public short getYear() {
    return year;
  }

  /**
   * Gets the colour of the vehicle.
   * 
   * @return String - colour
   */
  public String getColour() {
    return colour;
  }

  /**
   * Gets the number of doors in the vehicle.
   * 
   * @return byte - numOfDoors
   */
  public byte getDoors() {
    return numOfDoors;
  }

  /**
   * Gets the gas tank capacity.
   * 
   * @return float - gasTankSize
   */
  public float getTankSize() {
    return gasTankSize;
  }
}
