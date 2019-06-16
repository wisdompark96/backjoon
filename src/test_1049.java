import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class test_1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()," ");
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Integer> set = new ArrayList<>();
        ArrayList<Integer> single = new ArrayList<>();
        for(int i = 0; i < m; i++){
            StringTokenizer str = new StringTokenizer(bufferedReader.readLine()," ");
            set.add(Integer.parseInt(str.nextToken()));
            single.add(Integer.parseInt(str.nextToken()));
        }

        Collections.sort(set);
        Collections.sort(single);

        int min = 99999;
        int num = n;
        int sum = 0;

        if(n < 6)
            sum = set.get(0);
        else {
            sum = (num / 6 * set.get(0));
            if(num%6 != 0)
                sum += set.get(0);
        }
        min = Math.min(min, sum);

        sum = (num/6* set.get(0)) + (num%6 * single.get(0)) ;

        min = Math.min(min, sum);
        min = Math.min(min, n*single.get(0));

        System.out.print(min);
    }
}
