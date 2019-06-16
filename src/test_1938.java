import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test_1938 {

    static Queue<Wood> queue;
    static Set<String> set ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        String[][] forest = new String[n][n];
        set = new HashSet<>();

        int cnt = 0;
        int eCnt = 0;
        Wood wood = new Wood();

        int eTX = 0, eTY = 0, eMX = 0, eMY = 0, eBX =0, eBY = 0;

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                forest[i][j] = String.valueOf(str.charAt(j));

                if(forest[i][j].equals("B")){
                    switch (cnt){
                        case 0:
                            wood.tx = i;
                            wood.ty = j;
                            cnt++;
                            break;
                        case 1:
                            wood.mx = i;
                            wood.my = j;
                            cnt++;
                            break;
                        case 2:
                            wood.bx = i;
                            wood.by = j;
                            cnt++;
                            break;
                    }
                }

                if(forest[i][j].equals("E")){
                    switch (eCnt){
                        case 0:
                            eTX = i;
                            eTY = j;
                            eCnt++;
                            break;
                        case 1:
                            eMX = i;
                            eMY = j;
                            eCnt++;
                            break;
                        case 2:
                            eBX = i;
                            eBY = j;
                            eCnt++;
                            break;
                    }

                }
            }
        }

        int result = 0;
        queue.offer(wood);
        set.add(wood.tx+","+wood.ty+","+wood.mx+","+wood.my+","+wood.bx+","+wood.by);
        while(!queue.isEmpty()){
            Wood w = queue.poll();

            if(w.tx == eTX && w.ty == eTY && w.mx == eMX && w.my == eMY && w.bx == eBX && w.by == eBY){
                result = w.depth;
                break;
            }

            for(int i = 0; i < 5; i++){
                switch (i){
                    case 0:
                        if(w.tx == w.bx && w.bx == w.mx) {
                            if (w.tx - 1 >= 0 && !forest[w.tx - 1][w.ty].equals("1") &&
                                    w.mx - 1 >= 0 && !forest[w.mx - 1][w.my].equals("1") &&
                                    w.bx - 1 >= 0 && !forest[w.bx - 1][w.by].equals("1")) {
                                move(i, w);
                            }
                        } else{
                            if(w.tx - 1 >= 0 && !forest[w.tx-1][w.ty].equals("1")){
                                move(i, w);
                            }
                        }
                        break;
                    case 1:
                        if(w.tx == w.bx && w.bx == w.mx) {
                            if (w.tx + 1 < n && !forest[w.tx + 1][w.ty].equals("1") &&
                                    w.mx + 1 < n && !forest[w.mx + 1][w.my].equals("1") &&
                                    w.bx + 1 < n && !forest[w.bx + 1][w.by].equals("1")) {
                                move(i, w);
                            }
                        } else{
                            if(w.bx + 1 < n && !forest[w.bx + 1][w.by].equals("1"))
                                move(i, w);
                        }
                        break;
                    case 2:
                        if(w.tx == w.bx && w.bx == w.mx) {
                            if(w.ty - 1 >= 0 && !forest[w.tx][w.ty-1].equals("1")){
                                move(i, w);
                            }

                        } else {
                            if(w.ty - 1 >= 0 && !forest[w.tx][w.ty-1].equals("1") &&
                                    w.my - 1 >= 0 && !forest[w.mx][w.my-1].equals("1") &&
                                    w.by - 1 >= 0 && !forest[w.bx][w.by-1].equals("1")){
                                move(i, w);
                            }
                        }
                        break;
                    case 3:
                        if(w.tx == w.bx && w.bx == w.mx) {
                            if(w.by + 1 < n && !forest[w.bx][w.by+1].equals("1")){
                                move(i, w);
                            }
                        } else {
                            if(w.ty + 1 < n && !forest[w.tx][w.ty+1].equals("1") &&
                                    w.my + 1 < n && !forest[w.mx][w.my+1].equals("1") &&
                                    w.by + 1 < n && !forest[w.bx][w.by+1].equals("1")){
                                move(i, w);
                            }
                        }
                        break;
                    case 4:
                        if(w.tx == w.bx && w.bx == w.mx) {
                            if(w.tx - 1 >= 0 && !forest[w.tx - 1][w.ty].equals("1") &&
                                    w.mx - 1 >= 0 && !forest[w.mx - 1][w.my].equals("1") &&
                                    w.bx - 1 >= 0 && !forest[w.bx - 1][w.by].equals("1") &&
                                    w.tx + 1 < n && !forest[w.tx + 1][w.ty].equals("1") &&
                                    w.mx + 1 < n && !forest[w.mx + 1][w.my].equals("1") &&
                                    w.bx + 1 < n && !forest[w.bx + 1][w.by].equals("1")){
                                move(i, w);
                            }
                        } else {
                            if(w.ty - 1 >= 0 && !forest[w.tx][w.ty-1].equals("1") &&
                                    w.my - 1 >= 0 && !forest[w.mx][w.my-1].equals("1") &&
                                    w.by - 1 >= 0 && !forest[w.bx][w.by-1].equals("1") &&
                                    w.ty + 1 < n && !forest[w.tx][w.ty+1].equals("1") &&
                                    w.my + 1 < n && !forest[w.mx][w.my+1].equals("1") &&
                                    w.by + 1 < n && !forest[w.bx][w.by+1].equals("1")){
                                move(i, w);
                            }
                        }
                        break;
                }
            }
        }

        System.out.print(result);
    }

    public static void move(int dir, Wood wood){

        int tx = wood.tx;
        int ty = wood.ty;
        int mx = wood.mx;
        int my = wood.my;
        int bx = wood.bx;
        int by = wood.by;

        switch (dir){
            case 0:
                if (set.add((tx-1)+","+ty+","+(mx-1)+","+my+","+(bx-1)+","+by)) {
                    tx--;
                    mx--;
                    bx--;
                    Wood w = new Wood(tx,ty,mx,my,bx,by,wood.depth+1);
                    queue.offer(w);
                }
                return;
            case 1:
                if (set.add((tx+1)+","+ty+","+(mx+1)+","+my+","+(bx+1)+","+by)) {
                    tx++;
                    mx++;
                    bx++;
                    Wood w = new Wood(tx,ty,mx,my,bx,by,wood.depth+1);
                    queue.offer(w);
                }
                return;
            case 2:
                if (set.add(tx+","+(ty-1)+","+mx+","+(my-1)+","+bx+","+(by-1))) {
                    ty--;
                    my--;
                    by--;
                    Wood w = new Wood(tx,ty,mx,my,bx,by,wood.depth+1);
                    queue.offer(w);
                }
                return;
            case 3:
                if (set.add(tx+","+(ty+1)+","+mx+","+(my+1)+","+bx+","+(by+1))) {
                    ty++;
                    my++;
                    by++;
                    Wood w = new Wood(tx,ty,mx,my,bx,by,wood.depth+1);
                    queue.offer(w);
                }
                return;
            case 4:
                if(tx == mx && mx == bx){
                    if(set.add((mx+1)+","+my+","+mx+","+my+","+(mx+1)+","+my)){
                        tx = mx-1;
                        ty = my;
                        bx = mx+1;
                        by = my;
                        Wood w = new Wood(tx,ty,mx,my,bx,by,wood.depth+1);
                        queue.offer(w);
                    }
                } else {
                    if(set.add(mx+","+(my-1)+","+mx+","+my+","+mx+","+(my+1))){
                        tx = mx;
                        ty = my-1;
                        bx = mx;
                        by = my+1;
                        Wood w = new Wood(tx,ty,mx,my,bx,by,wood.depth+1);
                        queue.offer(w);
                    }
                }
        }
    }

    public static class Wood{
        int tx;
        int ty;
        int mx;
        int my;
        int bx;
        int by;
        int depth;

        public Wood(int tx, int ty, int mx, int my, int bx, int by, int depth) {
            this.tx = tx;
            this.ty = ty;
            this.mx = mx;
            this.my = my;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }

        public Wood(){

        }
    }
}
