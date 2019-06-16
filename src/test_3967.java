import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class test_3967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] magic = new char[5][9];

        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            String str = br.readLine();
            for (int j = 0; j < 9; j++){
                magic[i][j] = str.charAt(j);

                if(magic[i][j] == 'x'){
                    Integer[] b = new Integer[2];
                    b[0] = i;
                    b[1] = j;
                    list.add(b);
                }
            }
        }


    }

    public void recur(int[] bucket, char[][] magic, ArrayList<Integer[]> list, int p){

        if(p == 0){

        }

        for(int i = 0; i < 12; i++){

        }

    }

    public static boolean checkSum(char[][] magic){

        int j = 0;
        int sum = 0;
        for(int i = 4; i > 0; i--){
            if(magic[j][i] != 'x'){
                sum += magic[j][i]-64;
            }
            j++;
        }

        if(sum != 26)
            return false;

        sum = 0;
        j = 0;

        for(int i = 4; i < 8; i++){
            if(magic[j][i] != 'x'){
                sum += magic[j][i]-64;
            }
            j++;
        }

        if(sum != 26)
            return false;

        sum = 0;
        for(int i = 1; i < 8; i++){
            if(magic[1][i] != '.' && magic[1][i] != 'x'){
                sum += magic[1][i]-64;
            }
        }

        if(sum != 26)
            return false;
        return true;
    }
}
