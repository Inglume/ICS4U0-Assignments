package jeffnickoop2;

public class PartyStrikeFireworks extends PartyStrike {
  private int fuseTime;
  private boolean isLit;
  private boolean exploded;

  @Override
  public void checkScore() {
    boolean allGoodGuysDead = true;
    boolean allBadGuysDead = true;
    boolean[] goodGuysIsDead = getGoodGuysIsDead();
    boolean[] badGuysIsDead = getBadGuysIsDead();
    int goodGuysScore = getGoodGuysScore();
    int badGuysScore = getBadGuysScore();
    for (int i = 0; i < goodGuysIsDead.length; i++) {
      if (!goodGuysIsDead[i]) {
        allGoodGuysDead = false;
        break;
      }
    }
    if (allGoodGuysDead) {
      setBadGuysScore(badGuysScore + 1);
      badGuysScore++;
      resetRound();
      System.out.println("Bad Guys eliminated Good Guys!");
      return;
    } else if (exploded) {
      setBadGuysScore(badGuysScore + 1);
      badGuysScore++;
      resetRound();
      System.out.println("Bad Guys blew up Good Guys!");
      return;
    }
    if (badGuysScore == 16) {
      resetGame();
      System.out.println("Bad Guys win the Game!");
    }
    for (int i = 0; i < badGuysIsDead.length; i++) {
      if (!badGuysIsDead[i]) {
        allBadGuysDead = false;
        break;
      }
    }
    if (allBadGuysDead && !isLit) {
      setGoodGuysScore(goodGuysScore + 1);
      goodGuysScore++;
      resetRound();
      System.out.println("Good Guys eliminated Bad Guys!");
    }
    if (goodGuysScore == 16) {
      resetGame();
      System.out.println("Good Guys win the Game!");
    }
  }

  @Override
  public void resetRound() {
    boolean[] goodGuysIsDead = getGoodGuysIsDead();
    boolean[] badGuysIsDead = getBadGuysIsDead();
    for (int i = 0; i < goodGuysIsDead.length; i++) {
      goodGuysIsDead[i] = false;
    }
    setGoodGuysIsDead(goodGuysIsDead);
    for (int i = 0; i < badGuysIsDead.length; i++) {
      badGuysIsDead[i] = false;
    }
  }

  public void lightFuse() {
    isLit = true;
    System.out.println("Bad Guys lit the fuse to the fireworks.");
  }

  public void defuse() {
    isLit = false;
    System.out.println("Good Guys defused the fireworks.");
    checkScore();
  }

  public void explode() {
    exploded = true;
    checkScore();
  }

  public int getFuseTime() {
    return fuseTime;
  }

  public void setFuseTime(int fuseTime) {
    this.fuseTime = fuseTime;
  }

  public boolean isLit() {
    return isLit;
  }

  public void setLit(boolean isLit) {
    this.isLit = isLit;
  }

  public boolean isExploded() {
    return exploded;
  }

  public void setExploded(boolean exploded) {
    this.exploded = exploded;
  }

  public PartyStrikeFireworks(String gamemode, String map, int matchTime, int buyTime,
      String[] goodGuys, String[] badGuys, int fuseTime) {
    super(gamemode, map, matchTime, buyTime, goodGuys, badGuys);
    this.fuseTime = fuseTime;
    isLit = false;
    exploded = false;
  }

  public PartyStrikeFireworks() {
    this("competitive", "de_dust2", 105, 15,
        new String[] {"good1", "good2", "good3", "good4", "good5"},
        new String[] {"bad1", "bad2", "bad3", "bad4", "bad5"}, 45);
  }
}
