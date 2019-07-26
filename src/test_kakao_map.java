import java.util.Stack;

public class test_kakao_map {
    public static void  main(String[] args){

        int[] arr1 = {1};
        int[] arr2 = {0};
        solution(1, arr1, arr2);

    }
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];

        for(int i = 0; i < arr1.length; i++){
            int sum = arr1[i] | arr2[i];
            System.out.println(sum);
            Stack<Integer> stack = new Stack<>();
            while(sum != 0){
                int r = sum%2;
                sum /= 2;
                if(r == 1){
                    stack.push(1);
                } else{
                    stack.push(0);
                }
            }

            while (stack.size() != n)
                stack.push(0);

            StringBuilder stringBuilder = new StringBuilder();
            while (!stack.empty()){
                if(stack.pop() == 1){
                    stringBuilder.append("#");
                } else{
                    stringBuilder.append(" ");
                }
            }

            answer[i] = stringBuilder.toString();

            System.out.println(answer[i]);
        }

        return answer;
    }
}
