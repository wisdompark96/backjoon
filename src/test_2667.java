import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class test_2667 {
    static char[][] matrix;
    static Queue<Integer[]> queue;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        matrix = new char[n][n];
        queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                matrix[i][j] = str.charAt(j);

            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1'){
                    matrix[i][j] = '0';
                    Integer[] b = new Integer[2];
                    b[0] = i;
                    b[1] = j;
                    queue.offer(b);
                    arrayList.add(BFS(n));
                }
            }
        }

        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println(arrayList.get(i));
        }
    }

    public static int BFS(int n){

        int cnt = 1;
        while(!queue.isEmpty()){
            Integer[] index = queue.poll();
            int i = index[0];
            int j = index[1];

            if(i-1 >= 0 && matrix[i-1][j] == '1'){
                cnt++;
                Integer[] b = new Integer[2];
                b[0] = i-1;
                b[1] = j;
                matrix[i-1][j] = '0';
                queue.offer(b);
            }
            if(i + 1 < n && matrix[i+1][j] == '1'){
                cnt++;
                Integer[] b = new Integer[2];
                b[0] = i+1;
                b[1] = j;
                matrix[i+1][j] = '0';
                queue.offer(b);
            }

            if(j-1 >= 0 && matrix[i][j-1] == '1'){
                cnt++;
                Integer[] b = new Integer[2];
                b[0] = i;
                b[1] = j-1;
                matrix[i][j-1] = '0';
                queue.offer(b);
            }
            if(j + 1 < n && matrix[i][j+1] == '1'){
                cnt++;
                Integer[] b = new Integer[2];
                b[0] = i;
                b[1] = j+1;
                matrix[i][j+1] = '0';
                queue.offer(b);
            }
        }

        return cnt;
    }


}
