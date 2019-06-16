import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class test_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            long c =Long.parseLong(stringTokenizer.nextToken());
            if(!map.containsKey(c))
                map.put(c,1);
            else
                map.replace(c, map.get(c)+1);
        }

        int m = Integer.parseInt(br.readLine());

        int[] num = new int[m];

        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            long c = Long.parseLong(str.nextToken());
            if(map.containsKey(c))
                num[i] = map.get(c);
            else
                num[i] = 0;
        }

        for(int i = 0; i <num.length; i++)
            System.out.print(num[i]+" ");
    }
}
