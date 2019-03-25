package arraysp1;

import java.util.Scanner;

public class CountingCards {
  public CountingCards() {
    Scanner sc = new Scanner(System.in);
    String cards = sc.nextLine();
    for (int i = 0; i < 13; i++) {
      byte rank = (byte) cards.charAt(i);
      char suit = cards.charAt(i + 1);
      // TODO
    }
  }
}
