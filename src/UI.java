import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        final JButton button1 = new JButton();
        button1.setBounds(40, 200, 300, 40);
        button1.setText("Stop Everything");
        frame.add(button1);

        final JTextField textField1 = new JTextField();
        textField1.setBounds(40, 280, 300, 40);
        textField1.setEditable(false);
        frame.add(textField1);

        final FileManager fileManager = new FileManager(textField, textField1);
        final LogicManager logicManager = new LogicManager(fileManager);
        final ExecutorService threadPool = Executors.newCachedThreadPool();

        Runnable consumer = () -> {
            while (true) {
                logicManager.consumeText();
            }
        };
        threadPool.submit(consumer);
        threadPool.submit(consumer);
        threadPool.submit(consumer);

        button.addActionListener(e -> {
            String text = textField.getText();
            threadPool.submit(() -> {
                logicManager.produceText(text);
            });
            textField.setText("");
        });

        button1.addActionListener(e -> {
            threadPool.shutdownNow();
        });

        frame.setVisible(true);
    }
}
