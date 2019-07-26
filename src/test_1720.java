import java.util.Scanner;

public class test_1720 {
    static int[]dp;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

       dp = new int[n+1];

       dp[0] = 1;
        dp[1] = 1;
        if(n >= 2)
            dp[2] = 3;

        for(int i = 3; i <= n; i++){
            if(i%2 != 0){
                dp[i] = dp[i-1]*2 - 1;
            } else{
                dp[i] = dp[i-1] *2 +1;
            }
        }

        if(n%2 == 0){
            dp[n] = (dp[n] +  dp[n/2] + 2*dp[(n-2)/2])/2;
        } else{
            dp[n] = (dp[n]+ dp[(n-1)/2])/2;
        }

        System.out.print(dp[n]);
    }


}
