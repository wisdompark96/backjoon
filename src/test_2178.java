import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

public class test_2178 {
    static LinkedBlockingQueue<Integer[]> queue;
    static int[][] memo;
    static int[][] map;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[n][m];
        memo = new int[n][m];
        queue = new LinkedBlockingQueue<>(1000000);
        for(int i = 0; i < n; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            String s = str.nextToken();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        map[0][0] = 0;
        System.out.print(BFS(0,0,1));

    }

    public static int BFS(int i, int j,  int p) throws InterruptedException {
        int sum = 0;

        Integer[] b;
        if(i == n-1 && j == m-1) {
            return p;
        }

        if(i-1 >= 0  && map[i-1][j] == 1) {
           map[i-1][j] = 0;
           b = new Integer[3];
           b[0] = i-1;
           b[1] = j;
           b[2] = p+1;
            queue.offer(b);
        }

        if(i+1 < n && map[i+1][j] == 1){
            map[i+1][j] = 0;
            b = new Integer[3];
            b[0] = i+1;
            b[1] = j;
            b[2] = p+1;
            queue.offer(b);
        }

        if(j-1 >= 0 && map[i][j-1] == 1) {
            map[i][j-1] = 0;
            b = new Integer[3];
            b[0] = i;
            b[1] = j-1;
            b[2] = p+1;
            queue.offer(b);
        }

        if(j+1 < m && map[i][j+1] == 1){
            map[i][j+1] = 0;
            b = new Integer[3];
            b[0] = i;
            b[1] = j+1;
            b[2] = p+1;
            queue.offer(b);
        }

        if(!queue.isEmpty()){
            Integer[] bucket = queue.take();
            sum += BFS(bucket[0],bucket[1],bucket[2]);
        }

        return sum;
    }
}
