package Chapter12.Listings;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Shady Bajary
 * @Listing 12.2
 */
public class MyFrameWithComponents {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyFrameWithComponents");

        // Add a button into the frame
        JButton jbtOK = new JButton("OK");
        frame.add(jbtOK);

        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); //Center the frame
        frame.setVisible(true);
        
        java.awt.Container container = frame.getContentPane();
        container.add(jbtOK);
    }
}
