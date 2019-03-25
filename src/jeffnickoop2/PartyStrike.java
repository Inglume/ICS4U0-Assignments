package jeffnickoop2;

public class PartyStrike {
  private String gamemode;
  private String map;
  private int matchTime;
  private int buyTime;
  private String[] goodGuys;
  private boolean[] goodGuysIsDead;
  private int goodGuysScore;
  private String[] badGuys;
  private boolean[] badGuysIsDead;
  private int badGuysScore;

  public void eliminatePlayer(String attacker, String victim) {
    boolean attackerIsGood = false;
    boolean victimIsGood = false;
    boolean attackerIsDead = false;
    boolean victimIsDead = false;
    boolean attackerExists = false;
    boolean victimExists = false;
    for (int i = 0; i < goodGuys.length; i++) {
      if (goodGuys[i].equals(attacker)) {
        if (goodGuysIsDead[i]) {
          attackerIsDead = true;
        } else {
          attackerExists = true;
          attackerIsGood = true;
        }
      }
      if (goodGuys[i].equals(victim)) {
        if (goodGuysIsDead[i]) {
          victimIsDead = true;
        } else {
          goodGuysIsDead[i] = true;
          victimExists = true;
          victimIsGood = true;
        }
      }
    }
    for (int i = 0; i < badGuys.length; i++) {
      if (badGuys[i].equals(attacker)) {
        if (badGuysIsDead[i]) {
          attackerIsDead = true;
        } else {
          attackerExists = true;
        }
      }
      if (badGuys[i].equals(victim)) {
        if (badGuysIsDead[i]) {
          victimIsDead = true;
        }
        badGuysIsDead[i] = true;
        victimExists = true;
      }
    }
    // Outputs
    if (attacker.equals(victim)) {
      System.out.println("ERROR: attacker cannot be same as victim.");
      for (int i = 0; i < goodGuys.length; i++) {
        if (goodGuys[i].equals(victim) && !victimIsDead) {
          goodGuysIsDead[i] = false;
        }
      }
      for (int i = 0; i < badGuys.length; i++) {
        if (badGuys[i].equals(victim) && !victimIsDead) {
          badGuysIsDead[i] = false;
        }
      }
    } else if (attackerIsDead) {
      System.out.println("ERROR: " + attacker + " is already dead.");
      for (int i = 0; i < goodGuys.length; i++) {
        if (goodGuys[i].equals(victim) && !victimIsDead) {
          goodGuysIsDead[i] = false;
        }
      }
      for (int i = 0; i < badGuys.length; i++) {
        if (badGuys[i].equals(victim) && !victimIsDead) {
          badGuysIsDead[i] = false;
        }
      }
    } else if (victimIsDead) {
      System.out.println("ERROR: " + victim + " is already dead.");
    } else if (!attackerExists) {
      System.out.println("ERROR: " + attacker + " does not exist.");
      for (int i = 0; i < goodGuys.length; i++) {
        if (goodGuys[i].equals(victim) && !victimIsDead) {
          goodGuysIsDead[i] = false;
        }
      }
      for (int i = 0; i < badGuys.length; i++) {
        if (badGuys[i].equals(victim) && !victimIsDead) {
          badGuysIsDead[i] = false;
        }
      }
      return;
    } else if (!victimExists) {
      System.out.println("ERROR: " + victim + " does not exist.");
      return;
    } else if (attackerIsGood == victimIsGood) {
      System.out.println(attacker + " took out his teammate " + victim + ". Shame on you!");
    } else if (attackerIsGood != victimIsGood) {
      System.out.println(attacker + " eliminated " + victim + ".");
    }
    checkScore();
  }

  public void checkScore() {
    boolean allDead = true;
    for (int i = 0; i < goodGuysIsDead.length; i++) {
      if (!goodGuysIsDead[i]) {
        allDead = false;
        break;
      }
    }
    if (allDead) {
      badGuysScore++;
      resetRound();
      System.out.println("Bad Guys Eliminated Good Guys!");
      return;
    }
    if (badGuysScore == 16) {
      resetGame();
      System.out.println("Bad Guys Win the Game!");
    }
    allDead = true;
    for (int i = 0; i < badGuysIsDead.length; i++) {
      if (!badGuysIsDead[i]) {
        allDead = false;
        break;
      }
    }
    if (allDead) {
      goodGuysScore++;
      resetRound();
      System.out.println("Good Guys Eliminated Bad Guys!");
    }
    if (goodGuysScore == 16) {
      resetGame();
      System.out.println("Good Guys Win the Game!");
    }
  }

  public void resetRound() {
    for (int i = 0; i < goodGuysIsDead.length; i++) {
      goodGuysIsDead[i] = false;
    }
    for (int i = 0; i < badGuysIsDead.length; i++) {
      badGuysIsDead[i] = false;
    }
  }

  public void resetGame() {
    resetRound();
    goodGuysScore = 0;
    badGuysScore = 0;
  }

  public void addGoodGuy(String name) {
    int len = goodGuys.length;
    String[] temp = new String[len + 1];
    for (int i = 0; i < len; i++) {
      temp[i] = goodGuys[i];
    }
    temp[len] = name;
    goodGuys = temp;
    boolean[] temp2 = new boolean[len + 1];
    for (int i = 0; i < len; i++) {
      temp2[i] = goodGuysIsDead[i];
    }
    temp2[len] = true;
    goodGuysIsDead = temp2;
  }

  public void addBadGuy(String name) {
    int len = badGuys.length;
    String[] temp = new String[len + 1];
    for (int i = 0; i < len; i++) {
      temp[i] = badGuys[i];
    }
    temp[len] = name;
    badGuys = temp;
    boolean[] temp2 = new boolean[len + 1];
    for (int i = 0; i < len; i++) {
      temp2[i] = badGuysIsDead[i];
    }
    temp2[len] = true;
    badGuysIsDead = temp2;
  }

  public String getGamemode() {
    return gamemode;
  }

  public void setGamemode(String gamemode) {
    this.gamemode = gamemode;
  }

  public String getMap() {
    return map;
  }

  public void setMap(String map) {
    this.map = map;
  }

  public int getMatchTime() {
    return matchTime;
  }

  public void setMatchTime(int matchTime) {
    this.matchTime = matchTime;
  }

  public int getBuyTime() {
    return buyTime;
  }

  public void setBuyTime(int buyTime) {
    this.buyTime = buyTime;
  }

  public String[] getGoodGuys() {
    return goodGuys;
  }

  public void setGoodGuys(String[] goodGuys) {
    this.goodGuys = goodGuys;
  }

  public String[] getBadGuys() {
    return badGuys;
  }

  public void setBadGuys(String[] badGuys) {
    this.badGuys = badGuys;
  }

  public boolean[] getGoodGuysIsDead() {
    return goodGuysIsDead;
  }

  public void setGoodGuysIsDead(boolean[] goodGuysIsDead) {
    this.goodGuysIsDead = goodGuysIsDead;
  }

  public boolean[] getBadGuysIsDead() {
    return badGuysIsDead;
  }

  public void setBadGuysIsDead(boolean[] badGuysIsDead) {
    this.badGuysIsDead = badGuysIsDead;
  }

  public int getGoodGuysScore() {
    return goodGuysScore;
  }

  public void setGoodGuysScore(int goodGuysScore) {
    this.goodGuysScore = goodGuysScore;
  }

  public int getBadGuysScore() {
    return badGuysScore;
  }

  public void setBadGuysScore(int badGuysScore) {
    this.badGuysScore = badGuysScore;
  }

  public PartyStrike(String gamemode, String map, int matchTime, int buyTime, String[] goodGuys,
      String[] badGuys) {
    this.gamemode = gamemode;
    this.map = map;
    this.matchTime = matchTime;
    this.buyTime = buyTime;
    this.goodGuys = goodGuys;
    goodGuysIsDead = new boolean[goodGuys.length];
    goodGuysScore = 0;
    this.badGuys = badGuys;
    badGuysIsDead = new boolean[badGuys.length];
    badGuysScore = 0;
  }

  public PartyStrike() {
    this("competitive", "de_dust2", 105, 15,
        new String[] {"good1", "good2", "good3", "good4", "good5"},
        new String[] {"bad1", "bad2", "bad3", "bad4", "bad5"});
  }
}
