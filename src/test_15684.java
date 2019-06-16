import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_15684 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);
        int[][] line  = new int[m+1][n+1];

        for(int i = 0; i < m; i++){
            String[] str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]);
            int r = Integer.parseInt(str[1]);
            line[l][r] = 1;
        }

    }

}
