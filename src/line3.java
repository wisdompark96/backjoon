import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class line3 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        build[] buildings = new build[num];

        for(int i = 0; i < num; i++){
            buildings[i] = new build(i,scanner.nextInt());
        }

        Arrays.sort(buildings, Collections.reverseOrder());

        System.out.print(Math.abs(buildings[0].index - buildings[1].index));
    }

    public static class build implements Comparable<build>{
        int index;
        int size;

        build(int index, int size){
            this.index = index;
            this.size = size;
        }

        @Override
        public int compareTo(build o) {
            return this.size - o.size;
        }
    }
}
