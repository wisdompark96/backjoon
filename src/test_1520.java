import java.util.Scanner;

public class test_1520 {

    public static long[][] memo;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        memo = new long[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                memo[i][j] = -1;
            }
        }

        System.out.print(recur(0,0,n,m,map));
    }

    public static long recur(int i, int j, int n, int m, int[][]map){
        long sum = 0;
        if(i == n-1 && j == m-1){
            return 1;
        }

        if(memo[i][j] != -1)
            return memo[i][j];
        if(i-1 >= 0 && map[i-1][j] < map[i][j]){
            sum += recur(i - 1, j, n, m, map);

        }
        if(i+1 < n && map[i+1][j] < map[i][j]){
            sum += recur(i + 1, j, n, m, map);

        }
        if(j-1 >= 0 && map[i][j-1] < map[i][j]){
            sum += recur(i, j - 1, n, m, map);
        }
        if(j+1 < m && map[i][j+1] < map[i][j]){
                sum += recur(i, j + 1, n, m, map);

        }

        memo[i][j] = sum;
        return sum;
    }
}
