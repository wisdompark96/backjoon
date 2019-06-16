import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test_11719 {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
    }
}
