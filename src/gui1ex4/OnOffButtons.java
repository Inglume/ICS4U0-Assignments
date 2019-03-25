package gui1ex4;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * The OnOffButtons creates a window with interactive buttons that change the background colour.
 * 
 * @author Nicholas Glenn
 */
public class OnOffButtons implements ActionListener {
  JFrame frame = new JFrame("On Off Buttons");
  JButton OnButt = new JButton("On");
  JButton OffButt = new JButton("Off");

  /**
   * Default constructor
   */
  public OnOffButtons() {
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(640, 480);
    OnButt.addActionListener(this);
    OffButt.addActionListener(this);
    frame.setLayout(new FlowLayout());
    frame.add(OnButt);
    frame.add(OffButt);
    frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == OnButt) {
      frame.getContentPane().setBackground(Color.white);
    }
    if (e.getSource() == OffButt) {
      frame.getContentPane().setBackground(Color.black);
    }
  }

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    new OnOffButtons();
  }
}
