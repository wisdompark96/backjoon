import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class test_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        long[] dp = new long[k+1];
        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            String str = bufferedReader.readLine();
            coins[i] = Integer.parseInt(str);
            if(coins[i] <= k)
                dp[coins[i]] = 1;
        }

        Arrays.sort(coins);

        for(int i = 1; i <= k; i++ ){
            if(dp[i] == 1)
                continue;
            for(int j = 1; j <= i; j++){
                if(dp[i] == 0) {
                    if(dp[j] != 0 && dp[i-j] != 0)
                        dp[i] = dp[j] + dp[i - j];
                }
                else {
                    if(dp[j] != 0 && dp[i-j] != 0)
                        dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }
        if(dp[k] == 0)
            dp[k] = -1;
        System.out.print(dp[k]);

    }
}
