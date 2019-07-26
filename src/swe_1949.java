import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swe_1949 {
    static ArrayList<Mountain> start;
    static int result;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int tc = scanner.nextInt();

        for(int i = 1; i <= tc; i++){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            start = new ArrayList<>();
            result = 0;

            int[][] map = new int[n][n];
            int max = 0;
            for(int j = 0; j < n; j++){
                for(int l = 0; l < n; l++) {
                    map[j][l] = scanner.nextInt();
                    if(max < map[j][l]){
                        start.clear();
                        max = map[j][l];
                        start.add(new Mountain(j,l,map[j][l],0,1));
                    } else if(max == map[j][l]){
                        start.add(new Mountain(j,l,map[j][l],0, 1));
                    }
                }
            }

            findRoad(n, k, map);
            System.out.println("#"+i+" "+result);
        }
    }

    public static void findRoad(int n, int k, int[][] map){

        for(int i = 0; i < start.size(); i++){
            int[][][] check = new int[n][n][2];
            Queue<Mountain> queue = new LinkedList<>();
            queue.offer(start.get(i));
            check[start.get(i).x][start.get(i).y][0] = 1;
            check[start.get(i).x][start.get(i).y][1] = 1;

            int r = 0;
            while (!queue.isEmpty()){
                Mountain m = queue.poll();
                System.out.println(m.x+","+m.y+","+m.n);
                r = Math.max(r, m.n);
                if(m.x - 1 >= 0){
                    if( map[m.x-1][m.y] < m.h){
                        if(m.k == 0 && check[m.x-1][m.y][0] == 0) {
                            queue.offer(new Mountain(m.x - 1, m.y, map[m.x - 1][m.y], m.k, m.n+1));
                            check[m.x-1][m.y][0] = 1;
                        }
                        if(m.k != 0 && check[m.x-1][m.y][1] == 0){
                            queue.offer(new Mountain(m.x - 1, m.y, map[m.x - 1][m.y], m.k, m.n+1));
                            check[m.x-1][m.y][1] = 1;
                        }
                    } else {
                        if(m.k == 0 && check[m.x-1][m.y][0] == 0){
                            for(int j = 1; j <= k; j++) {
                                if (map[m.x][m.y] > map[m.x - 1][m.y] - j) {
                                    queue.offer(new Mountain(m.x - 1, m.y, map[m.x - 1][m.y] - j, 1, m.n+1));
                                    check[m.x - 1][m.y][1] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(m.x + 1 < n){
                    if( map[m.x+1][m.y] < m.h){
                        if(m.k == 0 && check[m.x+1][m.y][0] == 0) {
                            queue.offer(new Mountain(m.x + 1, m.y, map[m.x + 1][m.y], m.k, m.n+1));
                            check[m.x+1][m.y][0] = 1;
                        }
                        if(m.k != 0 && check[m.x+1][m.y][1] == 0){
                            queue.offer(new Mountain(m.x + 1, m.y, map[m.x + 1][m.y], m.k, m.n+1));
                            check[m.x + 1][m.y][1] = 1;
                        }
                    } else {
                        if(m.k == 0 && check[m.x+1][m.y][0] == 0){
                            for(int j = 1; j <= k; j++) {
                                if (map[m.x][m.y] > map[m.x + 1][m.y] - j) {
                                    queue.offer(new Mountain(m.x + 1, m.y, map[m.x + 1][m.y] - j, 1, m.n+1));
                                    check[m.x + 1][m.y][1] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(m.y - 1 >= 0){
                    if( map[m.x][m.y-1] < m.h){
                        if(m.k == 0 && check[m.x][m.y-1][0] == 0) {
                            queue.offer(new Mountain(m.x, m.y-1, map[m.x][m.y-1], m.k, m.n+1));
                            check[m.x][m.y-1][0] = 1;
                        }
                        if(m.k != 0 && check[m.x][m.y-1][1] == 0){
                            queue.offer(new Mountain(m.x , m.y-1, map[m.x ][m.y-1], m.k, m.n+1));
                            check[m.x][m.y-1][1] = 1;
                        }
                    } else {
                        if(m.k == 0 && check[m.x][m.y-1][0] == 0){
                            for(int j = 1; j <= k; j++) {
                                if (map[m.x][m.y] > map[m.x][m.y-1] - j) {
                                    queue.offer(new Mountain(m.x, m.y-1, map[m.x ][m.y-1] - j, 1, m.n+1));
                                    check[m.x][m.y-1][1] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(m.y + 1 < n){
                    if( map[m.x][m.y+1] < m.h){
                        if(m.k == 0 && check[m.x][m.y+1][0] == 0) {
                            queue.offer(new Mountain(m.x, m.y+1, map[m.x][m.y+1], m.k, m.n+1));
                            check[m.x][m.y+1][0] = 1;
                        }
                        if(m.k != 0 && check[m.x][m.y+1][1] == 0){
                            queue.offer(new Mountain(m.x , m.y+1, map[m.x ][m.y+1], m.k, m.n+1));
                            check[m.x ][m.y+1][1] = 1;
                        }
                    } else {
                        if(m.k == 0 && check[m.x][m.y+1][0] == 0){
                            for(int j = 1; j <= k; j++) {
                                if (map[m.x][m.y] > map[m.x][m.y+1] - j) {
                                    queue.offer(new Mountain(m.x , m.y+1, map[m.x ][m.y+1] - j, 1, m.n+1));
                                    check[m.x][m.y+1][1] = 1;
                                    break;
                                }
                            }
                        }
                    }
                }


            }

            result = Math.max(result, r);

        }
    }


    public static class Mountain{
        int x, y, h, n,k;

        public Mountain(int x, int y, int h, int k, int n) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.k = k;
            this.n = n;
        }
    }
}
