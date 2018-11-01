import java.util.Scanner;
import java.util.StringTokenizer;

public class test_2178 {
    public static void main(String[] args){
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        int sum = 0;
        int money = 20000;

        while (tokenizer.hasMoreTokens()) {
            int charge = 0;
            int distance = Integer.parseInt(tokenizer.nextToken());
            if(distance > 178 || distance < 4)
                break;

            if(money < 720)
                break;
            if(distance > 40 ){
                if(distance-40 % 8 == 0)
                    charge = ((distance - 40) / 8) * 80 ;
                else
                    charge = ((distance - 40) / 8) * 80 + 80;
                money -= 720+ charge;

            }
            else
                money -= 720;

            System.out.println(charge);
        }
        // @todo Write your code here.
        System.out.println(money);

    }
}
