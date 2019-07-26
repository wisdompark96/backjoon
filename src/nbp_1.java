public class nbp_1 {
    public static void main(String[] args){

        int[] A = {-1,-3};
        System.out.print(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        // 0 = flat, 1 = hill, 2 = valley
        int flag = 0;
        int cnt = 1;
        for(int i = 0; i < A.length; i++){
            if(i == 0 ){
               continue;
            }

            if(A[i-1] < A[i]){
                if(flag == 0 || flag == 1)
                    cnt++;
                flag = 2;
            } else if(A[i-1] > A[i]){
                if(flag == 0 || flag == 2)
                    cnt++;
                flag = 1;
            }
        }

        return cnt;
    }
}
