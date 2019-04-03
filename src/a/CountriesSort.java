package a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * Problem 3 of the Arrays Assignments Reads from a file with country names, capitals, area, and
 * population. Sorts the data and prints it onto other files.
 * </p>
 * <p>
 * Variable Name Type Purpose <b>country</b> String [] stores the names of the countries in an array
 * of length lines <b>capital</b> String [] stores the capitals of the countries in an array of
 * length lines <b>area</b> double [] stores the area of the countries in an array of length lines
 * <b>population</b> int [] stores the population of the countries in an array of length lines
 * <b>lines</b> int stores the number of lines in file
 *
 * @author Nayaab Ali, Marina Semenova, Alyssa Wang
 * @version 1.0, Mar. 26, 2019
 */
public class CountriesSort {

  String[] country;
  String[] capital;
  double[] area;
  int[] population;
  int lines = 0;

  /**
   * Reads file Stores data in 4 different arrays
   *
   * Local variables: <b>br</b> BufferedReader to read from file <b>bad</b> boolean that turns true
   * if the line is one of the outliers <b>count</b> int that counts how many spaces there are in
   * the country name, determining how many words there are <b>all</b> String temporarily stores the
   * line in the file <b>all2</b> String [] is the split of all <b>out</b> String [] storing all the
   * outlier country names
   * 
   * @throws IOException
   */
  public void readInput() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Countries-Population.txt"));

    while (br.readLine() != null) {
      lines++;
    }

    country = new String[lines];
    capital = new String[lines];
    area = new double[lines];
    population = new int[lines];

    br = new BufferedReader(new FileReader("Countries-Population.txt"));

    // goes through all lines in the file
    for (int x = 0; x < lines; x++) {
      boolean bad = false;
      int count = 1;
      String all = br.readLine();
      String[] out = {"Antigua and Barbuda", "Bosnia and Herzegovina", "Brunei Darussalam",
          "Burkina Faso", "Cabo Verde", "Cape Verde", "Central African Republic",
          "Congo, Democratic Republic of the", "Congo, Republic of", "Costa Rica", "Czech Republic",
          "Côte D'Ivoire", "Dominican Republic", "East Timor", "El Salvador", "Equatorial Guinea",
          "Guinea Bissau", "Korea, North", "Korea, South", "Marshall Islands", "Myanmar (Burma)",
          "New Zealand", "Papua New Guinea", "Saint Lucia", "San Marino", "Saudi Arabia",
          "Sierra Leone", "Solomon Islands", "South Africa", "South Sudan", "Sri Lanka",
          "St. Kitts and Nevis", "St. Lucia", "St. Vincent and the Grenadines",
          "São Tomé and Príncipe", "Trinidad and Tobago", "United Arab Emirates",
          "United Kingdom", "United States", "Vatican City", "Western Sahara"};
      // checks if the line is one of the outliers
      for (int y = 0; y < out.length; y++) {
        if (all.indexOf(out[y]) != -1) {
          bad = true;
          count = out[y].length() - out[y].replace(" ", "").length();
          break;
        }
      }
      String[] all2 = all.split(" ");
      area[x] = Double.parseDouble(all2[all2.length - 2].replaceAll(",", ""));
      population[x] = Integer.parseInt(all2[all2.length - 1].replaceAll(",", ""));
      if (bad) {
        if (count == 1) {
          country[x] = all2[0] + " " + all2[1];
          for (int i = 2; i < all2.length - 2; i++) {
            capital[x] = "";
            capital[x] += all2[i] + " ";
          }
        } else if (count == 2) {
          country[x] = all2[0] + " " + all2[1] + " " + all2[2];
          for (int i = 3; i < all2.length - 2; i++) {
            capital[x] = "";
            capital[x] += all2[i] + " ";
          }
        } else if (count == 3) {
          country[x] = all2[0] + " " + all2[1] + " " + all2[2] + " " + all2[3];
          for (int i = 4; i < all2.length - 2; i++) {
            capital[x] = "";
            capital[x] += all2[i] + " ";
          }
        } else if (count == 4) {
          country[x] = all2[0] + " " + all2[1] + " " + all2[2] + " " + all2[3] + " " + all2[4];
          for (int i = 5; i < all2.length - 2; i++) {
            capital[x] = "";
            capital[x] += all2[i] + " ";
          }
        }
      } else {
        country[x] = all2[0];
        for (int i = 1; i < all2.length - 2; i++) {
          capital[x] = "";
          capital[x] += all2[i] + " ";
        }
      }
    }
    br.close();
  }

  /**
   * Sorts the data in array from original file alphabetically
   *
   * @throws IOException
   *         <p>
   *         Local Variables <b>n</b> array length for the while loop <b>maxPos</b> stores position
   *         that needs to be switched <b>temp</b> stores element of array temporarily to be
   *         switched with other element <b>tempP</b> stores population to be switched <b>output</b>
   *         PrintWriter to write to a new file
   */
  public void sortName() throws IOException {
    int n = lines;
    int maxPos;
    while (n > 1) {
      maxPos = 0;
      for (int x = 1; x < n; x++)
        if (country[x].charAt(0) != country[maxPos].charAt(0)) {
          if (country[x].charAt(0) > country[maxPos].charAt(0))
            maxPos = x;
        } else {
          if (country[x].substring(1).compareTo(country[maxPos].substring(1)) > 0) {
            maxPos = x;
          }
        }

      String temp = country[maxPos];
      country[maxPos] = country[n - 1];
      country[n - 1] = temp;
      int tempP = population[maxPos];
      population[maxPos] = population[n - 1];
      population[n - 1] = tempP;
      n--;
    }

    PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("sortedByCountry.txt")));
    for (int i = 0; i < lines; i++) {
      output.print(country[i]);
      for (int x = country[i].length(); x <= 35; x++) {
        output.print(" ");
      }
      output.println(population[i]);
    }
    output.close();
  }

  /**
   * Sorts original data by marks from highest to lowest Puts data into new file
   *
   * @throws IOException
   *         <p>
   *         Local Variables <b>n</b> array length for the while loop <b>maxPos</b> stores position
   *         that needs to be switched <b>temp</b> stores element of array temporarily to be
   *         switched with other element <b>tempP</b> stores population to be switched <b>output</b>
   *         PrintWriter to write to a new file
   */
  public void sortPop() throws IOException {
    int n = lines;
    int maxPos = 0;
    while (n > 1) {
      maxPos = 0;
      for (int x = 1; x < n; x++)
        if (population[x] <= population[maxPos])
          maxPos = x;

      String temp = country[maxPos];
      country[maxPos] = country[n - 1];
      country[n - 1] = temp;
      int tempP = population[maxPos];
      population[maxPos] = population[n - 1];
      population[n - 1] = tempP;
      n--;
    }

    PrintWriter output =
        new PrintWriter(new BufferedWriter(new FileWriter("sortedByPopulation.txt")));
    for (int i = 0; i < lines; i++) {
      output.print(country[i]);
      for (int x = country[i].length(); x <= 35; x++) {
        output.print(" ");
      }
      output.println(population[i]);
    }
    output.close();
  }

  /**
   * Main method creates CountriesSort object and runs methods
   *
   * @param args args
   */
  public static void main(String[] args) throws IOException {
    CountriesSort m = new CountriesSort();
    m.readInput();
    m.sortName();
    m.sortPop();
  }
}
