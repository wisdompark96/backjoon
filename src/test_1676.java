import java.util.Scanner;

public class test_1676 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int sum = 0;

        sum += n/5;
        sum+= n/25;
        sum += n/125;

        System.out.print(sum);
    }
}
