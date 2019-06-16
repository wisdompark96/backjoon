public class summer_2018_3 {
    public static void main(String[] args){
        solution("LURDLURD");
    }
    public static int solution(String dirs) {
        int answer = 7;
        int[][][] map = new int[11][11][4];

        int x = 5, y = 5;

        //U:0,D:1,R:2,L:3
        int cnt = 0;
        for(int i = 0; i < dirs.length(); i++){
            char d = dirs.charAt(i);
            switch (d){
                case 'D':
                    if(x+1 < 11){
                        if(map[x+1][y][1] == 0){
                            cnt++;
                            map[x+1][y][1] = 1;
                            map[x][y][0] = 1;
                        }
                        x++;
                    }
                    break;
                case 'U':
                    if(x-1 >= 0){
                        if(map[x-1][y][0] == 0){
                            cnt++;
                            map[x-1][y][0] = 1;
                            map[x][y][1] = 1;
                        }
                        x--;
                    }
                    break;
                case 'R':
                    if(y+1 < 11){
                        if(map[x][y+1][2] == 0){
                            cnt++;
                            map[x][y+1][2] = 1;
                            map[x][y][3] = 1;
                        }
                        y++;
                    }
                    break;
                case 'L':
                    if(y-1 >= 0){
                        if(map[x][y-1][3] == 0){
                            cnt++;
                            map[x][y-1][3] = 1;
                            map[x][y][2] = 1;
                        }
                        y--;
                    }
                    break;
            }
        }

        answer = cnt;

        return answer;
    }
}
