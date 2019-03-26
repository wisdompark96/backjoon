public class UnionFind {
    final int MAX_SIZE = 10;
    int[] root = new int[MAX_SIZE];
    void init() {
        for (int i = 0; i < MAX_SIZE; i++) {
            root[i] = i;
        }
    }

    /* find(x): 재귀 이용 */
    int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            // "경로 압축(Path Compression)"
            // find 하면서 만난 모든 값의 부모 노드를 root로 만든다.
            return root[x] = find(root[x]);
        }
    }
    void union(int x, int y){
        // 각 원소가 속한 트리의 루트 노드를 찾는다.
        x = find(x);
        y = find(y);

        root[y] = x;
    }
}
