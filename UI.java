import java.awt.*;
import javax.swing.*;

public class UI extends JPanel {
    public static void main(String[] args) {
        UI ui = new UI();
        ui.setSize(600, 600);
        ui.setLayout(null);

        // create fluent API - for extra marks in `alternate` marksheet
        // ui.circle(200, 200).dim(200, 200).color(Color.RED);
        // ui.rect(150, 150).dim(100, 100).fill()

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(ui);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D brush = (Graphics2D)g; // Java2D API

        brush.setColor(Color.BLACK);
        brush.drawArc(200, 200, 200, 200, 0, 360);

        brush.setColor(Color.RED);
        brush.fillRect(150, 150, 100, 100);
    }
}