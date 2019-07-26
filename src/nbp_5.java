import java.util.Arrays;
import java.util.Scanner;

public class nbp_5 {

    static int max = 0;
    public static void main(String[] args){

        int[]A = new int[100000];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 100000; i++){
            A[i] = scanner.nextInt();
        }

        System.out.println(solution(A));

    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Visit[] visits = new Visit[A.length];
        for(int i = 0; i < A.length; i++ ){
            visits[i] = new Visit(i, A[i]);
        }

        Arrays.sort(visits);

        int max = 0;

        for(int i = 0; i < visits.length-1; i++){
            max = Math.max(max, visits[i].v+visits[i+1].v+(Math.abs(visits[i].i-visits[i+1].i)));
            max = Math.max(max, visits[i].v+visits[i].v);
        }

        return max;
    }

    public static void recur(int[] bucket, int p, int[] A){

        if(p == 0){
            int sum = A[bucket[0]]+A[bucket[1]] + bucket[1]-bucket[0];
            max = Math.max(max, sum);
            return;
        }

        int lastIndex = bucket.length -p-1;

        for(int i = 0; i < A.length; i++){
            if(bucket.length == p){
                bucket[0] = i;
                recur(bucket, p-1, A);
            } else if(bucket[lastIndex] <= i){
                bucket[lastIndex+1] = i;
                if(A[bucket[0]]+A[bucket[1]] + bucket[1]-bucket[0] < max)
                    continue;
                recur(bucket, p-1, A);

            }
        }

    }

    public static class Visit implements Comparable<Visit>{
        int i;
        int v;

        public Visit(int i, int v){
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Visit o) {
            if(v < o.v){
                return 1;
            } else if(v > o.v){
                return -1;
            } else{
                return 0;
            }
        }
    }

}
