import java.util.Scanner;

public class test_9933 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String[] pwd = new String[n];
        String[] reverse = new String[n];

        for(int i = 0; i < n; i++){
            pwd[i] = scanner.next();
            StringBuffer stringBuffer = new StringBuffer(pwd[i]);
            reverse[i] = stringBuffer.reverse().toString();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(reverse[i].equals(pwd[j])) {
                    System.out.print(pwd[j].length() + " " + pwd[j].charAt(pwd[j].length() / 2));
                    return;
                }
            }
        }
    }
}
