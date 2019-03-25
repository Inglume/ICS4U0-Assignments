package gui1ex2;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The ThreeButtons displays three buttons on a window.
 * 
 * @author Nicholas Glenn
 */
public class ThreeButtons {
  /**
   * Default constructor
   */
  public ThreeButtons() {
    JFrame frame = new JFrame("Three Buttons");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(240, 90);
    frame.setLayout(new GridLayout(1, 3));
    frame.add(new JButton("A"));
    frame.add(new JButton("B"));
    frame.add(new JButton("C"));
    frame.setVisible(true);
  }

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    new ThreeButtons();
  }
}
