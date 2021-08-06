import java.util.Arrays;

public class MyPerm {
    static int[] inp = {1,2,3,4};
    static boolean[] b = new boolean[inp.length];
    static int[] ans = new int[inp.length];
    static int a = 0;

    static void rec(int pos) {
        b[pos] = true;
        ans[a++] = inp[pos];
        if (a == inp.length) {
            System.out.println(Arrays.toString(ans));
        }

        for (int i=0; i<inp.length; i++) {
            if (!b[i]) {
                rec(i);
            }
        }

        a--;
        b[pos] = false;
    }

    public static void main(String[] args) {
        for (int i=0; i<inp.length; i++)
            rec(i);
    }
}
