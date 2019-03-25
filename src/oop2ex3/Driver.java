package oop2ex3;

public class Driver {
  public static void main(String[] args) {
    Airplane boeing747 = new Airplane();
    System.out.println("Before flight:");
    System.out.println("Gas level: " + boeing747.getGasLevel());
    System.out.println("Door status: " + boeing747.getDoorStatus());
    System.out.println("Passengers: " + boeing747.getPassengers());
    System.out.println("Landing Gear: " + boeing747.getLandingGear());
    boeing747.openDoor();
    boeing747.loadPass(92);
    boeing747.closeDoor();
    boeing747.takeOff();
    boeing747.doneTakeOff();
    System.out.println("\nAfter takeoff:");
    System.out.println("Gas level: " + boeing747.getGasLevel());
    System.out.println("Door status: " + boeing747.getDoorStatus());
    System.out.println("Passengers: " + boeing747.getPassengers());
    System.out.println("Landing Gear: " + boeing747.getLandingGear());
    boeing747.normalFlight(45);
    boeing747.prepLanding();
    boeing747.land();
    boeing747.openDoor();
    boeing747.unloadPass();
    boeing747.closeDoor();
    boeing747.fillUp();
    System.out.println("\nAfter landing:");
    System.out.println("Gas level: " + boeing747.getGasLevel());
    System.out.println("Door status: " + boeing747.getDoorStatus());
    System.out.println("Passengers: " + boeing747.getPassengers());
    System.out.println("Landing Gear: " + boeing747.getLandingGear());
  }
}
