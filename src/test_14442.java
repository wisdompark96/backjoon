import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class test_14442 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Queue<Move> queue = new LinkedList<>();
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int cntW = 0;

        int[][] map = new int[n][m];
        int[][][]visited = new int[n][m][k+1];

        for(int i = 0; i < n; i++){
            String s = bufferedReader.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                if(map[i][j] == 1)
                    cntW++;
            }
        }

        queue.offer(new Move(0,0,1,k));
        visited[0][0][k] = 1;

        int result = -1;

        while(!queue.isEmpty()){
            Move move = queue.poll();
            int x = move.x;
            int y = move.y;

            if(move.x == n-1 && move.y == m-1){
                result = move.depth;
                break;
            }

            if(x - 1 >= 0 ){
                if(map[x-1][y] == 1 && move.b > 0 && visited[x-1][y][move.b] == 0){
                    visited[x-1][y][move.b] = 1;
                    queue.offer(new Move(x-1,y,move.depth + 1, move.b-1));
                } else if(map[x-1][y] == 0){
                    if(move.b > 0 && visited[x-1][y][move.b] == 0) {
                        visited[x-1][y][move.b] = 1;
                        queue.offer(new Move(x - 1, y, move.depth + 1, move.b));
                    } else if(move.b == 0 && visited[x-1][y][0] == 0){
                        visited[x-1][y][0] = 1;
                        queue.offer(new Move(x - 1, y, move.depth + 1, move.b));
                    }
                }
            }

            if(x + 1 < n){
                if(map[x+1][y] == 1 && move.b > 0 && visited[x+1][y][move.b] == 0) {
                    visited[x+1][y][move.b] = 1;
                    queue.offer(new Move(x+1, y, move.depth + 1, move.b-1));
                } else if(map[x+1][y] == 0 ){
                    if(move.b > 0 && visited[x+1][y][move.b] == 0) {
                        visited[x+1][y][move.b] = 1;
                        queue.offer(new Move(x + 1, y, move.depth + 1, move.b));
                    } else if(move.b == 0 && visited[x+1][y][1] == 0){
                        visited[x+1][y][0] = 1;
                        queue.offer(new Move(x + 1, y, move.depth + 1, move.b));
                    }
                }
            }

            if(y - 1 >= 0 ){
                if(map[x][y-1] == 1 && move.b > 0 && visited[x][y-1][move.b] == 0){
                    visited[x][y-1][move.b] = 1;
                    queue.offer(new Move(x, y-1, move.depth+1, move.b-1));
                } else if(map[x][y-1] == 0){
                    if( move.b > 0 && visited[x][y-1][move.b] == 0) {
                        visited[x][y-1][move.b] = 1;
                        queue.offer(new Move(x, y - 1, move.depth + 1, move.b));
                    } else if(move.b == 0 && visited[x][y-1][0] == 0){
                        visited[x][y-1][0] = 1;
                        queue.offer(new Move(x, y - 1, move.depth + 1, move.b));
                    }
                }
            }

            if(y + 1 < m ){
                if(map[x][y+1] == 1 && move.b > 0 && visited[x][y+1][move.b] == 0 ){
                    visited[x][y+1][move.b] = 1;
                    queue.offer(new Move(x, y+1, move.depth+1, move.b-1));
                } else if(map[x][y+1] == 0){
                    if(move.b > 0 &&  visited[x][y+1][move.b] == 0) {
                        visited[x][y+1][move.b] = 1;
                        queue.offer(new Move(x, y + 1, move.depth + 1, move.b));
                    } else if(move.b == 0 && visited[x][y+1][0] == 0){
                        visited[x][y+1][0] = 1;
                        queue.offer(new Move(x, y + 1, move.depth + 1, move.b));
                    }
                }
            }
        }

        System.out.print(result);
    }


    public static class Move{
        int x, y, depth, b;

        public Move(int x, int y, int depth, int b) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.b = b;
        }
    }


}
