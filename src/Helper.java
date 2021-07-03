import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;

public class Helper {
    public static void save(Object[] transaction) {
        String file = new Date().toString().substring(0,19).replaceAll("[ :]", "-").concat(".sav");
        try(
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)
        ){
            oos.writeObject(transaction);
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static Object[] load(String file) {
        try(
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ){
            return (Object[])ois.readObject();
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
}

