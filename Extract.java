import java.io.File;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract {
    public static void main(String[] args) throws Exception {
        File folder = new File("Tutorial9");
        String[] folderNames = folder.list();
        PrintWriter out = new PrintWriter("extract.csv");

        Pattern pattern = Pattern.compile("[iI][tT][0-9]{8}");

        for (String folderName: folderNames) {
            String data = folderName.split("_")[0];

            Matcher matcher = pattern.matcher(data);
            if (matcher.find()) {
                int index = matcher.start();
                if (index == 0) {
                    String itNumber = data.substring(0, 10);
                    String name = data.substring(11);
                    out.println(itNumber.toUpperCase() + "," + name);
                }
                else {
                    String itNumber = data.substring(index, index+10);
                    String name = data.substring(0, index);
                    out.println(itNumber.toUpperCase() + "," + name);
                }
            }
            else {
                out.println("ERROR - " + folderName);
            }
        }

        out.close();
    }
}
