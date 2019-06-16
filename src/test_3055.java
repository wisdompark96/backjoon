import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_3055 {
    static Queue<Integer[]> move;
    static Queue<Integer[]> water;
    static int r;
    static int s;
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        move = new LinkedList();
        water = new LinkedList<>();
        r = scanner.nextInt();
        s = scanner.nextInt();

        String[][] map = new String[r][s];

        for(int i = 0; i < r; i++){

            String str = scanner.next();
            for(int j = 0; j < s; j++){
                map[i][j] = String.valueOf(str.charAt(j));
                if(map[i][j].equals("*")) {
                    Integer[] temp = new Integer[3];
                    temp[0] = i;
                    temp[1] = j;
                    temp[2] = 0;
                    water.offer(temp);
                }

                if(map[i][j].equals("S")){
                    Integer[] temp = new Integer[3];
                    temp[0] = i;
                    temp[1] = j;
                    temp[2] = 0;
                    move.offer(temp);
                }
            }
        }

        int result = 1000000;
        while(!move.isEmpty()){
            if(!water.isEmpty()) {
                Integer[] w = water.poll();
                BFS(w[0], w[1], w[2], map, true);
            }
            Integer[] m = move.poll();
            result = Math.min(result,BFS(m[0], m[1], m[2], map, false));
        }

        if(result == 1000000)
            System.out.print("KAKTUS");
        else
            System.out.print(result);

    }

    public static int BFS(int i, int j, int p, String[][] map, boolean iswater){

        int result = 1000000;
        if(iswater){
            if(i-1 >= 0 && (map[i-1][j].equals("S") || map[i-1][j].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i-1;
                b[1] = j;
                b[2] = p+1;
                map[i-1][j] = "*";
                water.offer(b);
            }

            if(i+1 < r  && (map[i+1][j].equals("S") || map[i+1][j].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i+1;
                b[1] = j;
                b[2] = p+1;
                map[i+1][j] = "*";
                water.offer(b);
            }

            if(j-1 >= 0 && (map[i][j-1].equals("S") || map[i][j-1].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i;
                b[1] = j-1;
                b[2] = p+1;
                map[i][j-1] = "*";
                water.offer(b);
            }

            if(j+1 < s && (map[i][j+1].equals("S") || map[i][j+1].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i;
                b[1] = j+1;
                b[2] = p+1;
                map[i][j+1] = "*";
                water.offer(b);
            }

            if(!water.isEmpty() && water.peek()[2] == p) {
                Integer[] b = water.poll();
                BFS(b[0], b[1], b[2], map, true);
            }
        }
        else{
            if(i-1 >= 0 && (map[i-1][j].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i-1;
                b[1] = j;
                b[2] = p+1;
                map[i-1][j] = "S";
                move.offer(b);
            }

            if(i+1 < r  && (map[i+1][j].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i+1;
                b[1] = j;
                b[2] = p+1;
                map[i+1][j] = "S";
                move.offer(b);
            }

            if(j-1 >= 0 && (map[i][j-1].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i;
                b[1] = j-1;
                b[2] = p+1;
                map[i][j-1] = "S";
                move.offer(b);
            }

            if(j+1 < s && (map[i][j+1].equals("."))){
                Integer[] b = new Integer[3];
                b[0] = i;
                b[1] = j+1;
                b[2] = p+1;
                map[i][j+1] = "S";
                move.offer(b);
            }

            if(i-1 >= 0 && (map[i-1][j].equals("D"))){
                result = p+1;
            }

            if(i+1 < r  && (map[i+1][j].equals("D"))){
               result = p+1;
            }

            if(j-1 >= 0 && (map[i][j-1].equals("D"))){
              result = p+1;
            }

            if(j+1 < s && (map[i][j+1].equals("D"))){
                result = p+1;
            }

            if(!move.isEmpty() && move.peek()[2] == p) {
                Integer[] b = move.poll();
                result = Math.min(result,BFS(b[0], b[1], b[2], map, false));
            }
        }

        return result;
    }
}
