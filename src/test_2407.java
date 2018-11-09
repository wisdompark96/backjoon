import java.math.BigInteger;
import java.util.Scanner;

public class test_2407 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        BigInteger[][] memo = new BigInteger[n+1][n+1];
        memo[0][0] = BigInteger.ONE;
        memo[1][0] = BigInteger.ONE;
        memo[1][1] = BigInteger.ONE;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i)
                    memo[i][j] = BigInteger.ONE;
                else
                    memo[i][j] = memo[i-1][j-1].add(memo[i-1][j]);
                if(i == n && j == m)
                    break;
            }
        }

        System.out.print(memo[n][m]);

    }

}
