import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(String.format("%.0f", DP(n,m)));

        sc.close();
    }
    public static double DP(int n, int m) {
        int b = Math.min(n-m, m);

        double k = (double) n;
        double val = 1;
        for(int i=b; i>0; i--) {
            val *= k--/i;
        }
        return val;
    }
}
