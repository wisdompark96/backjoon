import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<Long> arrayList = new ArrayList<>();
        StringTokenizer stringTokenizer =new StringTokenizer(bufferedReader.readLine(), " ");
        for(int i = 0; i < n; i++){
            arrayList.add(Long.parseLong(stringTokenizer.nextToken()));
        }
        StringTokenizer str = new StringTokenizer(bufferedReader.readLine(), " ");
        for(int i = 0; i < m; i++){
            arrayList.add(Long.parseLong(str.nextToken()));
        }

        Collections.sort(arrayList);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i= 0; i < arrayList.size(); i++)
            bufferedWriter.write(arrayList.get(i)+" ");
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
