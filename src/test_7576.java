import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
Queue<String>을 써서 메모리 초과가 났다..
String은 메모리를 의외로 많이 잡아먹는다.
BufferedReader, BufferedWriter를 쓰면 시간을 줄일 수 있다.
 */
public class test_7576 {
    static LinkedBlockingQueue<Integer[]> queue;
    static int nvisit;
    static int [][] tomato;
    static int m;
    static int n;
    public static void main(String args[]) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        tomato = new int[n][m];
//        visit = new ArrayList<>();
        nvisit = 0;
        queue = new LinkedBlockingQueue<>(1000000);
        for(int i = 0; i < n; i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                tomato[i][j] = Integer.parseInt(str.nextToken());
                  if (tomato[i][j] == 1) {
                      Integer[] bucket = new Integer[3];
                      bucket[0] = i;
                      bucket[1] = j;
                      bucket[2] = 0;
                      queue.offer(bucket);
                      nvisit++;
                  }
                  else if(tomato[i][j] == -1)
                        nvisit++;
            }
        }

        int result = 0;
        if (!queue.isEmpty()) {
            Integer [] b = queue.take();
//            String q = queue.take();
//            String[] strs = q.split(",");
            result = BFS(b[0], b[1], b[2]);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(nvisit == n*m) {
            bw.write(String.valueOf(result));
        }
        else
            bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();
        br.close();

    }

    public static int BFS(int i, int j,  int d) throws InterruptedException {

        int sum = 0;
        Integer[] bucket ;
//        System.out.println("visit"+i+","+j);
        if(i-1 >= 0 && i-1 <= n-1) {
            if (tomato[i - 1][j] == 0) {
                tomato[i - 1][j] = 1;
                bucket = new Integer[3];
                bucket[0] = i-1;
                bucket[1] = j;
                bucket[2] = d+1;
                queue.offer(bucket);
//                System.out.println("input"+(i-1)+","+j);
                nvisit++;
            }
        }
        if(j-1 >= 0 && j-1 <= m-1) {
            if (tomato[i][j - 1] == 0) {
                tomato[i][j - 1] = 1;
                nvisit++;
                bucket = new Integer[3];
                bucket[0] = i;
                bucket[1] = j-1;
                bucket[2] = d+1;
//                System.out.println("input"+(i)+","+(j-1));
                queue.offer(bucket);
            }
        }

        if(i+1 >= 0 && i+1<= n-1) {
            if (tomato[i + 1][j] == 0) {
                tomato[i + 1][j] = 1;
                nvisit++;
                bucket = new Integer[3];
                bucket[0] = i+1;
                bucket[1] = j;
                bucket[2] = d+1;
//                System.out.println("input"+(i+1)+","+j);
                queue.offer(bucket);

            }
        }

        if(j+1 >= 0 && j+1 <= m-1) {
            if (tomato[i][j + 1] == 0) {
                tomato[i][j + 1] = 1;
                nvisit++;
                bucket = new Integer[3];
                bucket[0] = i;
                bucket[1] = j+1;
                bucket[2] = d+1;
//                System.out.println("input"+(i)+","+(j+1));
                queue.offer(bucket);
            }
        }

        if(!queue.isEmpty()){
            Integer[] b = queue.take();
//            String[] strs = q.split(",");
            sum  += BFS(b[0],b[1],b[2]);
        }
        else
            sum += d;

        return sum;
    }


}
