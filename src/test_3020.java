import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int h = Integer.parseInt(inputs[1]);

        int[] C = new int[n];
        int[] cnt = new int[h+1];
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            C[i] = a;
        }


    }
}
