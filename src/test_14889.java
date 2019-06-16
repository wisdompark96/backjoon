import java.util.Scanner;

public class test_14889 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = scanner.nextInt();
            }
        }
        int[] bucket = new int[n/2];
        System.out.print(recur(bucket, map, n/2, n));
    }

    public static int recur(int[] bucket, int[][] map, int p, int n){
        int min = 99999;

        if(p == 0){
            int s = 0;
            int l = 0;

            boolean[] isIn = new boolean[n];

            for(int i = 0; i < bucket.length; i++){
                isIn[bucket[i]] = true;
                for(int j = 0; j < bucket.length; j++){
                    if(i != j) {
                        s += map[bucket[i]][bucket[j]];
                    }
                }
            }

            for(int i = 0; i < n; i++){
                if(!isIn[i]){
                    for(int j = 0; j < n; j++){
                        if(!isIn[j] && i != j){
                            l += map[i][j];
                        }
                    }
                }
            }


            return Math.abs(s-l);
        }

        int lastIndex = bucket.length - p -1;

        for(int i = 0; i < n; i++){
            if(p == bucket.length){
                bucket[0] = i;
                min = Math.min(min,recur(bucket, map, p-1, n));
            }
            else if(bucket[lastIndex] < i){
                bucket[lastIndex+1] = i;
                min = Math.min(min,recur(bucket, map, p-1, n));
            }
        }

        return min;
    }
}
