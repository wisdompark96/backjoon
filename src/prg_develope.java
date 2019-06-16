import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class prg_develope {
    public static void main(String[] args){

        int[] prog = {95,70,10,5,3,2};
        int[] spped = {4,10,10,10,10,10};
        solution(prog, spped);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answers = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++){
            int sum = progresses[i];
            int cnt = 0;
            while(sum < 100){
                sum += speeds[i];
                cnt++;
            }
            arrayList.add(cnt);
        }

        stack.push(arrayList.remove(0));

        while(!stack.isEmpty()) {
            int dday = stack.pop();
            int cnt = 1;
            for (int i = 0; i < arrayList.size(); i++) {
                if(arrayList.get(i) <= dday) {
                    cnt++;
                    arrayList.remove(i);
                    i--;
                }
                else
                    break;
            }

            answers.add(cnt);
            if(arrayList.size() != 0)
                stack.push(arrayList.remove(0));
        }

        answer = new int[answers.size()];

        for(int i = 0; i < answers.size(); i++) {
            answer[i] = answers.get(i);
            System.out.print(answer[i]);
        }

        return answer;
    }
}
