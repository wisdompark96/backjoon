import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class test_2293 {
    static ArrayList<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] dp = new int[10001];
        int[] coins = new int[n+1];

        for(int i = 1; i <= n; i++){
            String str = bufferedReader.readLine();
            coins[i] = Integer.parseInt(str);
        }

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        System.out.print(dp[k]);

    }
}
