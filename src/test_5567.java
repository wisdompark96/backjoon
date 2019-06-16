import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class test_5567 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Node[] list = new Node[n];
        for(int i = 0; i < n; i++){
            list[i] = new Node(i+1);
        }

        for(int i = 0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            list[a-1].child.add(list[b-1]);
            list[b-1].child.add(list[a-1]);
        }


        ArrayList<Integer> friends = new ArrayList<>();

        for(int i = 0; i < list[0].child.size(); i++){
            friends.add(list[0].child.get(i).num);
        }

        int size = friends.size();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < list[friends.get(i)-1].child.size(); j++){
                if(!friends.contains(list[friends.get(i)-1].child.get(j).num) && list[friends.get(i)-1].child.get(j).num != 1)
                    friends.add(list[friends.get(i)-1].child.get(j).num);
            }
        }

        System.out.print(friends.size());

    }

    public static class Node{
        ArrayList<Node> child;
        int num;

        public Node(int num){
            child = new ArrayList<>();
            this.num = num;
        }
    }
}
