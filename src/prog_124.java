import java.util.Scanner;

public class prog_124 {
    static StringBuilder ans ;
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        //int n = scanner.nextInt();

        for(int i = 1; i <= 40; i++) {
            solution(i);
            ans.setLength(0);
        }
    }

    public static String solution(int n) {
        String answer = "";

        ans = new StringBuilder();
        recur(n);
        answer = ans.toString();
        System.out.println(answer);
        return answer;
    }


    public static void recur(int n){

        if(n == 0){
            return;
        }

        if(n%3 == 0) {
            recur(n/3 - 1);
            ans.append(4);
        }
        else {
            recur(n/3 );
            ans.append(n%3);
        }
    }
}
