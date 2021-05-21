import java.util.*;

public class UniqueWords {
    public static void main(String args[]) {
        Set<String> set = new TreeSet<String>();

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        text = text.replaceAll("[^a-zA-Z0-9\\s]","");

        String[] words = text.split(" ");
        
        for (String word: words) {
            set.add(word);
        }
        // Arrays.asList(words).stream().forEach(set::add);

        for (String word: set) {
            System.out.println(word);
        }
        // set.stream().forEach(System.out::println);
    }
}