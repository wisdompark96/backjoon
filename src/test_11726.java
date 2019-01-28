import java.util.Scanner;

public class test_11726 {
    public static int[] memo;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        memo = new int[n+1];
        if(memo.length > 2) {
            memo[1] = 1;
            memo[2] = 2;
        }
        System.out.print(dp(n));
    }
    public static int dp(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(memo[n-1] == 0)
            memo[n-1] = dp(n-1);
        if(memo[n-2] == 0)
            memo[n-2] = dp(n-2);
        return (memo[n-1]+memo[n-2])%10007;
    }
}
