import java.util.*;

public class test_11399 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int []p = new int[n];
        for(int i = 0; i < n; i++){
            p[i] = scanner.nextInt();
        }

        Arrays.sort(p);
        long sum = 0;

        long result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <i+1; j++ ){
                sum += p[j];
            }
            result += sum;
            sum = 0;
        }



        System.out.print(result);
    }
}
