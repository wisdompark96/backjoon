import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kakao_2017 {
    static int MOD = 20170805;
    static int[][] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

        /*for(int i = 0; i < 500; i++){
            String str = bufferedReader.readLine();
            for(int j = 0; j < 500; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }*/

        solution(3,6, map);
    }
    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] U = new int[m][n];
        int[][] L = new int[m][n];
        memo = new int[m][n];

        U[0][0] = 1;
        L[0][0] = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0)
                    continue;
                if(cityMap[i][j] == 0){
                    if(i != 0 && j != 0){
                        U[i][j] = (U[i-1][j]+ L[i][j-1]) % MOD;
                        L[i][j] = (U[i-1][j]+ L[i][j-1]) % MOD;
                    } else if(i == 0){
                        L[i][j] = L[i][j-1];
                        U[i][j] = L[i][j-1];
                    } else {
                        L[i][j] = U[i-1][j];
                        U[i][j] = U[i-1][j];
                    }
                }else if(cityMap[i][j] == 1){
                    U[i][j] = 0;
                    L[i][j] = 0;
                } else{
                   if(i != 0 && j != 0){
                       U[i][j] = U[i-1][j];
                       L[i][j] = L[i][j-1];
                   } else if(i == 0){
                       L[i][j] = L[i][j-1];
                   } else{
                       U[i][j] = U[i-1][j];
                   }
                }

            }
        }

        answer = L[m-1][n-1]%MOD;
        return answer;
    }

}
