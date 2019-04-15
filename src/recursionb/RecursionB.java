package recursionb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * The RecursionB class demonstrates the use of recursive methods.
 * 
 * @author Nicholas Glenn
 */
public class RecursionB {

  /**
   * Reverses the lines in a String.
   * 
   * @param s - the String to reverse
   * @return the reversed String
   */
  private static String revString(String s) {
    if (s.equals("."))
      return ".";
    return revString(s.substring(s.indexOf('\n') + 1)) + '\n' + s.substring(0, s.indexOf('\n'));
  }

  /**
   * Reverses the digits in an integer.
   * 
   * @param i - the integer to reverse
   * @return the reversed integer
   */
  private static int revDigits(int i) {
    if (i < 10)
      return i;
    return (i % 10) * (int) (Math.pow(10, (int) Math.log10(i))) + revDigits(i / 10);
  }

  /**
   * Searches for an element in a Comparable array.
   * 
   * @param a - the array to search
   * @param target - the element to find
   * @return true iff target was found in array a
   */
  private static boolean searchItem(Comparable[] a, Comparable target) {
    if (a.length == 0)
      return false;
    if (a[0].equals(target))
      return true;
    return searchItem(Arrays.copyOfRange(a, 1, a.length), target);
  }

  /**
   * Looks for a path to an exit starting at the first row and ending at the last row of the maze.
   * 
   * @param maze - a 2d array consisting of paths (0) and walls (1).
   * @return true iff a path from an entrance to an exit has been found
   */
  private static boolean traverseMaze(int[][] maze) {
    boolean[][] visited = new boolean[maze.length][maze.length];
    return dfs(maze, visited, 0, 0) || dfs(maze, visited, 0, 1) || dfs(maze, visited, 0, 2)
        || dfs(maze, visited, 0, 3) || dfs(maze, visited, 0, 4);
  }

  /**
   * Performs a depth-first search starting at the index [row, col] in the maze.
   * 
   * @param maze - the maze to search
   * @param visited - a 2d array showing which indices have already been visited (to avoid infinite
   *        loops)
   * @param row - the row that is being searched
   * @param col - the column that is being searched
   * @return true iff the exit has been found
   */
  private static boolean dfs(int[][] maze, boolean[][] visited, int row, int col) {
    if (!isValid(maze, visited, row, col)) {
      return false;
    }
    visited[row][col] = true;
    if (row == maze.length - 1) {
      return true;
    }
    return dfs(maze, visited, row - 1, col) || dfs(maze, visited, row + 1, col)
        || dfs(maze, visited, row, col - 1) || dfs(maze, visited, row, col + 1);
  }

  /**
   * Checks if the coordinates can be searched.
   * 
   * @param maze - the maze to search
   * @param visited - a 2d array showing which indices have already been visited (to avoid infinite
   *        loops)
   * @param row - the row that is being searched
   * @param col - the column that is being searched
   * @return true if the coordinates are within bounds of the maze and have not been visited and are
   *         traversable (not a wall).
   */
  private static boolean isValid(int[][] maze, boolean[][] visited, int row, int col) {
    return row >= 0 && row < maze.length && col >= 0 && col < maze.length && !visited[row][col]
        && maze[row][col] == 0;
  }

  /**
   * The driver method.
   * 
   * @param args - command-line arguments
   */
  public static void main(String[] args) {
    Comparable[] words = new String[] {"aardvark", "baby", "calf", "dream", "elephant"};
    Comparable[] nums = new Integer[] {1, 3, 2, 11, 3};
    int[][] maze = new int[][] {
      {0, 0, 1, 0, 1},
      {1, 0, 1, 0, 0},
      {1, 0, 1, 0, 0},
      {1, 1, 0, 0, 1},
      {1, 1, 0, 1, 1}};

    // Input for revString()
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String in, s = "";
    System.out.print("Enter what you want to reverse separated by newlines: ");
    try {
      while (!(in = br.readLine()).equals(".")) {
        s += in + '\n';
      }
    } catch (IOException e) {
    }
    s += ".";

    System.out.printf("Reversed String: %s\n", revString(s));
    System.out.printf("Reversed Number: %d -> %d\n", 345, revDigits(345));
    System.out.printf("Reversed Number: %d -> %d\n", 4, revDigits(4));
    System.out.printf("Search Item: %s -> %s\n", "calf", searchItem(words, "calf"));
    System.out.printf("Search Item: %s -> %s\n", "cow", searchItem(words, "cow"));
    System.out.printf("Search Item: %s -> %s\n", 5, searchItem(nums, 5));
    System.out.printf("Is there a path in the maze? %s\n", traverseMaze(maze));
  }

}
