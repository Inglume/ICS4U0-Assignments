package deckofcards;

/**
 * The DeckofCards Class
 * 
 * @author Nicholas Glenn
 */
public class DeckofCards {

  private Card myDeck[];
  private int myCardNum = 0;

  public DeckofCards() {
    String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Jack", "Queen", "King"};
    String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
    myDeck = new Card[52];
    for (int n = 0; n < 52; n++) {
      myDeck[n] = new Card(faces[n % 13], suits[n / 13]);
    }
  }

  // method to deal cards
  public Card deal() {
    if (myCardNum < 52)
      return myDeck[myCardNum++];
    // post increment: identifier++
    else
      return null;
    // = 52 means all 52 cards are dealt
  }


  public void shuffle() {
    for (int i = 51; i > 0; i--) {
      int j = (int) (Math.random() * (i + 1));
      Card temp = new Card(myDeck[i].myFace, myDeck[i].mySuit);
      myDeck[i] = myDeck[j];
      myDeck[j] = temp;
    }
  }

}


