import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class test201810 {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Stack<Integer>num = new Stack<>();
            Stack<String> op = new Stack<>();
            final int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                while (tokenizer.hasMoreTokens()) {
                    final String token = tokenizer.nextToken();
                    if(isNum(token)){
                        if(num.isEmpty())
                            num.push(Integer.parseInt(token));
                        else{

                        }
                    }
                    else{
                        if(op.isEmpty())
                            op.push(token);
                        switch (token){
                            case "*":
                                break;
                            case "(":
                                break;
                            case ")":
                                break;
                            case "/":
                                break;
                            case "+":
                                break;
                            case "-":
                                break;
                        }
                    }
                }
            }
        }
    }

    public static boolean isNum(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
