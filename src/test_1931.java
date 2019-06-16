import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Greedy 알고리즘
 */

public class test_1931 {
    static int[][] list;
    static int n;
    static int[] memo;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bufferedReader.readLine());
        list = new int[n][2];

        int maxE = 0;
        for(int i = 0; i < n; i++){
            String[] times = bufferedReader.readLine().split(" ");
            list[i][0] = Integer.parseInt(times[0]);
            list[i][1] = Integer.parseInt(times[1]);
            maxE = Math.max(maxE, list[i][1]);
        }

        int[] bucket = new int[n];
        Arrays.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                final Integer e1 = o1[1];
                final Integer e2 = o2[1];
                if(e1.equals(e2))
                    return Integer.compare(o1[0],o2[0]);
                return Integer.compare(e1, e2);
            }
        });
        int max = 0;
        memo = new int[n];
        memo[n-1] = 1;
        int pj = 0;

        for(int i = 1; i < n; i++){
            if(list[i][0] >= list[pj][1]){
                max++;
                pj = i;
            }
        }

        System.out.print(max+1);

    }



}
