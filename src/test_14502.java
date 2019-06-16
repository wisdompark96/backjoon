import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test_14502 {
    static Queue<Integer[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        queue = new LinkedList<>();
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map =new int[n][m];

        for(int i = 0; i < n; i++){
            String[] str = bufferedReader.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] == 2){
                    Integer[] b = new Integer[2];
                    b[0] = i;
                    b[1] = j;
                }
            }
        }

        int[][] bucket = new int[3][2];

        System.out.print(recur(bucket, 3, n, m, map));
    }

    public static int recur(int[][]bucket, int p, int n, int m, int[][] map){

        int max = 0;
        if(p == 0){
            int[][] mm = new int[n][m];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    mm[i][j] = map[i][j];
                    if(map[i][j] == 2){
                        Integer[] b = new Integer[2];
                        b[0] = i;
                        b[1] = j;
                        queue.offer(b);
                    }
                }
            }

            for(int i = 0; i < 3; i++){
                mm[bucket[i][0]][bucket[i][1]] = 1;
            }
            return getArea(n, m, mm);
        }
        int lastIndex = 3-p-1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) {
                    if (p == 3) {
                        bucket[0][0] = i;
                        bucket[0][1] = j;
                        max = Math.max(max, recur(bucket, p-1, n, m, map));
                    } else if ((bucket[lastIndex][0] == i && bucket[lastIndex][1] < j) || bucket[lastIndex][0] > i) {
                        bucket[lastIndex + 1][0] = i;
                        bucket[lastIndex + 1][1] = j;
                        max = Math.max(max,recur(bucket, p-1, n, m, map));
                    }
                }
            }
        }
        return max;
    }

    public static int getArea(int n, int m, int[][] map){
        while(!queue.isEmpty()){
            Integer[] index = queue.poll();
            int i = index[0];
            int j = index[1];
            if(i-1 >= 0 && map[i-1][j] == 0 ){
                map[i-1][j] = 2;
                Integer[] b= new Integer[2];
                b[0] = i-1;
                b[1] = j;
                queue.offer(b);
            }
            if(i+1 < n && map[i+1][j] == 0){
                map[i+1][j] = 2;
                Integer[] b= new Integer[2];
                b[0] = i+1;
                b[1] = j;
                queue.offer(b);
            }
            if(j-1 >= 0 && map[i][j-1] == 0 ){
                map[i][j-1] = 2;
                Integer[] b= new Integer[2];
                b[0] = i;
                b[1] = j-1;
                queue.offer(b);
            }
            if(j+1 < m && map[i][j+1] == 0){
                map[i][j+1] = 2;
                Integer[] b= new Integer[2];
                b[0] = i;
                b[1] = j+1;
                queue.offer(b);
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0)
                    sum++;
            }
        }

        return sum;
    }

}
