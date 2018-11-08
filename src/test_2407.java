import java.util.Scanner;

public class test_2407 {
    public static int[][] memo;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] bucket = new int[m];
        memo = new int[m][n];

        System.out.print(combine(bucket, n, m, m));

    }

    public static long combine(int[] bucket, int n, int m, int p){

        long sum = 0;
        if(p == 0){
            return 1;
        }

        int lastIndex = m-p-1;

        for(int i = 0; i < n; i++){
            if(p == m){
                if(i > n-m)
                    break;
                bucket[0] = i;
                sum +=  combine(bucket, n, m, p - 1);
            }

            else if(bucket[lastIndex] < i){
                bucket[lastIndex+1] = i;
                if(memo[lastIndex+1][i] == 0) {
                    memo[lastIndex + 1][i] += combine(bucket, n, m, p - 1);
                    sum += memo[lastIndex + 1][i];
                }

                else
                    sum += memo[lastIndex+1][i];

            }
        }

        return sum;
    }
}
