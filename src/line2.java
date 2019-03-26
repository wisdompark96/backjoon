import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class line2{
    public static void main(String args[]){

        HashMap<String, String> table1 = new HashMap<>();
        HashMap<String, String> table2 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int columnNum1 = scanner.nextInt();

        String[] keys = new String [columnNum1-1];
        String header1 = scanner.nextLine();
        System.out.println(header1);
        /*int size1 = header1.split(" ").length;
        for(int i = 0; i < columnNum1-1; i++){
            String[] column = scanner.nextLine().split(" ");
            String value = "";
            for(int j = 1; j < size1; j++){
                value += column[j]+" ";
            }
            keys[i] = column[0];
            table1.put(column[0], value);
        }

        int columnNum2 = scanner.nextInt();
        String[] header2 = scanner.next().split(" ");
        for(String str : header2){
            if(!str.equals("id")){
                header1 += " "+ str;
            }
        }
        int size2 = header2.length;
        for(int i = 0; i < columnNum2-1; i++){
            String[] column = scanner.next().split(" ");
            String value = "";
            for(int j = 1; j < size2; j++){
                value += column[j]+" ";
            }
            table2.put(column[0], value);
        }*/

        System.out.println(header1);

//        for(int i = 0; i < keys.length; i++){
//            System.out.print(keys[i]+" ");
//            System.out.print(table1.get(keys[i]));
//            if(table2.get(keys[i]) == null){
//                for(int j = 0; j < size2-1; j++){
//                    System.out.print("NULL ");
//                }
//            }
//            else {
//                System.out.print(table2.get(keys[i]));
//
//            }

//        }

    }
}