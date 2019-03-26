import java.util.Scanner;

public class test_1328 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        int[][][]dp = new int[n+1][100+1][100+1];

        dp[1][1][1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= l; j++){
                for(int k = 1; k <= r; k++){
                    dp[i][j][k] = (dp[i-1][j-1][k]%1000000007)+(dp[i-1][j][k-1]%1000000007)+(dp[i-1][j][k]*(i-2)%1000000007);

                }
            }

        }
        System.out.print(dp[n][l][r]%1000000007);
    }
}
