import java.util.ArrayList;
import java.util.Stack;

public class prog_2019_2 {
    static ArrayList<String> result;
    public static void main(String[] args){

        solution(3);
    }

    public static String[] solution(int N) {
        String[] answer = {};
        result = new ArrayList<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int[] bucket = new int[N*2];
        recur(bucket, N*2, N*2);
        answer = result.toArray(new String[result.size()]);
        return answer;
    }

    public static void recur(int[] bucket, int p, int n){

        if(p == 0){
            if(isItRight(bucket)){
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0; i < bucket.length; i++){
                    if(bucket[i] == 0){
                        stringBuilder.append("(");
                    }else {
                        stringBuilder.append(")");
                    }
                }

                result.add(stringBuilder.toString());
            }

            return;
        }

        int lastIndex = n-p-1;

        for(int i = 0 ; i <= 1; i++){
            if(p == n){
                bucket[0] = i;
                recur(bucket, p-1, n);
            } else{
                bucket[lastIndex+1] = i;
                recur(bucket,p-1,n);
            }
        }
    }

    public static boolean isItRight(int[] array){

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < array.length; i++){
            if(array[i] == 0)
                stack.push(array[i]);
            else {
                if(stack.isEmpty() || stack.peek() != 0)
                    return false;
                else
                    stack.pop();
            }
        }

        if(!stack.isEmpty())
            return false;
        return true;
    }
}
