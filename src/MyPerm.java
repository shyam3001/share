import java.util.Arrays;

public class MyPerm {
    static int[] inp = {1,2,3};
    static boolean[] b = new boolean[inp.length];
    static int[] ans = new int[inp.length];
    static int a = 0;

    static void rec(int pos) {
        b[pos] = true;          // make position unavailable as we recurse forward
        ans[a++] = inp[pos];    // append the current number to the answer

        // if we have the full length, then print the answer
        if (a == inp.length) {
            System.out.println(Arrays.toString(ans));
        }

        // recurse to the next available position
        for (int i=0; i<inp.length; i++) {
            if (!b[i]) rec(i);
        }

        a--;               // redact the answer length, as we backtrack
        b[pos] = false;    // make position available again
    }

    public static void main(String[] args) {
        for (int i=0; i<inp.length; i++)
            rec(i);
    }
}
