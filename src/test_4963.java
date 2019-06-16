import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test_4963 {
    public static void main(String args[]){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String str = "";
            str = br.readLine();
            while(!str.equals("0 0")){
                String[] wh = str.split(" ");
                int w = Integer.parseInt(wh[0]);
                int h = Integer.parseInt(wh[1]);

                int[][] map = new int[h][w];

                for(int i = 0; i < h; i++){
                    String[] pixel = br.readLine().split(" ");
                    for(int j = 0; j < w; j++){
                        map[i][j] = Integer.parseInt(pixel[j]);
                    }
                }

                int sum = 0;
                for(int i = 0; i < h; i++){
                    for(int j = 0; j < w; j++){
                        if(map[i][j] == 1) {
                            dfs(i, j, map, h, w);
                            sum++;
                        }
                    }
                }

                System.out.println(sum);
                str = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void dfs(int x, int y, int[][] map, int w, int h){
        if(map[x][y] == 0)
            return ;
        else {
            map[x][y] = 0;

            if(x - 1 >= 0 && map[x - 1][y] != 0)
                dfs(x - 1, y, map, w, h);
            if(x + 1 < w && map[x + 1][y] != 0)
                dfs(x + 1, y, map, w, h);
            if(y - 1 >= 0 && map[x][y - 1] != 0)
                dfs(x, y - 1, map, w, h);
            if(y + 1 < h && map[x][y + 1] != 0)
                dfs(x, y + 1, map, w, h);
            if(x - 1 >= 0 && y - 1 >= 0 && map[x - 1][y - 1] != 0)
                dfs(x-1, y-1, map, w, h);
            if(x + 1 < w && y + 1 < h && map[x + 1][y + 1] != 0)
                dfs(x+1, y+1, map, w, h);
            if(x - 1 >= 0 && y + 1 < h && map[x - 1][y + 1] != 0)
                dfs(x-1, y+1, map, w, h);
            if(x + 1 < w && y - 1 >= 0 && map[x + 1][y - 1] != 0)
                dfs(x+1, y+-1, map, w, h);
        }

    }
}
