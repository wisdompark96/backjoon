import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test_1149 {
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),8);
        int n = Integer.parseInt(br.readLine());

        memo = new int[n][3];
        int[][] matrix = new int[n][3];
        int[] bucket = new int[n];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            for(int j = 0; j < 3; j++){
                matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int min = 999999;
        for(int i =0; i < 3; i++)
            min = Math.min(min,dp(n-1, matrix, i, n));
        System.out.print(min);

    }

    public static int dp( int p, int[][] matrix, int c, int n){

        int sum = 0;
        int min = 999999;

        int index = n-p-1;
        if(p == 0){
//            System.out.println(matrix[p][c]);
            return matrix[n-1][c];
        }

        for(int i = 0; i < 3; i++){
            if(c != i){
                if(memo[index+1][i] == 0)
                    memo[index+1][i] = dp(p-1,matrix,i, n);
                min = Math.min(min, memo[index+1][i]);
            }
//            System.out.println("p="+p+","+min);
        }


        return matrix[index][c]+min;
    }
}
