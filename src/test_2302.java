import java.util.Scanner;

public class test_2302 {
    public static long[] memo;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] row = new int[m];
        memo = new long[n+1];

        if(n > 2){
            memo[1] = 1;
            memo[2] = 2;
        }

        for(int i = 0; i < m; i++)
            row[i] = scanner.nextInt();

        long mul = 1;
        if(m != 0) {
            for (int i = 0; i <= m; i++) {
                if (i == 0) {
                    mul *= dp(row[i] - 1);
                } else if (i == m) {
                    mul *= dp(n + 1 - row[i - 1] - 1);
                } else {
                    mul *= dp(row[i] - row[i - 1] - 1);
                }
            }
        }
        else
            mul *= dp(n);

        System.out.print(mul);
    }

    public static long dp(int n){
        if(n == 1 || n== 0)
            return 1;
        if(n == 2)
            return 2;

        if(memo[n-1] == 0)
            memo[n-1] = dp(n-1);
        if(memo[n-2] == 0)
            memo[n-2] = dp(n-2);

        return memo[n-1]+memo[n-2];
    }
}
