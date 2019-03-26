import java.util.ArrayList;
import java.util.Scanner;

public class line {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> str = new ArrayList<>();
        ArrayList<Character> num = new ArrayList<>();
        String a = sc.next();

        for(int i = 0; i < a.length(); i++){
            if(Character.isUpperCase(a.charAt(i))){
                str.add(String.valueOf(a.charAt(i)));
            }
            if(Character.isLowerCase(a.charAt(i))){
                str.set(str.size()-1, String.valueOf(str.get(str.size()-1) + a.charAt(i)));
            }
            if(Character.isDigit(a.charAt(i))){
                num.add(a.charAt(i));
            }
        }

        if(str.size() != num.size())
            System.out.print("error");
        else{
            for(int i = 0; i < str.size(); i++){
                System.out.print(str.get(i));
                if(num.get(i) != '1')
                    System.out.print(num.get(i));
            }
        }

    }

}
