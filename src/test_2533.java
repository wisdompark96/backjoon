import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class test_2533 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Queue<node> queue = new LinkedList<>();
        int n = scan.nextInt();
        node[] list = new node[n];

        for(int i = 0; i < n; i++)
            list[i] = new node(i+1);

        for(int i = 0; i < n-1; i++){
            int p = scan.nextInt();
            int c = scan.nextInt();

            list[p-1].inputC(list[c-1]);
            list[c-1].inputC(list[p-1]);

        }

        node first = null;

        first = list[0];

        first.isAr = true;

        queue.offer(first);

        int sum = 1;
        int sum2 = 0;
        for(int i = 0; i < 2; i++) {
            node before = null;
            while (!queue.isEmpty()) {
                node p = queue.poll();
                int cnt = 0;
                for (int j = 0; j < p.child.size(); j++) {
                    if(!p.child.get(j).isVisit) {
                        queue.offer(p.child.get(j));
                        cnt++;
                    }
                }

                p.isVisit = true;
                if(before != null) {
                    if (!before.isAr) {
                        if (cnt != 0) {
                            p.isAr = true;
                            sum++;
                        } else {
                            before.isAr = true;
                            sum++;
                        }
                    }
                }
                for (int j = 0; j < p.child.size(); j++) {
                    if(p.child.get(j).isVisit) {
                        before = p.child.get(j);
                        break;
                    }
                }
            }
            if(i == 1)
                break;

            reset(list);
            queue.offer(first);
            sum2 = sum;
            sum = 0;
        }



        if(sum> sum2)
            System.out.print(sum2);
        else
            System.out.print(sum);
    }

    public static void reset(node[] nodes){

        for(int i = 0; i < nodes.length; i++) {
            nodes[i].isAr = false;
            nodes[i].isVisit = false;
        }
    }
    public static class node{
        int value;
        ArrayList<node> child ;
        boolean isAr;
        boolean isVisit;

        public node(int v){
            value = v;
            child = new ArrayList<>();
            isAr = false;
            isVisit = false;
        }


        public void inputC(node n){
            child.add(n);
        }
    }

}
