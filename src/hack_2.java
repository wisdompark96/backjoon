import java.util.ArrayList;
import java.util.Stack;

public class hack_2 {
    Stack<Tree> stack;
    public static void main(String[] args){

        Tree a = new Tree();
        Tree b = new Tree();
        Tree c = new Tree();
        Tree d = new Tree();
        Tree e = new Tree();
        Tree f = new Tree();
        Tree g = new Tree();

        a.x = 4;
        b.x = 5;
        c.x = 6;
        d.x = 4;
        g.x = 5;
        e.x = 1;
        f.x = 6;

        a.l = b;
        a.r = c;
        b.l = d;
        d.l = g;
        c.l = e;
        c.r = f;

        System.out.print(solution(a));

    }

    public static int solution(Tree T) {
        // write your code in Java SE 8
        ArrayList<Integer>nodes = new ArrayList<>();
        return dfs(T, nodes);
    }
    public static int dfs(Tree t, ArrayList<Integer> nodes){

        int max = 0;
        if(nodes.size() != 0) {
            for (int i = 0; i < nodes.size(); i++) {
                if(nodes.get(i) == t.x)
                    return 0;
            }
            nodes.add(t.x);
        }
        else
            nodes.add(t.x);

        if(t.l == null) {
            int s = nodes.size();
            nodes.remove(s-1);
            return s;
        }
        else
            max = Math.max(max, dfs(t.l, nodes));
        if(t.r == null) {
            int s = nodes.size();
            nodes.remove(s-1);
            return s;
        }
        else
            max = Math.max(max, dfs(t.r, nodes));

        nodes.remove(nodes.size()-1);
        return max;
    }

    public static class Tree{
        public int x;
        public Tree l;
        public Tree r;
    }
}
