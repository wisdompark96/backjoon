import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_16236 {
    static  int[][] map;
    static int n;
    static int time;
    static Shark ps;
    static Queue<Shark> queue;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        queue = new LinkedList<>();

        n = scanner.nextInt();
        map = new int[n][n];
        int[][] visited = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = scanner.nextInt();
                if(map[i][j] == 9) {
                   queue.offer(new Shark(i,j,0,2, 0));
                   map[i][j] = 0;
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty()){
            Queue<Shark> q = new LinkedList<>();
            time = queue.peek().time;
            System.out.println(time);
            System.out.println(queue.peek().w+","+queue.peek().cnt+","+queue.peek().x+","+queue.peek().y);
            q.offer(queue.poll());
            findFeed(q);

        }

        System.out.print(time);
    }

    public static void findFeed(Queue<Shark> q){
        int[][] visited = new int[n][n];

        while(!q.isEmpty()){
            Shark shark = q.poll();
            int x = shark.x;
            int y = shark.y;
            int w = shark.w;
            if(x-1 >= 0 && map[x-1][y] <= shark.w && visited[x-1][y] == 0){
                visited[x-1][y] = 1;
                if(map[x-1][y] != 0 && shark.w > map[x-1][y]){
                    map[x-1][y] = 0;
                    if(w == shark.cnt+1)
                        queue.offer(new Shark(x-1,y,shark.time+1,shark.w+1, 0));
                    else
                        queue.offer(new Shark(x-1,y,shark.time+1,shark.w, shark.cnt+1));

                    return;
                } else {
                    q.offer(new Shark(x-1,y,shark.time+1,shark.w, shark.cnt));
                }
            }

            if(y-1 >= 0 && map[x][y-1] <= shark.w && visited[x][y-1] == 0){
                visited[x][y-1] = 1;
                if(map[x][y-1] != 0 && shark.w > map[x][y-1]){
                    map[x][y-1] = 0;
                    if(w == shark.cnt+1)
                        queue.offer(new Shark(x,y-1,shark.time+1,shark.w+1, 0));
                    else
                        queue.offer(new Shark(x,y-1,shark.time+1,shark.w, shark.cnt+1));
                    return;
                } else {
                    q.offer(new Shark(x,y-1,shark.time+1,shark.w, shark.cnt));
                }
            }

            if(x+1 < n && map[x+1][y] <= shark.w && visited[x+1][y] == 0){
                visited[x+1][y] = 1;
                if(map[x+1][y] != 0 && shark.w > map[x+1][y]){
                    map[x+1][y] = 0;
                    if(w == shark.cnt+1)
                        queue.offer(new Shark(x+1, y, shark.time+1, shark.w+1, 0));
                    else
                        queue.offer(new Shark(x+1, y, shark.time+1, shark.w, shark.cnt+1));

                    return;
                } else {
                    q.offer(new Shark(x+1, y, shark.time+1, shark.w, shark.cnt));
                }
            }

            if(y+1 < n && map[x][y+1] <= shark.w && visited[x][y+1] == 0){
                visited[x][y+1] = 1;
                if(map[x][y+1] != 0 && shark.w > map[x][y+1]){
                    map[x][y+1] = 0;
                    if(w == shark.cnt+1)
                        queue.offer(new Shark(x, y+1, shark.time+1, shark.w+1, 0));
                    else
                        queue.offer(new Shark(x, y+1, shark.time+1, shark.w, shark.cnt+1));

                    return;
                } else {
                    q.offer(new Shark(x, y+1, shark.time+1, shark.w, shark.cnt));
                }
            }
        }
    }

    public static class Shark{
        int x,y,time,w,cnt;
        public Shark(int x, int y, int time, int w, int cnt){
            this.x = x;
            this.y = y;
            this.time = time;
            this.w = w;
            this.cnt = cnt;
        }
    }
}
