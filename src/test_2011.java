import java.util.Scanner;

public class test_2011 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int[] dp = new int[str.length()];

        dp[0] = 1;

        if(str.charAt(0) == '0'){
            System.out.print(0);
            return;
        }

        for(int i = 1; i < str.length(); i++){

            if(str.charAt(i) != '0') {
                dp[i] += dp[i - 1] % 1000000;
                dp[i] %= 1000000;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.charAt(i-1));
            stringBuilder.append(str.charAt(i));

            if(str.charAt(i-1) != '0' && Integer.parseInt(stringBuilder.toString()) <= 26){
                if(i-2 >= 0){
                    dp[i] += dp[i-2] % 1000000;
                } else {
                    dp[i]++;
                }
                dp[i] %= 1000000;
            }
        }

        System.out.print(dp[str.length()-1]);
    }
}
