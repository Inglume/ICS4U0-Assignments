package arraysp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The Bonus class takes a 1 - 4 digit phone number and searches for all words corresponding with it
 * in a dictionary.
 * 
 * @author Inglume
 */

public class Bonus {

  /**
   * Dictionary containing all words from DICT.TXT.
   */
  HashSet<String> dict;

  /**
   * Contains letters corresponding to numbers on number pad.
   */
  final char[][] numChar =
      {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
          {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

  /**
   * Digits in phone number inputted by user.
   */
  int[] digits;

  /**
   * Length of digits.
   */
  int len;

  /**
   * Is true iff at least one word has been found for phone number
   */
  boolean found;

  /**
   * Loads dictionary with words from DICT.TXT.
   * 
   * @return dict - HashSet containing all words from DICT.TXT.
   */
  private HashSet<String> loadDict() {
    HashSet<String> dict = new HashSet<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(new File("src/arraysp1/DICT.TXT")));
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
  private int parsePhoneNumber() {
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
  private void printExists(String search) {
    if (dict.contains(search)) {
      System.out.println(search);
      found = true;
    }
  }

  /**
   * The first call of the recursive check method without params (same as calling
   * {@link #check(int, String) check} method with params (0, "")).
   */
  private void check() {
    for (char c : numChar[digits[0]]) {
      String search = "" + c;
      if (1 == len) {
        printExists(search);
      } else {
        check(1, search);
      }
    }
  }

  /**
   * The method used following the initial call of check() without params
   * 
   * @param count - counts the depth of the recursion
   * @param search - the string to be searched in the dictionary
   */
  private void check(int count, String search) {
    for (char c : numChar[digits[count]]) {
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
   * Default constructor.
   */
  public Bonus() {
    dict = loadDict();
    int phoneNumber = 0;
    while (phoneNumber != -1) {
      if ((phoneNumber = parsePhoneNumber()) == -1) {
        return;
      }

      // Get current time
      long start = System.currentTimeMillis();

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

      // Get elapsed time in milliseconds
      long elapsedTimeMillis = System.currentTimeMillis() - start;

      // Get elapsed time in seconds
      float elapsedTimeSec = elapsedTimeMillis / 1000F;

      System.out.println("Elapsed time (ms) : " + elapsedTimeMillis);
    }
  }

}
