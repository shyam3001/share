package sec.lab0.q3;

import java.util.Arrays;

// this is using the same R and RX classes from P2.class

public class P5 {
    static char[] array = new char[100];
    static Thread[] tt = new Thread[26];

    public static void main(String[] args) throws Exception {

        for (char c='A'; c<='Z'; c++) {
            Runnable r = new RX(array, c);
            Thread t = new Thread(r);
            t.start();
            tt[c-65] = t;
        }

        for (Thread t: tt) {
            t.join();
        }

        System.out.println(Arrays.toString(array));
    }
}