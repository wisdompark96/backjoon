import java.util.Scanner;

public class test_1890 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] map = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        long[][] memo = new long[n][n];

        memo[0][0]=1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == n-1  && j == n-1)
                    break;
                if(i+map[i][j] < n){
                    memo[i+map[i][j]][j]+= memo[i][j];
                }
                if(j+map[i][j] < n){
                    memo[i][j+map[i][j]]+= memo[i][j];
                }
            }
        }

        System.out.print(memo[n-1][n-1]);
    }
}
