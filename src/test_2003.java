import java.util.Scanner;

public class test_2003 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = scanner.nextInt();
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            int sum = 0;
            sum += A[i];
            for(int j = i+1; j < n; j++){
                if(sum + A[j] > m)
                    break;
                sum += A[j];
            }

            if(sum == m)
                result++;
        }

        System.out.print(result);
    }
}
