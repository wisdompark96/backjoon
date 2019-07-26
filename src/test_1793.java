import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class test_1793 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for(int i = 3; i <= 250; i++){
            if(i % 2 != 0){
                dp[i] = dp[i-1].multiply(new BigInteger("2")).subtract(new BigInteger("1"));
            } else{
                dp[i] = dp[i-1].multiply(new BigInteger("2")).add(new BigInteger("1"));
            }
        }

        try {
            String str = br.readLine();
            while(str != null){
                int n = Integer.parseInt(str);

                System.out.println(dp[n]);

                str = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
