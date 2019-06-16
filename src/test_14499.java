import java.util.Scanner;

public class test_14499 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] map = new int[n][m];

        Role role= new Role();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = scanner.nextInt();
            }
        }

        for(int i = 0; i < k; i++){
            int d = scanner.nextInt();
            int t = role.t;
            int down = role.d;
            int r = role.r;
            int l = role.l;
            int top = role.top;
            int b = role.b;
            switch (d){
                case 1:
                    if(y+1 > m-1)
                        continue;
                    role.top = l;
                    role.r = top;
                    role.l = b;
                    role.b = r;
                    if(map[x][y+1] == 0){
                        map[x][y+1] = role.value[role.b];
                    }else {
                        role.value[role.b] = map[x][y+1];
                        map[x][y+1] = 0;
                    }
                    System.out.println(role.value[role.top]);
                    y++;
                    break;
                case 2:
                    if(y-1 < 0)
                        continue;
                    role.top = r;
                    role.l = top;
                    role.b = l;
                    role.r = b;
                    if(map[x][y-1] == 0){
                        map[x][y-1] = role.value[role.b];
                    }else {
                        role.value[role.b] = map[x][y-1];
                        map[x][y-1] = 0;
                    }
                    System.out.println(role.value[role.top]);
                    y--;
                    break;
                case 3:
                    if(x-1 < 0)
                        continue;
                    role.top = down;
                    role.t = top;
                    role.d = b;
                    role.b = t;
                    if(map[x-1][y] == 0){
                        map[x-1][y] = role.value[role.b];
                    }else {
                        role.value[role.b] = map[x-1][y];
                        map[x-1][y] = 0;
                    }
                    System.out.println(role.value[role.top]);
                    x--;
                    break;
                case 4:
                    if(x+1 > n-1)
                        continue;
                    role.top = t;
                    role.t = b;
                    role.d = top;
                    role.b = down;
                    if(map[x+1][y] == 0){
                        map[x+1][y] = role.value[role.b];
                    }else {
                        role.value[role.b] = map[x+1][y];
                        map[x+1][y] = 0;
                    }
                    System.out.println(role.value[role.top]);
                    x++;
            }
        }

    }

    public static class Role{
        public int top;
        public int l;
        public int r;
        public int t;
        public int d;
        public int b;

        public int[] value;

        public Role() {
            value = new int[6];

            top = 0;
            l = 3;
            r = 2;
            t = 1;
            d = 4;
            b = 5;
            //0 = top, 1 = down, 2 = right, 3 = left
        }
    }
}
