package arraysp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * The Card class stores the rank and suit of a card and includes the toString() and compareTo()
 * methods.
 * 
 * @author Nicholas Glenn
 */
class Card {

  /**
   * Rank of card.
   */
  char rank;

  /**
   * Suit of card.
   */
  char suit;

  /**
   * Constructor.
   * 
   * @param rank - rank of card
   * @param suit - suit of card
   */
  public Card(char rank, char suit) {
    this.rank = rank;
    this.suit = suit;
  }

  /**
   * Card as string.
   */
  @Override
  public String toString() {
    return "" + rank + suit;
  }

  /**
   * Compares this Card to another Card.
   * 
   * @param c - Card object to compare
   * @return - 1 if this is greater than c, -1 if this is less than c, 0 if equal
   */
  public int compareTo(Card c) {
    if (this.rank == c.rank) {
      return 0;
    } else if (this.rank == 'A') {
      return 1;
    } else if (c.rank == 'A') {
      return -1;
    } else if (this.rank == 'K') {
      return 1;
    } else if (c.rank == 'K') {
      return -1;
    } else if (this.rank == 'Q') {
      return 1;
    } else if (c.rank == 'Q') {
      return -1;
    } else if (this.rank == 'J') {
      return 1;
    } else if (c.rank == 'J') {
      return -1;
    } else if (this.rank == 'T') {
      return 1;
    } else if (c.rank == 'T') {
      return -1;
    } else if (this.rank > c.rank) {
      return 1;
    }
    return -1;
  }

}


/**
 * The CountingCards class sorts cards in a hand and calculates their score in Bridge.
 * 
 * @author Inglume
 */
public class CountingCards {

  /**
   * One set of cards read from file.
   */
  static Card[][] cards = new Card[4][13];

  /**
   * True iff nth hand at index n is invalid.
   */
  static boolean[] bad = new boolean[4];

  /**
   * Sets the static variable cards according to the file
   */
  private static void resetCards() {
    Card[][] cards = new Card[4][13];
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      for (int i = 0; i < 4; i++) {
        String input = br.readLine();
        if (input.length() == 26) {
          for (int j = 0; j < 26; j += 2) {
            char rank = 0;
            char suit = 0;
            char temp = 0;
            if (((temp = input.charAt(j)) >= '2' && temp <= '9') || temp == 'T' || temp == 'J'
                || temp == 'Q' || temp == 'K' || temp == 'A') {
              rank = temp;
            } else {
              System.out.println("Invalid hand, use appropriate characters.");
              bad[i] = true;
              break;
            }
            if ((temp = input.charAt(j + 1)) == 'S' || temp == 'H' || temp == 'C' || temp == 'D') {
              suit = temp;
            } else {
              System.out.println("Invalid hand, use appropriate characters.");
              bad[i] = true;
              break;
            }
            cards[i][j / 2] = new Card(rank, suit);
          }
        } else {
          System.out.println("Invalid hand, hand must have 13 cards.");
          bad[i] = true;
        }
      }
    } catch (IOException e) {
    }
    for (int i = 0; i < 4; i++) {
      if (!bad[i]) {
        for (int j = 0; j < 13; j++) {
          CountingCards.cards[i][j] = cards[i][j];
        }
      }
    }
  }

  /**
   * Merges two sorted subarrays of an ArrayList together.
   * 
   * @param list - ArrayList to merge
   * @param l - left bound of merge
   * @param m - middle bound of merge
   * @param r - right bound of merge
   */
  private static void merge(ArrayList<Card> list, int l, int m, int r) {
    ArrayList<Card> temp = new ArrayList<Card>();
    int i = l, j = m + 1;
    while (i <= m && j <= r) {
      if (list.get(i).compareTo(list.get(j)) == 1) {
        temp.add(list.get(i));
        i++;
      } else {
        temp.add(list.get(j));
        j++;
      }
    }
    while (i <= m) {
      temp.add(list.get(i));
      i++;
    }
    while (j <= r) {
      temp.add(list.get(j));
      j++;
    }
    for (int n = l; n <= r; n++) {
      list.set(n, temp.get(n - l));
    }
  }

  /**
   * Recursive call of merge sort which sorts cards.
   * 
   * @param list - ArrayList to be sorted
   * @param l - left bound of sort
   * @param r - right bound of sort
   */
  private static void sort(ArrayList<Card> list, int l, int r) {
    if (l < r) {
      int m = (r + l) / 2;
      sort(list, l, m);
      sort(list, m + 1, r);
      merge(list, l, m, r);
    }
  }

  /**
   * Initial call of merge sort which sorts cards.
   * 
   * @param list - ArrayList to be sorted
   */
  private static void sort(ArrayList<Card> list) {
    int l = 0, r = list.size() - 1, m = (r + l) / 2;
    sort(list, l, m);
    sort(list, m + 1, r);
    merge(list, l, m, r);
  }

  /**
   * Gives points based on number of cards of given suit based on Bridge rules.
   * 
   * @param list - ArrayList to count
   * @return sum - points based on size of array
   */
  private static int suitNum(ArrayList<Card> list) {
    int sum = 0;
    if (list.size() == 0) {
      sum += 3;
    } else if (list.size() == 1) {
      sum += 2;
    } else if (list.size() == 2) {
      sum++;
    }
    return sum;
  }

  /**
   * Calculates points for hands and outputs sorted results.
   */
  private static void evaluate() {
    for (int i = 0; i < 4; i++) {
      if (!bad[i]) {
        int points = 0;
        ArrayList<Card> spades = new ArrayList<Card>();
        ArrayList<Card> hearts = new ArrayList<Card>();
        ArrayList<Card> clubs = new ArrayList<Card>();
        ArrayList<Card> diamonds = new ArrayList<Card>();

        for (int j = 0; j < 13; j++) {
          Card card = new Card(cards[i][j].rank, cards[i][j].suit);
          char temp = cards[i][j].rank;
          if (temp == 'J') {
            points++;
          } else if (temp == 'Q') {
            points += 2;
          } else if (temp == 'K') {
            points += 3;
          } else if (temp == 'A') {
            points += 4;
          }
          temp = cards[i][j].suit;
          if (temp == 'S') {
            spades.add(card);
          } else if (temp == 'H') {
            hearts.add(card);
          } else if (temp == 'C') {
            clubs.add(card);
          } else if (temp == 'D') {
            diamonds.add(card);
          }
        }

        points += suitNum(spades);
        points += suitNum(hearts);
        points += suitNum(clubs);
        points += suitNum(diamonds);

        System.out.println("\nHand " + (i + 1));

        System.out.print("Spades: ");
        if (spades.size() > 1) {
          sort(spades);
        }
        for (Card c : spades) {
          System.out.print(c + " ");
        }

        System.out.print("\nHearts: ");
        if (hearts.size() > 1) {
          sort(hearts);
        }
        for (Card c : hearts) {
          System.out.print(c + " ");
        }

        System.out.print("\nClubs: ");
        if (clubs.size() > 1) {
          sort(clubs);
        }
        for (Card c : clubs) {
          System.out.print(c + " ");
        }

        System.out.print("\nDiamonds: ");
        if (diamonds.size() > 1) {
          sort(diamonds);
        }
        for (Card c : diamonds) {
          System.out.print(c + " ");
        }

        System.out.println("\nTotal points: " + points);
      }
    }
  }

  /**
   * Main method.
   * 
   * @param args - Command-line arguments
   * @throws IOException - thrown by BufferedReader br
   */
  public static void main(String[] args) throws IOException {
    // BufferedReader br = new BufferedReader(new FileReader("file.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      resetCards();
      evaluate();
    }
  }

}
