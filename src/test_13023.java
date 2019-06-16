import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class test_13023 {
    static boolean ans ;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Node[] nodes = new Node[n];
        for(int i = 0; i < n; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            nodes[x].list.add(nodes[y]);
            nodes[y].list.add(nodes[x]);
        }

        ans = false;
        for(int i = 0; i < n; i++){
            if(nodes[i].list.size() != 0 ) {
                HashSet<Integer> set = new HashSet<>();
                set.add(nodes[i].value);
                dfs(nodes[i], set);

                if(ans){
                    System.out.print(1);
                    return;
                }

            }
        }

        System.out.print(0);
    }

    public static void dfs(Node node, HashSet<Integer> set){
        int max = 0;
        if(set.size() >= 5) {
            ans = true;
            return;
        }

        for(Node n : node.list){
            if(set.add(n.value)){
                dfs(n, set);
            }
        }

        set.remove(node.value);
    }
    public static class Node{
        int value;
        ArrayList<Node> list;

        public Node(int value){
            this.value = value;
            list = new ArrayList<>();
        }
    }
}
