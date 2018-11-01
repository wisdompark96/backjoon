import java.util.ArrayList;
import java.util.Scanner;

public class test_2533 {
    static node[] tree;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        tree = new node[n];

        for(int i = 0; i < n; i++){
            tree[i] = new node();
        }

        for(int i = 0; i < n-1; i++){
            int p = scanner.nextInt();
            int c = scanner.nextInt();

            tree[p-1].addChild(tree[c-1]);
            tree[c-1].addParent(tree[p-1]);
        }

        ArrayList<node> p = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(tree[i].p == null)
                p.add(tree[i]);
        }

        int sum = 0;
        for(int i = 0; i < p.size(); i++)
            sum += findNum(p.get(i));
        System.out.print(sum);
    }

    public static int findNum(node Node){

        int sum = 0;
        if(Node.child.size() != 0){

            for(int i = 0; i < Node.child.size(); i++ ){
                node child = Node.child.get(i);
                sum += findNum(child);

                if(!child.isred) {
                    Node.setIsred();
                }
            }
        }
        else{
            return 0;
        }

        if(Node.isred)
            sum++;

        return sum;


    }

    public static class node{
        boolean isred;
        ArrayList<node> child;
        node p;
        public node(){
            isred = false;
            child = new ArrayList<>();
        }

        void setIsred(){
            isred = true;
        }

        void addChild(node n){
            child.add(n);
        }

        void addParent(node n){
            p = n;
        }



    }
}
