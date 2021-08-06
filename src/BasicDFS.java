import java.io.File;
import java.util.Scanner;

public class BasicDFS {
    static boolean[] visit;
    static int[][] arr;
    static int[] path;
    static int p, N, E;

    static void rec(int cur, int end) {
        if (cur == end) {
            for (int i=0; i<p; i++) {
                System.out.print(path[i] + ", ");
            }
            System.out.println(end);
            return;
        }

        visit[cur] = true;
        path[p++] = cur;

        for (int i=1; i<=N; i++)
            if (arr[cur][i] > 0 && !visit[i])
                rec(i, end);

        p--;
        visit[cur] = false;
    }

    public static void main(String[] args) throws Exception {
        try(Scanner in = new Scanner(new File("graph.in"))) {
            N = in.nextInt();
            E = in.nextInt();
            arr = new int[N+1][N+1];
            visit = new boolean[N+1];
            path = new int[N*N];

            for (int i=0; i<E; i++) {
                int st = in.nextInt();
                int et = in.nextInt();
                int w = in.nextInt();
                arr[st][et] = w;
            }
            for (int i=1; i<=N; i++) {
                for (int j = 1; j <= N; j++)
                    System.out.print(arr[i][j] + " ");
                System.out.println();
            }
            System.out.println();

            rec(1,6);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
