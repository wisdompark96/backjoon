import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {

        int a = 2;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(a == 1)
            bw.write(0);
        else
            bw.write(0);
        bw.flush();
        bw.close();
    }

}
