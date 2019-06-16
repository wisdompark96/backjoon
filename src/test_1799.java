import java.util.ArrayList;
import java.util.Scanner;

public class test_1799 {
    static ArrayList<Integer> list;
    static int[][] map;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                map[i][j] = scanner.nextInt();

            }

        }
        int[][] memo = new int[n][n];

        int max = 0;
        if(map[0][0] == 1)
            memo[0][0] = 1;
        max = Math.max(max,DFS(1, n, memo,true)+memo[0][0]);
        memo[0][0] = 0;
        max = Math.max(max,DFS(1, n, memo,true));

        System.out.print(max);
    }

    public static int DFS(int x, int n, int[][] memo, boolean isItStart){
        int max = 0;
        boolean have = false;

        if(x == n){
            if(isItStart) {
                isItStart = false;
                x = 0;
            } else
                return 0;
        }

        if(isItStart) {
            for (int i = 0; i < x + 1; i++) {
                if(map[x-i][i] == 1) {
                    have = true;
                    if (memo[x-i][i] == 0 && isItRight(x - i, i, n, memo)) {
                        memo[x - i][i] = 1;
                        max = Math.max(max, DFS(x + 1, n, memo, isItStart) + 1);
                        memo[x - i][i] = 0;
                    }
                }
            }

        } else {

            for (int i = 0; i < x+1; i++) {
                if(map[n-1-(x-i)][n-1-i] == 1) {
                    have = true;
                    if (memo[n - 1 - (x - i)][n - 1 - i] == 0 &&isItRight(n - 1 - (x - i), n - 1 - i, n, memo)) {
                        memo[n - 1 - (x - i)][n - 1 - i] = 1;
                        max = Math.max(max, DFS(x + 1, n, memo, isItStart) + 1);
                        memo[n - 1 - (x - i)][n - 1 - i] = 0;
                    }
                }
            }
        }
        if(!have)
            max = Math.max(max, DFS(x + 1, n, memo, isItStart));
        return max;

    }

    public static boolean isItRight(int x, int y, int n, int[][]memo){

        for(int i = 1; i < n; i++){
            if(x-i >= 0 && y-i >= 0 ) {
                if (memo[x - i][y - i] == 1)
                    return false;
            }
            else
                break;
        }

        for(int i = 1; i < n; i++){
            if(x-i >= 0 && y+i < n ) {
                if (memo[x - i][y + i] == 1)
                    return false;
            }
            else
                break;
        }

        for(int i = 1; i < n; i++){
            if(x+i < n && y-i >= 0 ) {
                if (memo[x + i][y - i] == 1)
                    return false;
            }
            else
                break;
        }

        for(int i = 1; i < n; i++){
            if(x+i < n && y+i < n ) {
                if (memo[x + i][y + i] == 1)
                    return false;
            }
            else
                break;
        }
        return true;
    }


}
