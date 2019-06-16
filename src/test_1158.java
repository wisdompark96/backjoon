import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_1158 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list= new ArrayList<>();

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i = 0; i < k-1; i++){
                int a = queue.poll();
                queue.offer(a);
            }
            list.add(queue.poll());
        }
        System.out.print("<"+list.get(0));
        for(int i = 1; i < list.size(); i++){
            System.out.print(", "+list.get(i));
        }
        System.out.print(">");

    }
}
