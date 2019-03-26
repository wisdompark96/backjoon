import java.util.HashMap;
import java.util.Scanner;

public class test_4195 {
    static HashMap<String, Integer> indexMap;
    static int index;
    static int[] friends;
    static int[] size;

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int Tcase = scanner.nextInt();
        index = 0;
        for(int i = 0; i < Tcase; i++){
            indexMap = new HashMap<>();
            friends = new int[100001];
            size = new int[100001];
            int n = scanner.nextInt();
            for(int j = 0; j < n; j++){
                String f1 = scanner.next();
                String f2 = scanner.next();
                if(!indexMap.containsKey(f1)) {
                    indexMap.put(f1, index);
                    friends[index] = -1;
                    size[index++] = 1;
                }
                if(!indexMap.containsKey(f2)) {
                    indexMap.put(f2, index);
                    friends[index] = -1;
                    size[index++] = 1;
                }
                System.out.println(union(indexMap.get(f1), indexMap.get(f2)));
            }

        }
    }

    static int find(int x) {
        if (friends[x] == -1) {
            return x;
        } else {
            return friends[x] = find(friends[x]);
        }
    }
    static int union(int x, int y){
        // 각 원소가 속한 트리의 루트 노드를 찾는다.
        x = find(x);
        y = find(y);
        if(x != y) {
            size[x] += size[y];
            friends[y] = x;
        }
        return size[x];
    }
}
