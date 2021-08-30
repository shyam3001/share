import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
    private final JTextField textField;
    private final JTextField textField1;

    public FileManager(JTextField textField, JTextField textField1) {
        this.textField = textField;
        this.textField1 = textField1;
    }

    public void writeToFile(String text) {
        try(FileWriter fileWriter = new FileWriter("output.txt", true)) {
            try(PrintWriter out = new PrintWriter(fileWriter)) {
                try {
                    Thread.sleep(5000);
                    out.println(text);
                    SwingUtilities.invokeLater(() -> {
                        textField1.setText("Wrote: " + text);
                        textField.requestFocus();
                    });
                }
                catch(InterruptedException e) {
                    System.out.println("Interrupting: " + text);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
