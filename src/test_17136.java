import java.util.ArrayList;
import java.util.Scanner;

public class test_17136 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] paper = new int[10][10];

        ArrayList<Integer[]> arrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                paper[i][j] = scanner.nextInt();
                if(paper[i][j] == 1) {
                    Integer[] b = new Integer[2];
                    b[0] = i;
                    b[1] = j;
                    arrayList.add(b);
                }
            }
        }

        for(int i = 0; i < arrayList.size(); i++){
            Integer[] index = arrayList.get(i);

        }
    }

}
