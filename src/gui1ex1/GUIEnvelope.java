package gui1ex1;

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * The GUIEnvelope displays an envelope on a window
 * 
 * @author Nicholas Glenn
 */
public class GUIEnvelope {
  /**
   * Default constructor
   */
  public GUIEnvelope() {
    JFrame frame = new JFrame("Envelope");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(640, 480);
    frame.add(new Drawing());
    frame.setVisible(true);
  }

  /**
   * The Drawing draws what is displayed on the JFrame
   * 
   * @author Inglume
   */
  class Drawing extends JComponent {
    @Override
    public void paint(Graphics g) {
      g.drawString("Nicholas Glenn", 220, 180);
      g.drawString("20 Tillplain Road", 220, 210);
      for (int i = 0; i <= 150; i += 30) {
        g.drawLine(400, 180 + i, 600, 180 + i);
      }
      g.drawRect(500, 20, 100, 80);
    }
  }

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String[] args) {
    new GUIEnvelope();
  }
}
