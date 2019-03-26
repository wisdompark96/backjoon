import java.util.ArrayList;
import java.util.Scanner;

public class test_1717 {
    public static final int MAX_SIZE = 1000000;
    static int[] root ;

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<String> result = new ArrayList<>();

        root = new int[n+1];

        for(int i = 0; i <= n; i++){
            root[i] = i;
        }

        for(int i = 0; i < m; i++){
            int calc = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if(calc == 0){
                union(x, y);
            }
            else{
                if(find(x) == find(y)){
                    result.add("YES");
                }
                else
                    result.add("NO");
            }
        }

        for(int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));

    }

    public static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            // "경로 압축(Path Compression)"
            // find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
            return root[x] = find(root[x]);
        }
    }

    public static void union(int x, int y){
        // 각 원소가 속한 트리의 루트 노드를 찾는다.
        x = find(x);
        y = find(y);

        if(x != y){
            root[y] = x;
        }
    }
}
