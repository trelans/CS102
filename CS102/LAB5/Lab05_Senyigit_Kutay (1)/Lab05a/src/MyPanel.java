/**
 * __Draws bomb___
 */
import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public void paintComponent(Graphics g) {

        Graphics2D graphics2d = (Graphics2D) g;

        super.paintComponent(g);



            // Bomb fuse
            graphics2d.setColor(Color.RED);
            graphics2d.setStroke(new BasicStroke(2));
            graphics2d.drawArc(getWidth() / 2, getHeight() / 9, getWidth() / 4, getHeight() * 2 / 9, 180, -100);

            // Bomb cap
            graphics2d.setColor(Color.GRAY);
            graphics2d.fillRect( 3 * getWidth() / 8, getHeight() / 5, getWidth() / 4, getHeight() / 6);

            // Bomb body
            graphics2d.setColor(Color.BLACK);
            graphics2d.fillOval(getWidth() / 4, getHeight() / 4, getWidth() / 2, getHeight() / 2);

            graphics2d.setBackground(Color.white);

    }
}
