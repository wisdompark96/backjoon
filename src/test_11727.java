import java.util.Scanner;

public class test_11727 {
    public static long[] memo;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        memo = new long[n+1];
        if(memo.length > 2) {
            memo[1] = 1;
            memo[2] = 3;
        }

        System.out.print(function(n));
    }

    public static long function(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 3;
        /*if(memo[n-1] == 0)
            memo[n-1] = function(n-1);
        if(memo[n-2] == 0)
            memo[n-2]= function(n-2);
            */
        if(n%2 == 0){
            if(memo[n-1] == 0)
                memo[n-1] = function(n-1);
            memo[n] = memo[n-1]*2 +1;
        }

        if(n%2 != 0){
            if(memo[n-1] == 0)
                memo[n-1] = function(n-1);
            memo[n] = memo[n-1]*2 -1;
        }

        return (memo[n])%10007;
    }
}
