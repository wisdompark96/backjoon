import java.util.Scanner;

public class test_11058 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        long[] memo = new long[100+1];
        int n = scanner.nextInt();

       for(int i = 1; i < 6; i++){
           memo[i] = i;
       }

       for(int i = 6; i <= n; i++){
           memo[i] = i;
           memo[i] = Math.max(memo[i-4]*3,memo[i]);
           memo[i] = Math.max(memo[i-5]*4, memo[i]);
       }

       System.out.print(memo[n]);
    }
}
