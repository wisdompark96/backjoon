import java.util.*;

public class test_16637 {
    /**
     * 비트 마스크를 사용 완전 탐색
     * @param args
     */
    static Queue<Integer> num;
    static Queue<Character> op;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        num = new LinkedList<>();
       op = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                num.offer(Integer.parseInt(String.valueOf(s.charAt(i))));
            } else {
                op.offer(s.charAt(i));
            }
        }
        int[] bucket = new int[op.size()];

        if(s.length() == 1)
            System.out.print(s);
        else
            System.out.print(recur(bucket, op.size(), s));
    }
    public static long recur(int[]bucket, int p, String s){
        long max = 0;

        if(p == 0){

            long result = getResult(bucket);
            return result;
        }

        int lastIndex = bucket.length-p-1;
        for(int i = 0; i < 2; i++){
            if(p == bucket.length){
                bucket[0] = i;
                max = Math.max(max, recur(bucket, p-1, s));
            } else if(bucket[lastIndex] != 1 || i != 1){
                bucket[lastIndex+1] = i;
                max = Math.max(max, recur(bucket, p-1, s));
            }

        }
        return max;
    }

    public static long getResult(int[] bucket){
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < bucket.length; i++){
            if(bucket[i] == 0){
                if(i == 0 || bucket[i-1] != 1){
                    int n = num.poll();
                    char c = op.poll();
                    if (stack.isEmpty()) {
                        stack.push(String.valueOf(n));
                        stack.push(String.valueOf(c));
                    } else {
                        String s = stack.pop();
                        long a = Long.parseLong(stack.pop());
                        stack.push(String.valueOf(calc(s, a, n)));
                        stack.push(String.valueOf(c));
                    }
                    num.offer(n);
                    op.offer(c);
                } else {
                    char c = op.poll();
                    stack.push(String.valueOf(c));
                    op.offer(c);
                }
            } else {
                int a = num.poll();
                char c = op.poll();
                int b = num.poll();
                long r = calc(String.valueOf(c),a,b);
                op.offer(c);
                num.offer(a);
                num.offer(b);
                if(stack.isEmpty())
                    stack.push(String.valueOf(r));
                else {
                    String p = stack.pop();
                    long n = Long.parseLong(stack.pop());
                    stack.push(String.valueOf(calc(p,n,r)));
                }
            }
        }
        long result = 0;
        if(stack.peek().equals("+") || stack.peek().equals("*") || stack.peek().equals("-")) {
            int n = num.poll();
            result = calc(stack.pop(), Long.parseLong(stack.pop()), n);
            num.offer(n);
        }
        else {
            result = Long.parseLong(stack.pop());
        }
        return result;
    }

    public static long calc(String op, long a, long b){
        switch (op){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
        }

        return 0;
    }
}
