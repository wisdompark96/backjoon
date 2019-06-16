import java.util.Scanner;

public class hack_3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = scanner.nextInt();
        }
        System.out.print(solution(A));
    }

    public static int solution(int[] A){
        int[] dice = new int[6];

        int max = A[0]-1;
        for(int i = 0; i < A.length; i++){
            dice[A[i]-1]++;
            if(dice[max] < dice[A[i]-1]){
                max = A[i]-1;
            }
        }
        int sum = 0;

        if(dice[max] == 1){
            int p = A[0]-1;
           if(dice[0]+dice[5] == 1){
               if(dice[0] != 0)
                   p = 0;
               else
                   p = 5;
           }

           if(dice[1] + dice[4] == 1){
               if(dice[1] != 0)
                   p = 1;
               else
                   p = 4;
           }

           if(dice[2] + dice[3] == 1){
               if(dice[2] != 0)
                   p = 2;
               else
                   p = 3;
           }

           for(int i = 0; i < A.length; i++){
               if(A[i] == p+1)
                   continue;
               else{
                   if(p+1 + A[i] == 7)
                       sum = sum+2;
                   else
                       sum++;
               }
           }
        }
        else{

            for(int i = 0; i < A.length; i++){
                if(A[i] == max+1)
                    continue;
                else{
                    if(max+1 + A[i] == 7)
                        sum = sum + 2;
                    else
                        sum++;
                }
            }
        }
        return sum;
    }
}
