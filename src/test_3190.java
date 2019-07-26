import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Move> queue = new LinkedList<>();


        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[n][n];
        int k = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < k; i++){
            String[] str = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            map[a-1][b-1] = 1;
        }

        int l = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < l; i++){
            String[] str = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            String c = str[1];
            queue.offer(new Move(x, c));
        }

        Snake snake = new Snake(0,0,n);
        String direct = "D";

        // D = right, L = left, U = up, N = down

        int cnt = 0;
        while (true){
            cnt++;

                if(direct.equals("D")){
                    if(snake.y+1 < n && snake.checkLength(snake.x, snake.y+1)){
                        snake.y++;
                        Integer[] b = new Integer[2];
                        b[0] = snake.x;
                        b[1] = snake.y;
                        snake.check.add(0, b);
                        if(map[snake.x][snake.y] != 1){
                            snake.check.remove(snake.check.size()-1);
                        } else {
                            map[snake.x][snake.y] = 0;
                        }
                    } else{
                        break;
                    }
                } else if(direct.equals("L")){
                    if(snake.y-1 >= 0 && snake.checkLength(snake.x, snake.y-1)){
                        snake.y--;
                        Integer[] b = new Integer[2];
                        b[0] = snake.x;
                        b[1] = snake.y;
                        snake.check.add(0, b);
                        if(map[snake.x][snake.y] != 1){
                            snake.check.remove(snake.check.size()-1);
                        } else {
                            map[snake.x][snake.y] = 0;
                        }
                    } else{
                        break;
                    }

                } else if(direct.equals("U")){
                    if(snake.x-1 >= 0 && snake.checkLength(snake.x-1, snake.y)){
                        snake.x--;
                        Integer[] b = new Integer[2];
                        b[0] = snake.x;
                        b[1] = snake.y;
                        snake.check.add(0, b);
                        if(map[snake.x][snake.y] != 1){
                            snake.check.remove(snake.check.size()-1);
                        } else {
                            map[snake.x][snake.y] = 0;
                        }
                    } else{
                        break;
                    }
                } else {

                    if(snake.x+1 < n && snake.checkLength(snake.x+1, snake.y)){
                        snake.x++;
                        Integer[] b = new Integer[2];
                        b[0] = snake.x;
                        b[1] = snake.y;
                        snake.check.add(0, b);
                        if(map[snake.x][snake.y] != 1){
                            snake.check.remove(snake.check.size()-1);
                        } else {
                            map[snake.x][snake.y] = 0;
                        }
                    } else{
                        break;
                    }
            }
            if(!queue.isEmpty() && queue.peek().x == cnt) {
                String d = queue.poll().c;
                switch (direct) {
                    case "D":
                        if (d.equals("D")) {
                            direct = "N";
                        } else {
                            direct = "U";
                        }
                        break;
                    case "L":
                        if (d.equals("D")) {
                            direct = "U";
                        } else {
                            direct = "N";
                        }
                        break;
                    case "U":
                        if (d.equals("D")) {
                            direct = "D";
                        } else {
                            direct = "L";
                        }
                        break;
                    case "N":
                        if (d.equals("D")) {
                            direct = "L";
                        } else {
                            direct = "D";
                        }
                        break;
                }
            }
        }

        System.out.print(cnt);


    }

    public static class Move{
        int x;
        String c;

        public Move(int x, String c){
            this.x = x;
            this.c = c;
        }
    }

    public static class Snake{
        int x, y;
        ArrayList<Integer[]> check;
        Integer[] tail;

        public Snake(int x, int y, int n){
            this.x = x;
            this.y = y;
            check = new ArrayList<>();
            tail = new Integer[2];
            tail[0] = x;
            tail[1] = y;
            check.add(tail);

        }

        public boolean checkLength(int x, int y) {

            for(int i = 0; i < check.size(); i++){
                if(check.get(i)[0] == x && check.get(i)[1] == y) {
                    return false;
                }
            }
            return true;
        }

    }
}
