public class Sample {
    public static void main(String[] args) {
        // StringBuilder builder = new StringBuilder("a");
        // builder.append("b");
        // builder.append("c");
        // builder.reverse();
        // String s = builder.toString();

        String s = new StringBuilder("a").append("b").append("c").reverse().toString();
        System.out.println(s);
    }
}
