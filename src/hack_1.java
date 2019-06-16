import java.util.ArrayList;
import java.util.Scanner;

public class hack_1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int  n = scanner.nextInt();
        int[] list= new int[n];

        for(int i = 0; i < n; i++){
            list[i] = scanner.nextInt();
        }

        System.out.print(solution(list));

    }
    public static int solution(int[] T){

        ArrayList<Integer> winter = new ArrayList<>();
        winter.add(0);
        int max = 0;
        for(int i = 1; i < T.length; i++){
            if(T[0] < T[i]){
                if(T[max] < T[i]) {

                    for(int j = T.length-1; j > max; j--){
                        if(T[j] < T[i]){
                            i = j;
                            max = i;
                            break;
                        }
                    }
                    return max+1;
                }
            }
            else {
            }
        }
        return max+1;
    }
}
