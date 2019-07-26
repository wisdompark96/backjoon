import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_16234 {

    static Country[][] map;
    static Queue<Integer[]> queue;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        queue = new LinkedList<>();

        map = new Country[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = new Country(false, false, false, false);
                map[i][j].value = scanner.nextInt();
            }
        }

        int cnt = 0;
        while(checkMove(n, l, r)){
            boolean[][] check = new boolean[n][n];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(check[i][j])
                        continue;
                    Queue<Integer[]> queue2 = new LinkedList<>();
                    Integer[] idx = new Integer[2];
                    idx[0] = i;
                    idx[1] = j;
                    queue.offer(idx);
                    queue2.offer(idx);
                    int num = 0;
                    int sum = 0;
                    int result = 0;
                    check[i][j] = true;
                    while(!queue.isEmpty()){
                        Integer[] index = queue.poll();
                        int x = index[0];
                        int y = index[1];
                        num++;
                        sum+= map[x][y].value;
                        if(x+1 < n && !check[x+1][y] && map[x][y].bottom){
                            Integer[] b = new Integer[2];
                            b[0] = x+1;
                            b[1] = y;
                            queue.offer(b);
                            queue2.offer(b);
                            check[x+1][y] = true;
                        }
                        if(x-1 >= 0 && !check[x-1][y] && map[x][y].top){
                            Integer[] b = new Integer[2];
                            b[0] = x-1;
                            b[1] = y;
                            queue.offer(b);
                            queue2.offer(b);
                            check[x-1][y] = true;
                        }
                        if(y+1 < n && !check[x][y+1] && map[x][y].right){
                            Integer[] b = new Integer[2];
                            b[0] = x;
                            b[1] = y+1;
                            queue.offer(b);
                            queue2.offer(b);
                            check[x][y+1] = true;
                        }
                        if(y-1 >= 0 && !check[x][y-1] && map[x][y].left){
                            Integer[] b = new Integer[2];
                            b[0] = x;
                            b[1] = y-1;
                            queue.offer(b);
                            queue2.offer(b);
                            check[x][y-1] = true;
                        }
                    }

                    result = sum/num;
                    while(!queue2.isEmpty()){
                        Integer[] index = queue2.poll();
                        map[index[0]][index[1]].value = result;
                        map[index[0]][index[1]].left = false;
                        map[index[0]][index[1]].right = false;
                        map[index[0]][index[1]].top = false;
                        map[index[0]][index[1]].bottom = false;

                    }
                }
            }
            cnt++;

        }

        System.out.print(cnt);
    }

    public static boolean checkMove(int n, int l, int r){

        boolean check = false;
        for(int i = 0; i < n; i++) {
            boolean c = false;
            for (int j = 0; j < n; j++) {
                if (i + 1 < n && Math.abs(map[i + 1][j].value - map[i][j].value) >= l && Math.abs(map[i + 1][j].value - map[i][j].value) <= r ) {
                    map[i][j].bottom = true;
                    map[i+1][j].top = true;
                    check = true;
                    c = true;
                }

                if (j + 1 < n && Math.abs(map[i][j + 1].value - map[i][j].value) >= l && Math.abs(map[i][j + 1].value - map[i][j].value) <= r ) {
                    map[i][j].right = true;
                    map[i][j+1].left = true;
                    check = true;
                    c = true;
                }
            }
        }

        return check;
    }

    static class Country{
        int value;
        boolean top, bottom, left, right;

        public Country(boolean top, boolean bottom, boolean left, boolean right) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
        }
    }

}
