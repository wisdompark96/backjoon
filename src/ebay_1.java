import java.util.Scanner;

public class ebay_1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] price = {3, 2, 4, 8, 7};
        System.out.print(solution(price));

    }

    public static int solution(int[] prices) {
        int answer = 6;

        int[] bucket = new int[2];
        answer = recur(bucket, prices, 2);

        return answer;
    }

    public static int recur(int[] bucket, int[] price, int p){
        int max = 0;

        if(p == 0){
            return price[bucket[1]] - price[bucket[0]];
        }

        int lastIndex = bucket.length - p -1;

        for(int i = 0; i < price.length; i++){
            if(p == bucket.length ){
                if(i == price.length-1)
                    break;
                bucket[0] = i;
                max = Math.max(recur(bucket, price, p-1), max);
            } else if(bucket[lastIndex] < i && price[bucket[lastIndex]] < price[i]){
                bucket[lastIndex+1] = i;
                max = Math.max(recur(bucket, price, p-1), max);
            }
        }

        return max;
    }
}
