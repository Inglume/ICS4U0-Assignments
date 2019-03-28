package arraysp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Bonus {

  public Bonus() {
    char[][] numChar = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
        {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    HashSet<String> dict = new HashSet<>();
    try {
      File f = new File("src/arraysp1/DICT.TXT");
      BufferedReader br = new BufferedReader(new FileReader(f));
      String in;
      while ((in = br.readLine()) != null) {
        dict.add(in);
      }
      // System.out.println(dict.size());
    } catch (IOException e) {
      e.printStackTrace();
    }
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
    // Get current time
    long start = System.currentTimeMillis();
    // int len = (int) (Math.log10(phoneNumber) + 1);
    int d1 = 0, d2 = 0, d3 = 0, d4 = 0;
    d1 = phoneNumber / 1000;
    d2 = (phoneNumber / 100) % 10;
    d3 = (phoneNumber / 10) % 10;
    d4 = phoneNumber % 10;
    System.out.printf("%d %d %d %d", d1, d2, d3, d4);
    for (char c : numChar[d4]) {
      String search = "" + c;
      for (char cc : numChar[d3]) {
        search = cc + search;
        for (char ccc : numChar[d2]) {
          search = ccc + search;
          for (char cccc : numChar[d1]) {
            search = cccc + search;
          }
          if (dict.contains(search)) {
            System.out.println(search);
          }
        }
        if (dict.contains(search)) {
          System.out.println(search);
        }
      }
      if (dict.contains(search)) {
        System.out.println(search);
      }
      System.out.println("bad: " + search);
    }
    // Get elapsed time in milliseconds
    long elapsedTimeMillis = System.currentTimeMillis() - start;

    // Get elapsed time in seconds
    float elapsedTimeSec = elapsedTimeMillis / 1000F;
    System.out.println(elapsedTimeSec);
  }

}
