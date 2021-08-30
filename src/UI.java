import javax.swing.*;

public class UI {
    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Catch Up Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setLayout(null);

        final JTextField textField = new JTextField();
        textField.setBounds(40, 40, 300, 40);
        frame.add(textField);

        final JButton button = new JButton();
        button.setBounds(40, 120, 300, 40);
        button.setText("Write to File");
        frame.add(button);
        frame.getRootPane().setDefaultButton(button);

        final FileManager fileManager = new FileManager();
        final LogicManager logicManager = new LogicManager(fileManager);

        Thread consumerThread = new Thread(() -> {
            while (true) {
                logicManager.consumeText();
            }
        });
        consumerThread.start();

        button.addActionListener(e -> {
            String text = textField.getText();
            Thread producerThread = new Thread(() -> {
                logicManager.produceText(text);
            });
            producerThread.start();
            textField.setText("");
        });

        frame.setVisible(true);
    }
}
