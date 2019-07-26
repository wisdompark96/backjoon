import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test_1205 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int user = scanner.nextInt();
        int p = scanner.nextInt();

        Integer[] record = new Integer[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            record[i] = scanner.nextInt();
        }
        Arrays.sort(record, Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            if(i == 0 || i == n-1){
                rank[i] = i+1;
            } else{
                if(record[i-1] == record[i])
                    rank[i] = rank[i-1];
                else{
                    rank[i] = i+1;
                }
            }
        }

        int result = -1;

        for(int i = 0; i < n; i++){
            if(i+1 > p)
                break;

            if(record[i] < user){
                result = rank[i];
                break;
            }

            if(record[i] == user){
                int j;
                for(j = i; j < n; j++){
                    if(record[j] != user)
                        break;
                }
                if(j >= p)
                    break;
                result = rank[i];
                break;
            }
        }

        if(n != 0 && p > n && result == -1){
            result = rank[n-1]+1;
        }
        if(n == 0){
            result = 1;
        }

        System.out.print(result);

    }
}
