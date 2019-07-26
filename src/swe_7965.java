import java.util.Scanner;

public class swe_7965 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            long sum = 0;

            for(int i = 1; i <= n; i++){
                long r = 1;
                for(int j = 0; j < i; j++){
                    r *= i%1000000007;
                    r %= 1000000007;
                }
                sum += r;
                sum %= 1000000007;
            }

            System.out.println("#"+test_case+" "+sum);
        }
    }
}
