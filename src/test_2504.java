import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class test_2504 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        String str = scanner.next();
        for(int i = 0; i < str.length(); i++){
            String c = String.valueOf(str.charAt(i));
            if(c.equals("(") || c.equals("["))
                stack.push(c);
            else if(c.equals(")")){
                if(stack.empty()){
                    System.out.print(0);
                    return;
                }
                if(isStringDouble(stack.peek())){
                    int sum = 0;
                    while(!stack.empty()){
                        if(stack.peek().equals("(")) {
                            stack.pop();
                            break;
                        }
                        if(isStringDouble(stack.peek()))
                            sum += Integer.parseInt(stack.pop());
                        else{
                            System.out.print(0);
                            return;
                        }
                    }
                    stack.push(String.valueOf(sum*2));
                } else if(stack.peek().equals("(")){
                    stack.pop();
                    stack.push(String.valueOf(2));
                } else {
                    System.out.print(0);
                    return;
                }
            } else if(c.equals("]")) {
                if(stack.empty()){
                    System.out.print(0);
                    return;
                }
                if(isStringDouble(stack.peek())){
                    int sum = 0;
                    while(!stack.empty()){
                        if(stack.peek().equals("[")) {
                            stack.pop();
                            break;
                        }
                        if(isStringDouble(stack.peek()))
                            sum += Integer.parseInt(stack.pop());
                        else{
                            System.out.print(0);
                            return;
                        }
                    }
                    stack.push(String.valueOf(sum*3));
                } else if(stack.peek().equals("[")){
                    stack.pop();
                    stack.push(String.valueOf(3));
                } else {
                    System.out.print(0);
                    return;
                }
            }
        }

        int sum = 0;
        while(!stack.empty()){
            if(!isStringDouble(stack.peek())){
                System.out.print(0);
                return;
            }
            sum += Integer.parseInt(stack.pop());
        }
        System.out.print(sum);

    }

    public static boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
