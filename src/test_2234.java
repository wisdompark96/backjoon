import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_2234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[][] map = new int[n][m];
        int[][][] check = new int[n][m][1];
        for(int i = 0; i < n; i++){
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
    }
}
