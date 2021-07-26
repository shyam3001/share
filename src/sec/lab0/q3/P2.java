package sec.lab0.q3;

import java.util.Arrays;

class R implements Runnable {
    char[] array;
    char letter;
    static int total=0;

    R(char[] array, char letter) {
        this.array = array;
        this.letter = letter;
    }

    @Override
    public void run() {
        while(true) {
            int index = (int)(Math.random()*100);
            if (array[index] == '\u0000') {
                array[index] = letter;
                total++;
            }
            if (total >= 100) {
                break;
            }
        }
    }
}

public class P2 {
    static char[] array = new char[100];

    public static void main(String[] args) throws Exception {
        Runnable r1 = new R(array, 'A');
        Runnable r2 = new R(array, 'B');

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(Arrays.toString(array));
    }
}
