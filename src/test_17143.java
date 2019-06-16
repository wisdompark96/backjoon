import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test_17143 {
    static int r;
    static int c;
    static int m;
    static Shark[][] map;
    static Queue<Shark> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input[] = bufferedReader.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);

        map = new Shark[r][c];
        queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            String str[] = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(str[0])-1;
            int y = Integer.parseInt(str[1])-1;
            int s = Integer.parseInt(str[2]);
            int d = Integer.parseInt(str[3]);
            int z = Integer.parseInt(str[4]);

            Shark shark = new Shark(x,y,s,d,z,0);
            queue.offer(shark);
            map[x][y] = shark;
        }

        int sum = 0;
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++){
                if(map[j][i] != null){
                    sum += map[j][i].z;
                    map[j][i] = null;
                    break;
                }
            }
            moveShark(i);
        }

        System.out.print(sum);
    }

    public static void moveShark(int t){

        while(!queue.isEmpty() && queue.peek().t == t){
            Shark shark = queue.poll();

            int sr = shark.r;
            int sc = shark.c;

            if(map[shark.r][shark.c] == null)
                continue;
            map[shark.r][shark.c] = null;

            int index ;
            int dir;
            switch (shark.d){
                case 1:
                case 2:
                    index = sr;
                    dir = shark.d;
                    for (int i = 0; i < shark.s; i++) {
                        if (dir == 1 && index == 0){
                            dir = 2;
                        }
                        if(dir == 2 && index == r-1){
                            dir = 1;
                        }
                        if(dir == 1)
                            index--;
                        else
                            index++;
                    }
                    shark.r = index;
                    shark.d = dir;
                    break;
                case 3:
                case 4:
                    index = sc;
                    dir = shark.d;
                    for (int i = 0; i < shark.s; i++) {
                        if (dir == 4 && index == 0){
                            dir = 3;
                        }
                        if(dir == 3 && index == c-1){
                            dir = 4;
                        }
                        if(dir == 4)
                            index--;
                        else
                            index++;
                    }
                    shark.c = index;
                    shark.d = dir;
                    break;
            }
            shark.t = t+1;
            queue.offer(shark);
        }

        while(!queue.isEmpty()){
            Shark shark = queue.poll();

            if(map[shark.r][shark.c] != null){
                if(map[shark.r][shark.c].z < shark.z) {
                    map[shark.r][shark.c] = shark;
                }
            }
            else
                map[shark.r][shark.c] = shark;
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(map[i][j] != null)
                    queue.offer(map[i][j]);
            }
        }

    }

    public static class Shark{
        int r, c, s, d, z, t;

        public Shark(int r, int c, int s, int d, int z, int t) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
            this.t = t;
        }
    }
}
