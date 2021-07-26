package sec.lab0.q3;

import java.util.Arrays;

class RX implements Runnable {
    char[] array;
    char letter;
    static int total=0;

    RX(char[] array, char letter) {
        this.array = array;
        this.letter = letter;
    }

    @Override
    public void run() {
        int index = 0;
        while(true) {
            if (array[index] == '\u0000') {
                array[index] = letter;
                total++;
                System.out.println("Wrote "+ letter +" into index " + index);
            }
            if (total >= 100) {
                break;
            }
            try {
                // use these different values
                // Thread.sleep(100);
                Thread.sleep(500);
                // Thread.sleep(100);
                // Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            index++;
        }
    }
}

public class P3 {
    static char[] array = new char[100];

    public static void main(String[] args) throws Exception {
        Runnable r1 = new RX(array, 'A');
        Runnable r2 = new RX(array, 'B');

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(Arrays.toString(array));
    }
}
