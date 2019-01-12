import java.util.Scanner;

public class test_2579 {

    private static int[] memo;
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] stair = new int[n];

        for(int i = 0; i < n; i++)
            stair[i] = scan.nextInt();

        memo = new int[n];
    }


}
