import java.util.Arrays;

public class BotherMe {
    public static double random(double range) {
        double result = Math.random() * range;
        boolean sign = (Math.random() > 0.5);

        if (sign)
            return result;
        else
            return -result;
    }

    public static String convert(int T1, double T) {
        int h = (int)T;
        int m = (int)((T%1)*60);

        return String.format("%02d:%02d", (T1+h), m);
    }

    public static void main(String[] args) {
        int T1 = 10;    // 10.00 AM
        int T2 = 20;    // 8.00 PM
        int S = 10;     // sampled 10 times between T1 and T2
        double delta = 0.1;  // randomly select between 0.1 of the threshold

        int AD = T2 - T1;   // active duration
        int AW = AD / S;    // active window

        double[] NST = new double[S];

        NST[0] = 0;
        for (int i = 1; i < S; i++) {
            NST[i] = NST[0] + (AW * i) + random(AW * delta);
        }

        for (double timestamp: NST) {
            System.out.println(convert(T1, timestamp));
        }
    }
}
