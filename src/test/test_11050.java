package test;

import java.util.Scanner;
public class test_11050 {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        long a = scan.nextInt();
        long b = scan.nextInt();
        long c = scan.nextInt();

        long aa = (a+b)%c;
        long ab = ((a%c)+(b%c))%c;
        long ac = (a*b)%c;
        long ad = ((a%b)*(b%c))%c;
        System.out.println(aa);
        System.out.println(ab);
        System.out.println(ac);
        System.out.println(ad);
    }
}
