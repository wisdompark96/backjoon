import java.io.*;

public class test_11718 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        String str = br.readLine();
        while(str != null){
            bw.write(str);
            bw.newLine();
            bw.flush();
            if((str =br.readLine()) ==null)
                return;
        }


        br.close();
        bw.close();
    }
}
