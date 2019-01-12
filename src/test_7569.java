import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingQueue;

public class test_7569 {
    static LinkedBlockingQueue<Integer[]> queue;
    static int nvisit;
    static Integer [][][] tomato;
    static int m;
    static int n;
    static int h;
    public static void main(String args[]) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());
        tomato = new Integer[h][n][m];
//        visit = new ArrayList<>();
        nvisit = 0;
        queue = new LinkedBlockingQueue<>(1000000);
        for(int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                StringTokenizer str = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    tomato[k][i][j] = Integer.parseInt(str.nextToken());
                    if (tomato[k][i][j] == 1) {
                        Integer[] bucket = new Integer[4];
                        bucket[0] = k;
                        bucket[1] = i;
                        bucket[2] = j;
                        bucket[3] = 0;
                        queue.offer(bucket);
                        nvisit++;
                    } else if (tomato[k][i][j] == -1)
                        nvisit++;
                }
            }
        }


        int result = 0;
        if (!queue.isEmpty()) {
            Integer [] b = queue.take();
//            String q = queue.take();
//            String[] strs = q.split(",");
            result = BFS(b[0], b[1], b[2], b[3]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(nvisit == n*m*h) {
            bw.write(String.valueOf(result));
        }
        else
            bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();
        br.close();

    }

    public static int BFS(int k, int i, int j,  int d) throws InterruptedException {

        int sum = 0;
        Integer[] bucket ;
//        System.out.println("visit"+i+","+j);
        if(i-1 >= 0 && i-1 <= n-1) {
            if (tomato[k][i - 1][j] == 0) {
                tomato[k][i - 1][j] = 1;
                bucket = new Integer[4];
                bucket[0] = k;
                bucket[1] = i-1;
                bucket[2] = j;
                bucket[3] = d+1;
                queue.offer(bucket);
//                System.out.println("input"+(i-1)+","+j);
                nvisit++;
            }
        }
        if(j-1 >= 0 && j-1 <= m-1) {
            if (tomato[k][i][j - 1] == 0) {
                tomato[k][i][j - 1] = 1;
                nvisit++;
                bucket = new Integer[4];
                bucket[0] = k;
                bucket[1] = i;
                bucket[2] = j-1;
                bucket[3] = d+1;
//                System.out.println("input"+(i)+","+(j-1));
                queue.offer(bucket);
            }
        }

        if(i+1 >= 0 && i+1<= n-1) {
            if (tomato[k][i + 1][j] == 0) {
                tomato[k][i + 1][j] = 1;
                nvisit++;
                bucket = new Integer[4];
                bucket[0] = k;
                bucket[1] = i+1;
                bucket[2] = j;
                bucket[3] = d+1;
//                System.out.println("input"+(i+1)+","+j);
                queue.offer(bucket);

            }
        }

        if(j+1 >= 0 && j+1 <= m-1) {
            if (tomato[k][i][j + 1] == 0) {
                tomato[k][i][j + 1] = 1;
                nvisit++;
                bucket = new Integer[4];
                bucket[0] = k;
                bucket[1] = i;
                bucket[2] = j+1;
                bucket[3] = d+1;
//                System.out.println("input"+(i)+","+(j+1));
                queue.offer(bucket);
            }
        }

        if(k+1 >= 0 && k+1 <= h-1) {
            if (tomato[k+1][i][j] == 0) {
                tomato[k+1][i][j] = 1;
                nvisit++;
                bucket = new Integer[4];
                bucket[0] = k+1;
                bucket[1] = i;
                bucket[2] = j;
                bucket[3] = d+1;
//                System.out.println("input"+(i)+","+(j+1));
                queue.offer(bucket);
            }
        }
        if(k-1 >= 0 && k-1 <= h-1) {
            if (tomato[k-1][i][j] == 0) {
                tomato[k-1][i][j] = 1;
                nvisit++;
                bucket = new Integer[4];
                bucket[0] = k-1;
                bucket[1] = i;
                bucket[2] = j;
                bucket[3] = d+1;
//                System.out.println("input"+(i)+","+(j+1));
                queue.offer(bucket);
            }
        }
        if(!queue.isEmpty()){
            Integer[] b = queue.take();
//            String[] strs = q.split(",");
            sum  += BFS(b[0],b[1],b[2],b[3]);
        }
        else
            sum += d;

        return sum;
    }

}
