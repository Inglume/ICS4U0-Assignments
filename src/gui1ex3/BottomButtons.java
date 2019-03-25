package gui1ex3;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The BottomButtons creates a window with one top button and three bottom buttons.
 * 
 * @author Nicholas Glenn
 */
public class BottomButtons {
  /**
   * Default constructor
   */
  public BottomButtons() {
    JFrame frame = new JFrame("Bottom Buttons");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.setLayout(new GridLayout(5, 1)); // Makes grid to put JPanels inside
    JPanel top = new JPanel();
    top.setLayout(new FlowLayout());
    top.add(new JButton("top")); // JButton for top frame
    frame.add(top); // Added top JPanel to top row
    frame.add(new JPanel()); // Added Middle JPanel with nothing inside it
    frame.add(new JPanel()); // Added Middle JPanel with nothing inside it
    frame.add(new JPanel()); // Added Middle JPanel with nothing inside it
    JPanel bottom = new JPanel();
    bottom.setLayout(new FlowLayout());
    bottom.add(new JButton("Yes")); // Three buttons inside bottom JPanel
    bottom.add(new JButton("No"));
    bottom.add(new JButton("??"));
    frame.add(bottom); // Added bottom JPanel to bottom row
    frame.setVisible(true);
  }

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    new BottomButtons();
  }
}
