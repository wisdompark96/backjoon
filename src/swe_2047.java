import java.util.Scanner;

public class swe_2047 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        for(int i = 0; i < str.length(); i++){
            if(Character.isLowerCase(str.charAt(i))){
                System.out.print(Character.toUpperCase(str.charAt(i)));
            } else{
                System.out.print(str.charAt(i));
            }
        }
    }
}
