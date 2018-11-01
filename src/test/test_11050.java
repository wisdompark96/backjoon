package test;

import java.util.Scanner;

public class test_11050 {

    static long[][] b ;
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int n= scan.nextInt();
        int k = scan.nextInt();

        long bucket[] = new long[k];

        b = new long[n+1][k+1];
        System.out.print(((recur(n, k, bucket))));

    }

    public static long recur(int n, int p, long[] k){


        if(p == 0){
//            for(int i = 0; i < k.length; i++)
//            System.out.print(k[i]);
//            System.out.println();
            return 1;
        }
        long num = 0;
        int lastIndex = k.length-p-1;

        for(int i = 1; i <= n; i++){
            if(p == k.length){
                k[0] = i;
                num += recur(n,p-1, k);
            }
            else if(k[lastIndex] < i){
                if(n-i < p-1)
                    break;
                k[lastIndex+1] = i;
                if(b[i][lastIndex+1] == 0)
                    b[i][lastIndex+1] = recur(n,p-1, k);
                num += b[i][lastIndex+1];
            }
        }

        return num;


    }


}
