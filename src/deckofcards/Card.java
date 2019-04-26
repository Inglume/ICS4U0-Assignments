package deckofcards;

/**
 * The Card class
 * 
 * @author Nicholas Glenn
 */
public class Card {

  String myFace;
  String mySuit;

  /**
   * Default constructor.
   * 
   * @param theFace
   * @param theSuit
   */
  public Card(String theFace, String theSuit) {
    myFace = theFace;
    mySuit = theSuit;
  }


  @Override
  public String toString() {
    return myFace + " of " + mySuit;
  }

}


