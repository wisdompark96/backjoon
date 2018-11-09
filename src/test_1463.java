import java.util.Scanner;

public class test_1463 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[]memo = new long[n+1];
        memo[1] = 0;

        for(int i = 1; i <= n; i++){
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
        }
    }
}
