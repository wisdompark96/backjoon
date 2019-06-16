import java.util.ArrayList;
import java.util.Scanner;

public class test_15683 {
    static int[][] map;
    static ArrayList<cctv> cctv;
    static int n;
    static int m;
    static int wall = 0;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        int cctvNum = 0;
        cctv = new ArrayList<>();
        int index = 0;
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = scanner.nextInt();

                if(map[i][j] != 6 && map[i][j] != 0)
                    cctvNum++;
                if(map[i][j] == 6)
                    wall++;

                switch (map[i][j]){
                    //0 = up, 1 = down, 2 = right, 3 = left
                    case 1:
                        cctv.add(new cctv(1,0, i, j));
                        break;
                    case 2:
                        cctv.add(new cctv(2, 0, i, j));
                        break;
                    case 3:
                        cctv.add(new cctv(3, 0, i, j));
                        break;
                    case 4:
                        cctv.add(new cctv(4, 0, i, j));
                        break;
                    case 5:
                        cctv.add(new cctv(5, 0, i, j));
                        break;
                }
            }
        }

        int[] bucket = new int[cctvNum];
        System.out.print(graph(cctv, bucket, cctvNum , cctvNum));

    }

    public static int graph(ArrayList<cctv> list, int[] bucket, int cctvN, int p){

        int min = 999999;

        if(p == 0){
            int[][] matrix = new int[n][m];
            int sum = 0;
            for(int i = 0; i < list.size(); i++){
                switch (list.get(i).type){
                    case 1:
                        switch (bucket[i]){
                            case 0:
                                sum += up(matrix, list.get(i).n-1, list.get(i).m);
                                break;
                            case 1:
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                break;
                            case 2:
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                break;
                            case 3:
                                sum += left(matrix, list.get(i).n, list.get(i).m-1);
                                break;
                        }
                        break;
                    case 2:
                        switch (bucket[i]){
                            case 0:
                            case 1:
                                sum += up(matrix, list.get(i).n-1,list.get(i).m);
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                break;
                            case 2:
                            case 3:
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                sum += left(matrix, list.get(i).n, list.get(i).m-1);
                                break;
                        }
                        break;
                    case 3:
                        switch (bucket[i]){
                            case 0:
                                sum += up(matrix, list.get(i).n-1, list.get(i).m);
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                break;
                            case 1:
                                sum += up(matrix, list.get(i).n-1, list.get(i).m);
                                sum += left(matrix, list.get(i).n, list.get(i).m-1);
                                break;
                            case 2:
                                sum += left(matrix, list.get(i).n, list.get(i).m-1);
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                break;
                            case 3:
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                break;
                        }
                        break;
                    case 4:
                        switch (bucket[i]){
                            case 0:
                                sum += up(matrix, list.get(i).n-1,list.get(i).m);
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                sum += left(matrix, list.get(i).n, list.get(i).m-1);
                                break;
                            case 1:
                                sum += up(matrix, list.get(i).n-1, list.get(i).m);
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                sum += left(matrix, list.get(i).n, list.get(i).m-1);
                                break;
                            case 2:
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                sum += left(matrix,list.get(i).n, list.get(i).m-1);
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                break;
                            case 3:
                                sum += up(matrix, list.get(i).n-1, list.get(i).m);
                                sum += down(matrix, list.get(i).n+1, list.get(i).m);
                                sum += right(matrix, list.get(i).n, list.get(i).m+1);
                                break;
                        }
                        break;
                    case 5:
                        sum += up(matrix, list.get(i).n-1, list.get(i).m);
                        sum += down(matrix, list.get(i).n+1, list.get(i).m);
                        sum += right(matrix,list.get(i).n, list.get(i).m+1);
                        sum += left(matrix, list.get(i).n, list.get(i).m-1);
                }

            }
            return (n*m) - (cctvN + sum + wall);
        }

        int lastIndex = cctvN -p -1;

        for(int i = 0; i < 4; i++){
            bucket[lastIndex+1] = i;
            min = Math.min(min, graph(list, bucket, cctvN, p-1));
        }

        return min;
    }


    public static int down(int[][] matrix, int x, int y){
        int sum = 0;
        if(x > n-1)
            return 0;
        if(map[x][y] == 6)
            return 0;

        if(matrix[x][y] == 0){
            matrix[x][y] = -1;

            if(map[x][y] != 0){
                sum += down(matrix, x+1, y);
            }
            else{
                sum += down(matrix, x+1, y) + 1;
            }
        }
        else{
            sum += down(matrix, x+1, y);
        }
        return sum;
    }

    public static int up(int[][] matrix, int x, int y){

        int sum = 0;
        if(x < 0)
            return 0;
        if(map[x][y] == 6)
            return 0;

        if(matrix[x][y] == 0){
            matrix[x][y] = -1;

           if(map[x][y] != 0){
                sum += up(matrix, x-1, y);
            }
            else{
                sum += up(matrix, x-1, y) + 1;
            }
        }
        else{
            sum += up(matrix, x-1, y);
        }
        return sum;
    }

    public static int left(int[][] matrix, int x, int y){
        int sum = 0;
        if(y < 0)
            return 0;
        if(map[x][y] == 6)
            return 0;
        if(matrix[x][y] == 0){
            matrix[x][y] = -1;

            if(map[x][y] != 0){
                sum += left(matrix, x, y-1);
            }
            else{
                sum += left(matrix, x, y-1) + 1;
            }
        }
        else{
            sum += left(matrix, x, y-1);
        }
        return sum;
    }

    public static int right(int[][] matrix, int x, int y){

        int sum = 0;
        if(y > m-1)
            return 0;
        if(map[x][y] == 6)
            return 0;
        if(matrix[x][y] == 0){
            matrix[x][y] = -1;

            if(map[x][y] != 0){
                sum += right(matrix, x, y+1);
            }
            else{
                sum += right(matrix, x, y+1) + 1;
            }
        }
        else{
            sum += right(matrix, x, y+1);
        }
        return sum;
    }

    public static class cctv{
        public int type;
        public int direction;
        public int n;
        public int m;

        public cctv(int type, int direction, int n, int m){
            this.type = type;
            this.direction = direction;
            this.n = n;
            this.m = m;
        }
    }

}
