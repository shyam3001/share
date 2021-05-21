import java.util.*;

public class Test {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = line.replaceAll("[^a-zA-Z0-9\\s]", "");

        String[] words = line.split(" ");

        Set<String> set = new TreeSet<>();

        for (String word: words) {
            set.add(word);
        }

        for (String word: set) {
            System.out.println(word);
        }
    }
}