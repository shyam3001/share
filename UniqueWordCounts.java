import java.util.*;

public class UniqueWordCounts {
    public static void main(String args[]) {
        Map<String, Integer> map = new TreeMap<>();

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        text = text.replaceAll("[^a-zA-Z0-9\\s]","");

        String[] words = text.split(" ");
        
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }

        // for (String word: map.keySet()) {
        //     System.out.println(word + "=" + map.get(word)); 
        // }
        
        // map.entrySet().stream().forEach(System.out::println);

        // map.entrySet().stream()
        //     .sorted(Map.Entry.comparingByValue())
        //     .forEach(System.out::println);

        map.entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .forEach(System.out::println);
    }
}