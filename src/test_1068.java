import java.util.Scanner;

public class test_1068 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nodes = new int[n];

        int root = 0;
        for(int i = 0; i < n; i++){
            nodes[i] = scanner.nextInt();
            if(nodes[i] == -1)
                root = i;
        }

        int m = scanner.nextInt();

        System.out.print(getReef(root, m, nodes));

    }

    public static int getReef(int node, int m, int[] nodes){
        int sum = 0;
        if(node == m)
            return 0;
        boolean reef = true;
        for(int i = 0; i < nodes.length; i++){
            if(nodes[i] == node && i != m) {
                sum += getReef(i, m, nodes);
                reef = false;
            }
        }
        if(reef)
            sum++;
        return sum;
    }
}
