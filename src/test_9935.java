import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class test_9935 {
    static int[] skip;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = null;
        String P = null;
        skip = new int[124];

        text = br.readLine();
        P = br.readLine();
        BM_Search(text, P);
        br.close();
    }

    public static void BM_Search(String text, String pattern) throws IOException {
        int patLen = pattern.length();
        int textLen = text.length();
        StringBuilder str = new StringBuilder();

        int i;
        int j;

        for(int a = 0; a < skip.length; a++){
            skip[a] = patLen;
        }

        for (int x = 0; x < patLen - 1; x++) {
            skip[pattern.charAt(x)] = patLen - x - 1;
        }
        i = patLen - 1;
        while (i < textLen) {
            j = patLen - 1;
            while (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0) {
                    for(int x = 0; x < i; x++)
                        str.append(text.charAt(x));
                    for(int x = i+patLen; x < textLen; x++)
                        str.append(text.charAt(x));
                    text = str.toString();
                    BM_Search(text, pattern);
                    return;
                }
                i--;
                j--;
            }
            i = i + Math.max(skip[text.charAt(i)], patLen - j);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if(text.length() == 0)
            bw.write("FRULA");
        else
            bw.write(text);
        bw.flush();
        bw.close();
    }
}

