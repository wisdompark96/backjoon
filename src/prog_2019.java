import java.util.Stack;

public class prog_2019 {
    public static void main(String[] args){
        int[]s = {2,3,4,4,2,1,3,1};
        solution(s);

    }

    public static int solution(int[] s) {
        int answer = 0;
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        Stack<Integer> three = new Stack<>();

        for(int i = 0; i < s.length; i++){
            if(s[i] == 4)
                answer++;
            switch (s[i]){
                case 1:
                   if(!three.isEmpty()){
                       three.pop();
                       answer++;
                   }else {
                       if(one.size() == 1 && !two.isEmpty()){
                           one.pop();
                           two.pop();
                           answer++;
                       } else if(one.size() == 3){
                           while (!one.isEmpty()){
                               one.pop();
                           }
                           answer++;
                       } else {
                           one.push(s[i]);
                       }
                   }
                    break;
                case 2:
                    if(two.isEmpty())
                        two.push(s[i]);
                    else {
                        two.pop();
                        answer++;
                    }
                    break;
                case 3:
                    if(!one.isEmpty()){
                        one.pop();
                        answer++;
                    } else {
                        three.push(s[i]);
                    }
                    break;
            }
        }

        while(!one.isEmpty()){
            one.pop();
            answer++;
        }
        while (!two.isEmpty()){
            two.pop();
            answer++;
        }
        while (!three.isEmpty()){
            three.pop();
            answer++;
        }

        return answer;
    }
}
