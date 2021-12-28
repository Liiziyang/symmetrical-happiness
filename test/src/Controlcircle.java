import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Controlcircle extends JFrame {
    private JButton jbtEnlarge = new JButton("Enlarge");
    private JButton jbtShrink = new JButton("Shrink");
    private CirclePanel canvas = new CirclePanel();
    public Controlcircle() {
        JPanel panel = new JPanel(); // Use the panel to group buttons
        panel.add(jbtEnlarge);
        panel.add(jbtShrink);
        this.add(canvas, BorderLayout.CENTER); // Add canvas to center
        this.add(panel, BorderLayout.SOUTH);// Add buttons to the frame
// Fill in the code to listen to the action event
    }
    /** Main method */
    public static void main(String[] args) {
        JFrame frame = new Controlcircle();
        frame.setTitle("ControlCircle2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
// Fill in the code to response the enlarge or shrink event

        }
    }
}
class CirclePanel extends JPanel {
    private int radius = 50; // Default circle radius
/** Enlarge the circle */
public void enlarge() {
    radius = (int)(radius * 1.1);
    this.repaint();
}
    /** Enlarge the circle */
    public void shrink() {
        radius = (int)(radius * 0.9);
        this.repaint();
    }
    /** Repaint the circle */
    protected void paintsComponent(Graphics g) {
        super.paintComponent(g);
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
// Fill in the code to draw a circle in the center of the canvas with the radius of this class

    }
}