import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class test_14729 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            float[] scores = new float[n];
            for (int i = 0; i < n; i++) {
                scores[i] = Float.parseFloat(br.readLine());
            }

            Arrays.sort(scores);

            for (int i = 0; i < 7; i++) {
                System.out.println(String.format("%.3f", scores[i]));
            }
        }catch (IOException e){

        }

    }
}
