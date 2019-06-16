import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test_1726 {

    static int n;
    static int m;
    static int[][] map;
    static int[][][] visit;
    static Queue<Robot> queue;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        queue = new LinkedList<>();
        map = new int[m][n];

        String[] str = null;
        for(int i = 0; i < m; i++){
             str = bufferedReader.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        input = bufferedReader.readLine().split(" ");
        int si = Integer.parseInt(input[0])-1;
        int sj = Integer.parseInt(input[1])-1;
        int sd = Integer.parseInt(input[2]);

        input = bufferedReader.readLine().split(" ");
        int ei = Integer.parseInt(input[0])-1;
        int ej = Integer.parseInt(input[1])-1;
        int ed = Integer.parseInt(input[2]);

        visit = new int[m][n][5];
        visit[si][sj][sd] = 1;

        queue.offer(new Robot(si, sj, sd, 0));
        int result = 0;
        for(int x = 0; x == 0;){
            if(queue.isEmpty())
                break;

            Robot robot = queue.poll();
            if(robot.x == ei && robot.y == ej ){
                    result = robot.depth + direction(robot.dir, ed);
                break;
            }

            for(int i = 1; i < 5; i++) {
                switch (i){
                    case 1:
                        if(robot.dir != 2 && robot.y + 1 < n && map[robot.x][robot.y+1] != 1 && visit[robot.x][robot.y+1][robot.dir] == 0)
                            goK(robot, direction(robot.dir, i), i);
                        break;
                    case 2:
                        if(robot.dir != 1 && robot.y - 1 >= 0 && map[robot.x][robot.y-1] != 1 && visit[robot.x][robot.y-1][robot.dir] == 0)
                            goK(robot, direction(robot.dir, i), i);
                        break;
                    case 3:
                        if(robot.dir != 4 && robot.x + 1 < m && map[robot.x+1][robot.y] != 1 && visit[robot.x+1][robot.y][robot.dir] == 0)
                            goK(robot, direction(robot.dir, i), i);
                        break;
                    case 4:
                        if(robot.dir != 3 && robot.x - 1 >= 0 && map[robot.x-1][robot.y] != 1 && visit[robot.x-1][robot.y][robot.dir] == 0)
                            goK(robot, direction(robot.dir, i), i);
                        break;
                }
            }
        }

        System.out.print(result);
        //동:1, 서:2, 남:3, 북:4
    }

    public static void goK(Robot r, int offset, int dir){

            for(int i = 1; i <= 3; i++){
            switch (dir){
                case 1:
                    if(r.y + i < n && map[r.x][r.y+i] != 1 && visit[r.x][r.y+i][dir] == 0) {
                        int d = r.depth + offset+1;
                        Robot robot = new Robot(r.x, r.y+i, dir, d);
                        queue.offer(robot);
                    }
                    else
                        return;
                    break;
                case 2:
                    if(r.y - i >= 0 && map[r.x][r.y-i] != 1 && visit[r.x][r.y-i][dir] == 0) {
                        int d = r.depth + offset+1;
                        Robot robot = new Robot(r.x, r.y-i, dir, d);
                        queue.offer(robot);
                    }
                    else
                        return;
                    break;
                case 3:
                    if(r.x + i < m && map[r.x+i][r.y] != 1 && visit[r.x+i][r.y][dir] == 0){
                        int d = r.depth + offset+1;
                        Robot robot = new Robot(r.x+i, r.y, dir, d);
                        queue.offer(robot);
                    }
                    else
                        return;
                    break;
                case 4:
                    if(r.x - i >= 0 && map[r.x-i][r.y] != 1 && visit[r.x-i][r.y][dir] == 0){
                        int d = r.depth + offset+1;
                        Robot robot = new Robot(r.x-i, r.y, dir, d);
                        queue.offer(robot);
                    }
                    else
                        return;
                    break;
            }
        }
    }


    public static int direction(int d, int d2){

        if(d != d2) {
            switch (d) {
                case 1:
                    if (d2 == 2)
                        return 2;
                    else
                        return 1;
                case 2:
                    if (d2 == 1)
                        return 2;
                    else
                        return 1;
                case 3:
                    if (d2 == 4)
                        return 2;
                    else
                        return 1;
                case 4:
                    if (d2 == 3)
                        return 2;
                    else
                        return 1;
            }
        }
        return 0;
    }

    public static class Robot{
        int x;
        int y;
        int dir;
        int depth;

        public Robot(int x, int y, int dir, int depth) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.depth = depth;
        }
    }
}
