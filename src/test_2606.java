import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_2606 {
    static int[][] matrix;
    static boolean [] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        matrix = new int[n][n];
        memo = new boolean[n];
        for(int i = 0; i < m; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            matrix[a-1][b-1] = 1;
            matrix[b-1][a-1] = 1;
        }

        System.out.print(DFS(0, n));

    }

    public static int DFS(int p, int n){
        int sum = 0;
        memo[p] = true;
        for(int i = 0; i < n; i++){
            if(matrix[p][i] ==1 && !memo[i] ){
                sum += 1+DFS(i, n);
            }
        }

        return sum;
    }
}
