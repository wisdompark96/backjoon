import java.util.Arrays;

public class nbp_3 {
    public static void main(String[] args){
        int[] A = {-10,1,2,3};
        System.out.print(solution(A));
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.length-1; i++){
            min = Math.min(min, Math.abs(A[i+1] - A[i]));
        }

        return min;
    }

}
