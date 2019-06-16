import java.util.Scanner;
import java.util.StringTokenizer;

public class test_9996 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String pattern = scanner.next();
        String front = "";
        String back = "";

        String[] files = new String[n];
        for(int i = 0; i < pattern.indexOf("*"); i++){
            front += String.valueOf(pattern.charAt(i));
        }

        for(int i = pattern.indexOf("*")+1; i < pattern.length(); i++){
            back += String.valueOf(pattern.charAt(i));
        }

        for(int i = 0; i < n; i++){
            String file = scanner.next();
            files[i] = file;
        }

        for(int i = 0; i < n; i++){
            if(front.length()+back.length() > files[i].length()) {
                System.out.println("NE");
                continue;
            }
            String fF = "";
            String fB = "";
            for(int j = 0; j < files[i].length(); j++){
                if(j < front.length() ) {
                    fF += files[i].charAt(j);
                }
                else if(j >= files[i].length()-back.length()){
                    fB += String.valueOf(files[i].charAt(j));
                }
            }

            if(fF.equals(front) && fB.equals(back))
                System.out.println("DA");
            else
                System.out.println("NE");
        }
    }
}
