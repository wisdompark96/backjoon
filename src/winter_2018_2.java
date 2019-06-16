public class winter_2018_2 {
    public static void main(String[] args){

        int[] i = {1,1,1,3,1,1,1};
        solution(i);
    }
    public static int solution(int[] cookie) {
        int answer = -1;
        int[] memoL = new int[cookie.length];
        int[] memoR = new int[cookie.length];

        int max = 0;

        if(cookie.length == 1)
            return 0;

        memoL[0] = cookie[0];
        memoR[cookie.length-1] = cookie[cookie.length-1];
        for(int i = 0; i < cookie.length-2; i++ ){
            for(int j = i; j < cookie.length-1; j++){
                if(memoL[j] != 0 && memoR[j+1] != 0){
                    if(i != 0 && memoL[j] - memoL[i-1] == memoR[j+1]){
                        max = Math.max(max, memoR[j+1]);
                    }
                    continue;
                }
                for(int k = i; k <= j; k++){
                    if(memoL[k] == 0){
                        memoL[k] += memoL[k-1] + cookie[k];
                    }
                }
                for(int h = cookie.length-1; h >= j+1; h--){
                    if(memoR[h] == 0){
                        memoR[h] += memoR[h+1] +cookie[h];
                    }
                }

                if(memoL[j] == memoR[j+1]){
                    max = Math.max(max, memoL[j]);
                }
            }
        }

        System.out.print(max);
        answer = max;
        return answer;
    }
}
