import java.util.Scanner;

public class test_9095 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] n = new int[T];
        int[] memo = new int[11];

        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 4;
        for(int i = 0; i < T; i++){
            n[i] = scanner.nextInt();
        }

        for(int i = 0; i < T; i++){
            for(int j = 0; j < 11; j++){
                if(memo[j] == 0){
                    memo[j] = memo[j-3]+memo[j-2]+memo[j-1];
                }
                if(j+1 == n[i]){
                    System.out.print(memo[j]);
                    if(i != T-1)
                        System.out.println();
                    break;
                }
            }
        }

    }
}
