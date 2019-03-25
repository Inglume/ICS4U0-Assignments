package jeffnickoop2;

public class Driver {
  public static void main(String[] args) {
    System.out.println("Game 1");
    PartyStrike fiveVersusFive = new PartyStrike();
    fiveVersusFive.eliminatePlayer("good4", "bad1");
    fiveVersusFive.eliminatePlayer("good4", "bad3");
    fiveVersusFive.eliminatePlayer("good4", "bad2");
    fiveVersusFive.eliminatePlayer("bad2", "good4");
    fiveVersusFive.eliminatePlayer("good4", "good4");
    fiveVersusFive.addGoodGuy("good6");
    fiveVersusFive.addBadGuy("bad6");
    fiveVersusFive.eliminatePlayer("good2", "bad5");
    fiveVersusFive.eliminatePlayer("good1", "bad4");
    System.out.println("\nGame 2");
    PartyStrikeFireworks threeVersusThree = new PartyStrikeFireworks("competitive", "de_mirage",
        120, 10, new String[] {"cool", "cooler", "coolest"},
        new String[] {"thing1", "thing2", "thing3"}, 30);
    threeVersusThree.setGoodGuysScore(15);
    threeVersusThree.setBadGuysScore(14);
    threeVersusThree.eliminatePlayer("cool", "thing2");
    threeVersusThree.eliminatePlayer("cooler", "thing3");
    threeVersusThree.lightFuse();
    threeVersusThree.eliminatePlayer("thing1", "cooler");
    threeVersusThree.eliminatePlayer("thing1", "cool");
    threeVersusThree.eliminatePlayer("coolest", "thing1");
    threeVersusThree.defuse();
  }
}
