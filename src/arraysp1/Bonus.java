package arraysp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * The Bonus class a
 * 
 * @author Inglume
 */
public class Bonus {

  HashSet<String> dict;
  final char[][] numChar =
      {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
          {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

  private HashSet<String> loadDict() {
    HashSet<String> dict = new HashSet<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(new File("src/arraysp1/DICT.TXT")));
      String in;
      while ((in = br.readLine()) != null) {
        dict.add(in);
      }
      // System.out.println(dict.size());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return dict;
  }

  private int parsePhoneNumber() {
    Scanner sc = new Scanner(System.in);
    int phoneNumber = 0;
    while (phoneNumber < 1 || phoneNumber > 9999) {
      try {
        System.out.print("Enter a phone number containing 1 - 4 digits (not including 0): ");
        phoneNumber = sc.nextInt();
        int temp = phoneNumber;
        while (temp > 0) {
          if (temp % 10 == 0 || temp % 10 == 1) {
            System.out.println();
            System.out.println("ERROR: Invalid input, try again.");
            continue;
          }
          temp /= 10;
        }
      } catch (NumberFormatException e) {
        System.out.println();
        System.out.println("ERROR: Invalid input, try again.");
      }
    }
    sc.close();
    return phoneNumber;
  }

  private void printExists(String search) {
    if (dict.contains(search)) {
      System.out.println(search);
    }
  }

  private void check(int[] digits, int len, int count, String search) {
    for (char c : numChar[digits[count]]) {
      search = search + c;
      if (count == len - 1) {
        printExists(search);
        // System.out.println("bad: " + search);
      } else {
        check(digits, len, count + 1, search);
      }
      search = search.substring(0, search.length() - 1);
    }
  }

  public Bonus() {
    dict = loadDict();

    // Get current time
    long start = System.currentTimeMillis();

    int phoneNumber = parsePhoneNumber();
    int len = (int) (Math.log10(phoneNumber) + 1);
    int[] digits = new int[len];

    for (int i = 0; i < len; i++) {
      digits[i] = (phoneNumber / (int) Math.pow(10, len - i - 1)) % 10;
      // System.out.println(digits[i]);
    }

    // int d1 = 0, d2 = 0, d3 = 0, d4 = 0;
    // d1 = phoneNumber / 1000;
    // d2 = (phoneNumber / 100) % 10;
    // d3 = (phoneNumber / 10) % 10;
    // d4 = phoneNumber % 10;
    // System.out.printf("%d %d %d %d", d1, d2, d3, d4);
    // System.out.printf("%d %d %d %d", d1, d2, d3, d4);

    check(digits, len, 0, "");

    // Get elapsed time in milliseconds
    long elapsedTimeMillis = System.currentTimeMillis() - start;

    // Get elapsed time in seconds
    float elapsedTimeSec = elapsedTimeMillis / 1000F;

    System.out.println("Elapsed time (s) : " + elapsedTimeSec);
  }

}
