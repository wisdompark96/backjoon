import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class test_3961 {
    static HashMap<Character, Integer[]> hashMap;
    public static void main(String args[]) throws IOException {

        hashMap = new HashMap<>();

        String[] alpha = new String[3];
        alpha[0] = "qwertyuiop";
        alpha[1] = "asdfghjkl.";
        alpha[2] = "zxcvbnm...";

        for(int i = 0; i < 3; i++){
            String str = alpha[i];
            for(int j = 0; j < 10; j++){
                Integer[] integers = new Integer[2];
                integers[0] = i;
                integers[1] = j;
                hashMap.put(str.charAt(j), integers);
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < c; i++){
            String[] str = bufferedReader.readLine().split(" ");
            String word = str[0];
            int n = Integer.parseInt(str[1]);
            ArrayList<Word> list = new ArrayList<>();

            for(int j = 0; j < n; j++){
                String st = bufferedReader.readLine();
                int sum = 0;
                for(int k = 0; k < word.length(); k++){
                    Integer[] w = hashMap.get(word.charAt(k));
                    Integer[] s = hashMap.get(st.charAt(k));
                    int x = Math.abs(w[0]-s[0]);
                    int y = Math.abs(w[1]-s[1]);
                    sum += x+y;
                }
                list.add(new Word(st, sum));
            }

            Collections.sort(list);

            for(Word w : list){
                System.out.println(w.word+" "+w.interval);
            }

        }

        bufferedReader.close();

    }

    public static class Word implements Comparable<Word>{
        String word;
        int interval;

        public Word(String word, int interval){
            this.word = word;
            this.interval = interval;
        }

        @Override
        public int compareTo(Word o) {
            if(this.interval < o.interval)
                return -1;
            else if(this.interval > o.interval)
                return 1;
            else{
                if(this.word.compareTo(o.word) == 1)
                    return 1;
                else
                    return -1;
            }
        }
    }

}
