import java.util.Scanner;

public class test_2169 {
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

        long[][] memo = new long[n][m];
        long[][] memoR = new long[n][m];
        memo[0][0] = map[0][0];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j != 0){
                    memo[i][j] = memo[i][j-1] + map[i][j];
                } else if(i != 0 && j == 0){
                    memo[i][j] =  memo[i-1][j]+map[i][j];
                } else if(i != 0 && j != 0){
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1])+map[i][j];
                }
            }

            if(i != 0 && i != n-1){
                for(int j = m-1; j >= 0; j--){
                    if(j == m-1){
                        memoR[i][j] = memo[i-1][j]+map[i][j];
                    } else{
                        memoR[i][j] = Math.max(memoR[i][j+1]+map[i][j], memo[i-1][j]+map[i][j]);
                        memo[i][j] = Math.max(memoR[i][j], memo[i][j]);
                    }
                }
            }
        }

        System.out.print(memo[n-1][m-1]);
    }
}
