package deckofcards;

// Conlon
// composition
// client code for Deck of Cards

import java.util.Scanner;

public class DeckCardsClient {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    DeckofCards deck1 = new DeckofCards();
    deck1.shuffle();
    System.out.println(); // deal 2 rows of 4 cards
    System.out.printf("%-20s%-20s%-20s\n", deck1.deal(), deck1.deal(), deck1.deal());
    System.out.println();
    System.out.printf("%-20s%-20s%-20s\n", deck1.deal(), deck1.deal(), deck1.deal());
  }

}


