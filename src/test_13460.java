import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_13460 {
    static int n;
    static int m;
    static String[][] map;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        Queue<Balls> queue = new LinkedList<>();

        n = scanner.nextInt();
        m = scanner.nextInt();

        map = new String[n][m];

        int bn = 0;
        int bm = 0;
        int rn = 0;
        int rm = 0;
        int on = 0;
        int om = 0;
        for(int i = 0; i < n; i++){
            String str = scanner.next();
            for(int j = 0; j <m; j++){

                map[i][j] = String.valueOf(str.charAt(j));

                if(map[i][j].equals("B")){
                    bn = i;
                    bm = j;
                }
                if(map[i][j].equals("R")){
                    rn = i;
                    rm = j;
                }
                if(map[i][j].equals("O")){
                   on = i;
                   om = j;
                }
            }
        }

        queue.offer(new Balls(rn, rm, bn, bm,0));

        int[][][][]visit = new int[n][m][n][m];
        visit[rn][rm][bn][bm] = 1;

        int result = -1;
        while (!queue.isEmpty()){

            Balls balls = queue.poll();

            int rx = balls.rx;
            int ry = balls.ry;
            int bx = balls.bx;
            int by = balls.by;

            if(balls.cnt > 10)
                break;

            if(balls.rx == on && balls.ry == om){
                result = balls.cnt;
                break;
            }

            for(int i = 0; i < 4; i++){

                Balls ball = new Balls();

                int[] r = move(i, rx, ry);
                ball.rx = r[0];
                ball.ry = r[1];

                int[] b = move(i, bx, by);
                ball.bx = b[0];
                ball.by = b[1];

                if(ball.bx == on && ball.by == om)
                    continue;


                if(ball.rx == ball.bx && ball.ry == ball.by){
                    switch (i){
                        case 0:
                            if(balls.rx > balls.bx){
                               ball.rx++;
                            } else{
                                ball.bx++;
                            }
                            break;
                        case 1:
                            if(balls.rx > balls.bx){
                                ball.bx--;
                            }else{
                                ball.rx--;
                            }
                            break;
                        case 2:
                            if(balls.ry > balls.by){
                                ball.ry++;
                            }
                            else{
                                ball.by++;
                            }
                            break;
                        case 3:
                            if(balls.ry > balls.by){
                                ball.by--;
                            }
                            else{
                                ball.ry--;
                            }
                            break;
                    }
                }

                if(visit[ball.rx][ball.ry][ball.bx][ball.by] == 0){
                    ball.cnt = balls.cnt+1;
                    queue.offer(ball);
                    visit[ball.rx][ball.ry][ball.bx][ball.by] = 1;
                }

            }

        }

        System.out.print(result);
    }

    // 0 : up, 1 : down, 2 : left, 3 : right
    public static int[] move(int dir,int x,int y){

        int[] i = new int[2];
        switch (dir){
            case 0:
                while(!map[x][y].equals("#") ){
                    if(map[x][y].equals("O") ){
                        i[0] = x;
                        i[1] = y;
                        return i;
                    }
                    x--;
                }
                x++;
                break;
            case 1:
                while(!map[x][y].equals("#") ){
                    if(map[x][y].equals("O")){
                        i[0] = x;
                        i[1] = y;
                        return i;
                    }
                    x++;
                }
                x--;
                break;
            case 2:
                while(!map[x][y].equals("#")){
                    if(map[x][y].equals("O") ){
                        i[0] = x;
                        i[1] = y;
                        return i;
                    }
                    y--;
                }
                y++;
                break;
            case 3:
                while(!map[x][y].equals("#")){
                    if(map[x][y].equals("O")){
                        i[0] = x;
                        i[1] = y;
                        return i;
                    }
                    y++;
                }
                y--;
                break;
        }

        i[0] = x;
        i[1] = y;
        return i;

    }

    public static class Balls{
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Balls(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
        public Balls(){

        }
    }

}