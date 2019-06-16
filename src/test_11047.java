import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11047 {
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        long k = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int result = 0;
        int s = coins.length-1;
        while(k != 0){
            for(int i = s; i >= 0; i--){
                if(coins[i] > k){
                    if(i-1 < 0){
                        result += k / coins[0];
                        k = k % coins[0];
                        s = 0;
                    } else {
                        result += k / coins[i - 1];
                        k = k % coins[i - 1];
                        s = i - 1;
                    }
                    break;
                } else if(coins[i] == k) {
                    result += 1;
                    k = 0;
                    break;
                }
                else{
                    result += k/coins[i];
                    k = k%coins[i];
                }
            }
        }
        System.out.print(result);
    }

}
