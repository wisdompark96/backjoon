import java.util.Scanner;

public class test_1463 {
    static long[] memo;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memo = new long[n+1];
        memo[1] = 0;
        memo[2] = 1;
        memo[3] = 1;
        /*for(int i = 1; i <= n; i++){
            if(memo[i] == 0 && i != 1){
                long c1 = 0;
                long c2 = 0;
                if(i%2 == 0)
                    c1 = 1+memo[i/2];
                if(i%3 == 0)
                    c2 = 1+memo[i/3];

                if(c1 == 0 && c2 == 0)
                    memo[i] = 1+memo[i-1];
                else if(c1 == 0 && c2 != 0)
                    memo[i] = Math.min(1+memo[i-1],c2);
                else if(c1 != 0 && c2 == 0)
                    memo[i] = Math.min(1+memo[i-1],c1);
                else
                    memo[i] = Math.min(1+memo[i-1],Math.min(c1,c2));

            }
            if(i == n)
                System.out.print(memo[i]);
        }*/
        System.out.print(dp(n));
    }

    public static long dp(int n){

        long min = 999999;
        if(memo[n-1] == 0){
            memo[n-1] = dp(n-1);
        }
        min = Math.min(min, memo[n-1]);

        if(n%2 == 0){
            if(memo[n/2] == 0)
                memo[n/2] = dp(n/2);
            min = Math.min(min, memo[n/2]);
        }
        if(n%3 == 0){
            if(memo[n/3] == 0)
                memo[n/3] = dp(n/3);
            min = Math.min(min, memo[n/3]);
        }

        memo[n] = min+1;
        return memo[n];
    }
}
