import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class test_10799 {
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stack<Character> stack = new Stack<>();
        int sum = 0;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                stack.push('(');
            else{
                if(str.charAt(i-1) == '('){
                    stack.pop();
                    sum += stack.size();
                }
                else{
                    stack.pop();
                    sum++;
                }

            }
        }

        System.out.print(sum);
    }

}
