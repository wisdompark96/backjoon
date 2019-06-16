import java.util.Scanner;
import java.util.Stack;

public class test_1918 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Stack<Character> oper = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(Character.isUpperCase(str.charAt(i))){
                System.out.print(str.charAt(i));
            }
            else {
                int p = getPriority(str.charAt(i));
                switch (str.charAt(i)){
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while(!oper.isEmpty() && getPriority(oper.peek()) >= p){
                             System.out.print(oper.pop());
                        }
                        oper.push(str.charAt(i));
                        break;
                    case '(':
                        oper.push('(');
                        break;
                    case ')':
                        while (!oper.isEmpty() && oper.peek() != '(')
                            System.out.print(oper.pop());
                        if(!oper.isEmpty())
                            oper.pop();
                }
            }
        }

        while (!oper.isEmpty())
            System.out.print(oper.pop());
    }

    public static int getPriority(Character c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }
}
