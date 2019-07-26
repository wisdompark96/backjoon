public class nbp_6 {
    public static void main(String[] args){
        String[]T = {"test1a", "test2", "test1b", "test1c", "test3"};
        String[]R = {"Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"};

        System.out.print(solution(T,R));

    }
    public static int solution(String[] T, String[] R) {

        int idx = 0;
        for(int i = 0; i < T[0].length(); i++){
            if(!Character.isDigit(T[0].charAt(i))){
                idx = i;
            } else
                break;
        }

        int[]tc = new int[T.length+1];

        int max = 1;
        for(int i = 0; i < T.length; i++){
            int num = Integer.parseInt(String.valueOf(T[i].charAt(idx+1)));
            max = Math.max(max, num);

            if(R[i].equals("OK") && tc[num] != -1)
                tc[num] = 1;
            else
                tc[num] = -1;
        }

        int cnt = 0;
        for(int i = 1; i <= max; i++){
            if(tc[i] == 1)
                cnt++;
        }

        if(cnt == 0)
            return 0;
        else
            return cnt*100/max;
    }
}
