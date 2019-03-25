package oop2ex3;

public class Airplane {
  private int gasLevel;
  private String landingGear;
  private String doorStatus;
  private int passengers;

  public void openDoor() {
    doorStatus = "Open";
  }

  public void closeDoor() {
    doorStatus = "Closed";
  }

  public void fillUp() {
    gasLevel = 100;
  }

  public void takeOff() {
    gasLevel -= 30;
  }

  public void doneTakeOff() {
    landingGear = "Up";
  }

  public void normalFlight(int gasConsumption) {
    gasLevel -= gasConsumption;
  }

  public void prepLanding() {
    landingGear = "Down";
  }

  public void land() {
    gasLevel -= 15;
  }

  public void loadPass(int passengersNum) {
    passengers += passengersNum;
  }

  public void unloadPass() {
    passengers = 0;
  }

  public int getGasLevel() {
    return gasLevel;
  }

  public String getDoorStatus() {
    return doorStatus;
  }

  public int getPassengers() {
    return passengers;
  }

  public String getLandingGear() {
    return landingGear;
  }

  public Airplane() {
    gasLevel = 100;
    landingGear = "Down";
    doorStatus = "Open";
    passengers = 100;
  }
}
