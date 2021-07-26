package sec.lab0.q3;

import java.util.Arrays;

class T1 extends Thread {
    @Override
    public void run() {
        while(true) {
            int index = (int)(Math.random()*100);
            if (P1.array[index] == '\u0000') {
                P1.array[index] = 'A';
                P1.total++;
            }
            if (P1.total >= 100) {
                break;
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        while(true) {
            int index = (int)(Math.random()*100);
            if (P1.array[index] == '\u0000') {
                P1.array[index] = 'B';
                P1.total++;
            }
            if (P1.total >= 100) {
                break;
            }
        }
    }
}

public class P1 {
    static char[] array = new char[100];
    static int total=0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new T1();
        Thread t2 = new T2();

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(Arrays.toString(array));
    }
}
