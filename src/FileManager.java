import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
    public void writeToFile(String text) {
        try(FileWriter fileWriter = new FileWriter("output.txt", true)) {
            try(PrintWriter out = new PrintWriter(fileWriter)) {
                out.println(text);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
