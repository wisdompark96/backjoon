import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_17144 {
    static int[][] room;
    static int r;
    static int c;
    static int lx;
    static int ly;
    static int rx;
    static int ry;
    static Queue<M> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        int t = Integer.parseInt(input[2]);

        lx = -1;
        ly = -1;
        rx = -1;
        ry = -1;

        room = new int[r][c];

        queue = new LinkedList<>();
        for(int i = 0; i < r; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < c; j++){
                room[i][j] = Integer.parseInt(str[j]);

                if(room[i][j] == -1){
                    if(lx == -1){
                        lx = i;
                        ly = j;
                    } else {
                        rx = i;
                        ry = j;
                    }
                }
                else if(room[i][j] != 0){
                    M m = new M(i, j, room[i][j]);
                    queue.offer(m);
                }
            }
        }

        for(int i = 0; i < t; i++){
            spreadM(queue);
            moveAir(lx,ly+1,true,0);
            moveAir(rx, ry+1, false, 0);
            getM();
        }

        int sum = 0;
        while(!queue.isEmpty()){
            sum += queue.poll().value;
        }

        System.out.print(sum);
    }

    public static void getM(){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(room[i][j] != 0 && room[i][j] != -1){
                    M m = new M(i, j, room[i][j]);
                    queue.offer(m);
                }
            }
        }
    }

    public static void moveAir(int x, int y,boolean isLeft, int prev){

        if(room[x][y] == -1){
            return;
        }
        if(isLeft){
            if(x == lx && y > 0 && y < c-1 ){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x, y+1, isLeft, t);
            }

            if(y == c-1 && x > 0){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x-1, y, isLeft, t);
            }

            if(y > 0 && x == 0){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x, y-1, isLeft, t);
            }

            if(y == 0 && x < lx){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x+1, y, isLeft, t);
            }
        }
        else {

            if(x == rx && y > 0 && y < c-1){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x, y+1, isLeft, t);
            }

            if(y == c-1 && x < r-1){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x+1, y, isLeft, t);
            }

            if(x == r-1 && y > 0 && y < c){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x, y-1, isLeft, t);
            }

            if(y == 0 && x > rx){
                int t = room[x][y];
                room[x][y] = prev;
                moveAir(x-1, y, isLeft, t);
            }
        }

    }


    public static void spreadM(Queue<M> list){

        while(!list.isEmpty()){
            M m = list.poll();
            int n = room[m.i][m.j] - m.value;
            int cnt = 0;
            int a = m.value/5;
            if(m.i - 1 >= 0 && room[m.i-1][m.j] != -1){
                room[m.i-1][m.j] += a;
                cnt++;
            }
            if(m.i + 1 < r  && room[m.i+1][m.j] != -1){
                room[m.i+1][m.j] += a;
                cnt++;
            }
            if(m.j - 1 >= 0 && room[m.i][m.j-1] != -1){
                room[m.i][m.j-1] += a;
                cnt++;
            }
            if(m.j + 1 < c && room[m.i][m.j+1] != -1){
                room[m.i][m.j+1] += a;
                cnt++;
            }

            room[m.i][m.j] = (m.value - a*cnt) + n;
        }
    }

    public static class M{
        int i;
        int j;
        int value;

        public M(int i, int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
