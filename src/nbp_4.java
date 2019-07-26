import java.util.ArrayList;

public class nbp_4 {
    public static void main(String[] args){

        int[] T = {-1,-1,-1,-1,-1, 12};
        System.out.print(solution(T));
    }

    public static int solution(int[] T){

        int max = 0;
        for(int i = 1; i < T.length-1; i++){
            if(T[0] < T[i]){
                if(T[max] < T[i]) {
                    max = i;
                    boolean flag = false;
                    for(int j = T.length-1; j > max; j--){
                        if(T[j] < T[max] ){
                            i = j;
                            flag = true;
                            break;
                        }
                    }

                    if(!flag)
                        return i;

                }
            }
        }
        if(max == 0)
            max = T.length-1;
        return max;
    }
}
