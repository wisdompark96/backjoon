import java.util.*;

public class test_1766 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] cntB = new int[n+1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n+1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            list.get(a).add(b);
            cntB[b]++;
        }

        topologicalSort(cntB, list, n);
    }

    public static void topologicalSort(int[] cntB, ArrayList<ArrayList<Integer>> list, int n){
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 1; i < n+1; i++){
            if(cntB[i] == 0){
                queue.offer(i);

            }
        }

        for(int i = 0; i < n; i++){
            int num = queue.remove();
            System.out.print(num+" ");

            for(Integer j : list.get(num)){
                cntB[j]--;
                if(cntB[j] == 0)
                    queue.offer(j);
            }
        }
    }
}
