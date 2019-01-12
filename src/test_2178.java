import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test_2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n][m];
        int[][] memo = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                StringTokenizer str = new StringTokenizer(br.readLine());
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int min = 9999;
                if(i == 0 && j == 0)
                    memo[i][j] = 1;
                if(i-1 >= 0){
                    min = Math.min(min, memo[])
                }
            }
        }
    }
}
