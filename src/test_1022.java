import java.util.*;

public class test_1022 {

    static Queue<Node> q;
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int e = scanner.nextInt();
        int b = scanner.nextInt();
        int s = scanner.nextInt();

        Node[] node = new Node[e];

        q = new LinkedList<>();
        for(int i = 0; i < e; i++) {
            node[i] = new Node(i+1);
        }

        for(int i = 0; i < b; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            node[x-1].add(node[y-1]);
            node[y-1].add(node[x-1]);
        }

        DFS(node[s-1]);
        System.out.println();
        BFS(node[s-1]);
    }

    public static void DFS(Node node){
        System.out.print(node.value+" ");
        node.isvisit = true;
        Collections.sort(node.list);
        for(int i = 0; i < node.list.size(); i++){
            if(!node.list.get(i).isvisit)
                DFS(node.list.get(i));
        }
    }

    public static void BFS(Node node){

        System.out.print(node.value+" ");
        node.isvisit = false;
//        Collections.sort(node.list);
        for(int i = 0; i < node.list.size(); i++) {
            if(node.list.get(i).isvisit){
                q.offer(node.list.get(i));
                node.list.get(i).isvisit = false;
            }
        }

        if(!q.isEmpty())
            BFS(q.poll());
    }

    public static class Node implements Comparable<Node>{
        ArrayList<Node> list;
        boolean isvisit ;
        int value ;
        public Node(int n){
            list = new ArrayList<>();
            isvisit = false;
            value = n;
         }
        public void add(Node n){
            list.add(n);
        }

        @Override
        public int compareTo(Node o) {
            if(value > o.value)
                return 1;
            else if(value < o.value)
                return -1;
            return 0;
        }
    }
}
