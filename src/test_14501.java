import java.util.Scanner;

public class test_14501 {
    static int[] T;
    static int[] P;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        T= new int[n];
        P = new int[n];

        for(int i = 0; i < n; i++){
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        int[] bucket = new int[n];

        System.out.print(recur(bucket, n, n));
    }

    public static int recur(int[] bucket, int p, int n){
        int max = 0;

        int lastIndex = bucket.length - p - 1;

        if(p != bucket.length && (bucket[lastIndex]  + T[bucket[lastIndex]] )  >= n-1){
            int sum = 0;
//            T[bucket[lastIndex] + T[bucket[lastIndex]] - 1]

            for(int i = 0; i <= lastIndex; i++){
                sum += P[bucket[i]];
            }

            if(bucket[lastIndex] + T[bucket[lastIndex]] == n-1 && T[bucket[lastIndex] + T[bucket[lastIndex]]] == 1) {
                sum += P[n - 1];
            }
            return sum;
        }


        /*if(p == 0){
            int sum = 0;
            for(int i = 0; i < bucket.length; i++){
                sum += P[bucket[i]];
            }
            return sum;
        }*/

        for(int i = 0; i < n; i++){
            if(p == bucket.length){
                if(i + T[i] - 1 > n-1)
                    continue;
                else{
                    bucket[0] = i;
                    max = Math.max(max, recur(bucket, p-1, n));
                }
            } else if(bucket[lastIndex] + T[bucket[lastIndex]]-1 < i){
                if(i + T[i] - 1> n-1)
                    continue;
                bucket[lastIndex+1] = i;
                max = Math.max(max, recur(bucket, p-1, n));
            }
        }
        int sum = 0;
        for(int i = 0; i <= lastIndex; i++){
            sum += P[bucket[i]];
        }
        max = Math.max(sum, max);
        return max;
    }

}
