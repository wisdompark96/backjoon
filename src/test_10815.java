import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class test_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<Long> set = new HashSet<>();

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < n; i++){
            set.add(Long.parseLong(stringTokenizer.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());


        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            if(set.add(Long.parseLong(str.nextToken()))){
                System.out.print(0+" ");
            } else{
                System.out.print(1+" ");
            }
        }
    }
}
