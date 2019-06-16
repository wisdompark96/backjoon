import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class test_1764 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> see = new ArrayList<>();
        ArrayList<String> hearSee = new ArrayList<>();

        for(int i = 0; i < n; i++){
            map.put(scanner.next(), i);
        }
        for(int i = 0; i < m; i++){
            see.add(scanner.next());
        }

        for(int i = 0; i < m; i++){
            if(map.get(see.get(i)) != null)
                hearSee.add(see.get(i));
        }

        Collections.sort(hearSee);
        System.out.println(hearSee.size());
        for(int i = 0; i < hearSee.size(); i++)
            System.out.println(hearSee.get(i));
    }
}
