import java.util.Scanner;
import java.util.Stack;

public class test_14503 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Stack<Robot> stack = new Stack<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        Robot robot = new Robot();
        robot.r = r;
        robot.c = c;
        robot.d = d;

        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        stack.push(robot);

        map[r][c] = 2;

        int ans = 1;
        while(!stack.isEmpty()){
            Robot ro = stack.pop();

            int dir = ro.d;
            if(dir == 0)
                dir = 3;
            else
                dir--;

//            System.out.println(ro.r+","+ro.c+","+ro.d);

            int cnt = 1;
            while(cnt <= 4){
                if(dir == 3){
                    if(ro.c -1 >= 0 && map[ro.r][ro.c-1] != 1 && map[ro.r][ro.c-1] != 2 ){
                        Robot b = new Robot();
                        b.c = ro.c-1;
                        b.r = ro.r;
                        b.d = dir;
                        map[ro.r][ro.c-1] = 2;
                        stack.push(b);
                        ans++;
                        break;
                    }
                } else if(dir == 1){
                    if(ro.c +1 < m && map[ro.r][ro.c+1] != 1 && map[ro.r][ro.c+1] != 2 ){
                        Robot b = new Robot();
                        b.c = ro.c+1;
                        b.r = ro.r;
                        b.d = dir;
                        map[ro.r][ro.c+1] = 2;
                        stack.push(b);
                        ans++;
                        break;
                    }

                } else if(dir == 2){
                    if(ro.r +1 < n && map[ro.r+1][ro.c] != 1 && map[ro.r+1][ro.c] != 2 ){
                        Robot b = new Robot();
                        b.c = ro.c;
                        b.r = ro.r+1;
                        b.d = dir;
                        map[ro.r+1][ro.c] = 2;
                        stack.push(b);
                        ans++;
                        break;
                    }
                } else{
                    if(ro.r - 1 >= 0 && map[ro.r-1][ro.c] != 1 && map[ro.r-1][ro.c] != 2 ){
                        Robot b = new Robot();
                        b.c = ro.c;
                        b.r = ro.r-1;
                        b.d = dir;
                        map[ro.r-1][ro.c] = 2;
                        stack.push(b);
                        ans++;
                        break;
                    }
                }
                if(dir == 0)
                    dir = 3;
                else
                    dir--;
                cnt++;
            }

            if(cnt > 4){
                switch (ro.d){
                    case 0:
                        if(r+1 < n && map[ro.r+1][ro.c] != 1){
                            Robot b = new Robot();
                            b.d = ro.d;
                            b.r = ro.r+1;
                            b.c = ro.c;
                            stack.push(b);
                        }
                        break;
                    case 1:
                        if(c-1 >= 0 && map[ro.r][ro.c-1] != 1){
                            Robot b = new Robot();
                            b.d = ro.d;
                            b.r = ro.r;
                            b.c = ro.c-1;
                            stack.push(b);
                        }
                        break;
                    case 2:
                        if(r-1 >= 0 && map[ro.r-1][ro.c] != 1){
                            Robot b = new Robot();
                            b.d = ro.d;
                            b.r = ro.r-1;
                            b.c = ro.c;
                            stack.push(b);
                        }
                        break;
                    case 3:
                        if(c+1 < m && map[ro.r][ro.c+1] != 1){
                            Robot b = new Robot();
                            b.d = ro.d;
                            b.r = ro.r;
                            b.c = ro.c+1;
                            stack.push(b);
                        }
                }

            }
        }

        System.out.print(ans);

    }

    public static class Robot{
        int r;
        int c;
        int d;
    }
}
