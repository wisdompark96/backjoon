import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test_2857 {
    static int[] skip;
    static ArrayList<Integer> fbiList;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        skip = new int[200];
        String[] list = new String[5];
        fbiList = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            list[i] = scanner.next();
        }

        for(int i = 0; i < 5; i++){
            BM_Search(list[i], "FBI", i);
        }

        if(fbiList.size() == 0)
            System.out.print("HE GOT AWAY!");
        else{
            for(int i = 0; i < fbiList.size(); i++){
                System.out.print(fbiList.get(i)+" ");
            }
        }

    }
    public static void BM_Search(String text, String pattern, int index) {
        int patLen = pattern.length();
        int textLen = text.length();

        int i;
        int j;

        Arrays.fill(skip, patLen);

        for (int x = 0; x < patLen - 1; x++) {
            skip[pattern.charAt(x)] = patLen - x - 1;
        }
        i = patLen - 1;
        while (i < textLen) {
            j = patLen - 1;
            while (text.charAt(i) == pattern.charAt(j)) {
                if (j == 0) {
                    fbiList.add(index+1);
                    return;
                }
                i--;
                j--;
            }
            i = i + Math.max(skip[text.charAt(i)], patLen - j);
        }

    }
}
