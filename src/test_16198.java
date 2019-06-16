import java.util.Scanner;

public class test_16198 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] energy = new int[n];
        for(int i = 0; i < n; i++){
            energy[i] = scanner.nextInt();
        }

        System.out.print(dp(energy, 0, n));
    }

    public static long dp(int[] energy, int p, int n){
        long max = 0;
        if(n == 2){
            return 0;
        }

        for(int i = 1; i < n-1; i++){
            int[] list = new int[n-1];
            int k = 0;
            for(int j = 0; j < n; j++){
                if(j == i)
                    continue;
                list[k++] = energy[j];
            }
            max = Math.max(max,dp(list, i, n-1)+(energy[i-1]*energy[i+1]));
        }
        return max;
    }
}
