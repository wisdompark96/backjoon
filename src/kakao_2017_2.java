import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kakao_2017_2 {
    static  Queue<Integer[]> queue;
    static int[][] visit;
    static int[][] p;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] picture = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                picture[i][j] = scanner.nextInt();
            }
        }

        solution(m,n, picture);

    }
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        p = picture;
        queue = new LinkedList<>();
        visit = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visit[i][j] == 0 && picture[i][j] != 0){
                    numberOfArea++;
                    visit[i][j] = 1;
                    Integer[] ind = new Integer[2];
                    ind[0] = i;
                    ind[1] = j;
                    queue.offer(ind);
                    int sum = 1;
                    while (!queue.isEmpty()){
                        Integer[] index = queue.poll();
                        int x = index[0];
                        int y = index[1];

                        if(x+1 < m && picture[x+1][y] == picture[x][y] && visit[x+1][y] == 0){
                            Integer[] b = new Integer[2];
                            b[0] = x+1;
                            b[1] = y;
                            visit[x+1][y] = 1;
                            sum++;
                            queue.offer(b);
                        }

                        if(x-1 >= 0 && picture[x-1][y] == picture[x][y] && visit[x-1][y] == 0){
                            Integer[] b = new Integer[2];
                            b[0] = x-1;
                            b[1] = y;
                            visit[x-1][y] = 1;
                            sum++;
                            queue.offer(b);
                        }

                        if(y+1 < n && picture[x][y+1] == picture[x][y] && visit[x][y+1] == 0){
                            Integer[] b = new Integer[2];
                            b[0] = x;
                            b[1] = y+1;
                            visit[x][y+1] = 1;
                            sum++;
                            queue.offer(b);
                        }

                        if(y-1 >= 0 && picture[x][y-1] == picture[x][y]&& visit[x][y-1] == 0){
                            Integer[] b = new Integer[2];
                            b[0] = x;
                            b[1] = y-1;
                            visit[x][y-1] = 1;
                            sum++;
                            queue.offer(b);
                        }
                    }

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sum);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.print(numberOfArea+","+maxSizeOfOneArea);
        return answer;
    }


}
