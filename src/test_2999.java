import java.util.Scanner;

public class test_2999 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String msg = scanner.next();

        int len = msg.length();
        char[] chars = new char[len];


        int max = 1;
        for(int i = 0; i < len; i++){
            chars[i] = msg.charAt(i);
            if(len % (i+1) == 0){
                if(len/(i+1) >= i+1){
                    max = Math.max(max, i+1);
                }
            }
        }

        char[][] matrix = new char[len/max][max];

        int cnt = 0;
        for(int i = 0; i < len/max; i++){
            for(int j = 0; j < max; j++){
                matrix[i][j] = chars[cnt++];
            }
        }

        String str = "";
        for(int i = 0; i < max; i++){
            for(int j = 0; j < len/max; j++){
                str += matrix[j][i];
            }
        }

        System.out.print(str);

    }
}
