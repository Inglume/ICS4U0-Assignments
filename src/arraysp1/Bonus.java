package arraysp1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The Bonus class takes a 1 - 4 digit phone number and searches for all words corresponding with it
 * in a dictionary.
 * 
 * @author Nicholas Glenn
 */

public class Bonus {

  /**
   * Dictionary containing all words from DICT.TXT.
   */
  static HashSet<String> dict;

  /**
   * Contains letters corresponding to numbers on number pad.
   */
  static final char[][] NUMPAD =
      {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
          {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

  /**
   * Digits in phone number inputted by user.
   */
  static int[] digits;

  /**
   * Length of digits.
   */
  static int len;

  /**
   * Is true iff at least one word has been found for phone number.
   */
  static boolean found;

  /**
   * Loads dictionary with words from DICT.TXT.
   * 
   * @return dict - HashSet containing all words from DICT.TXT.
   */
  private static HashSet<String> loadDict() {
    HashSet<String> dict = new HashSet<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader("src/arraysp1/DICT.TXT"));
      String in;
      while ((in = br.readLine()) != null) {
        dict.add(in);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dict;
  }

  /**
   * Prompts for and parses phone number.
   * 
   * @return phoneNumber - result of input. Will be 1 - 4 digit long integer not including 0 or 1,
   *         or -1.
   */
  private static int parsePhoneNumber() {
    Scanner sc = new Scanner(System.in);
    int phoneNumber = 0;
    while (phoneNumber < 1 || phoneNumber > 9999) {
      try {
        System.out.print(
            "Enter a phone number containing 1 - 4 digits (not including 0 or 1, enter '-1' to quit): ");
        if ((phoneNumber = sc.nextInt()) == -1) {
          return -1;
        }
        int temp = phoneNumber;
        while (temp > 0) {
          if (temp % 10 == 0 || temp % 10 == 1) {
            System.out.println("ERROR: Invalid input, try again.");
            phoneNumber = 0;
            break;
          }
          temp /= 10;
        }
      } catch (NumberFormatException e) {
        System.out.println("ERROR: Invalid input, try again.");
        phoneNumber = 0;
      }
    }
    return phoneNumber;
  }

  /**
   * Prints the search string if it is found in the dictionary.
   * 
   * @param search - the string to be searched in the dictionary
   */
  private static void printExists(String search) {
    if (dict.contains(search)) {
      System.out.println(search);
      found = true;
    } else if (dict.contains(search.toLowerCase())) {
      System.out.println(search.toLowerCase());
      found = true;
    } else if (dict.contains(search.toUpperCase())) {
      System.out.println(search.toUpperCase());
      found = true;
    }
  }

  /**
   * The first call of the recursive check method without params. Adds the first character as a
   * capital letter.
   */
  private static void check() {
    for (char c : NUMPAD[digits[0]]) {
      String search = "" + (char) (c - 32);
      if (1 == len) {
        printExists(search);
      } else {
        check(1, search);
      }
    }
  }

  /**
   * The method used following the initial call of check() without params.
   * 
   * @param count - counts the depth of the recursion
   * @param search - the string to be searched in the dictionary
   */
  private static void check(int count, String search) {
    for (char c : NUMPAD[digits[count]]) {
      search = search + c;
      if (count == len - 1) {
        printExists(search);
      } else {
        check(count + 1, search);
      }
      search = search.substring(0, search.length() - 1);
    }
  }

  /**
   * Main method. Runs everything and counts time elapsed.
   * 
   * @param args - Command-line arguments
   */
  public static void main(String args[]) {
    dict = loadDict();
    int phoneNumber = 0;
    while (phoneNumber != -1) {
      if ((phoneNumber = parsePhoneNumber()) == -1) {
        return;
      }

      long start = System.nanoTime();

      len = (int) (Math.log10(phoneNumber) + 1);
      digits = new int[len];
      for (int i = 0; i < len; i++) {
        digits[i] = (phoneNumber / (int) Math.pow(10, len - i - 1)) % 10;
      }

      check();

      if (!found) {
        System.out.println("No words could be found");
      } else {
        found = false;
      }

      double elapsedTimeMillis = (double) (System.nanoTime() - start) / 1000000;

      System.out.printf("Elapsed time (ms) : %f\n", elapsedTimeMillis);
    }
  }

}
