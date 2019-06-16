public class summer_2018_2 {
    public static void main(String[] args){
        int[] price = {1, 2, 3, 2, 3};
        solution(price);
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            answer[i] = 0;
            for(int j = i+1; j < prices.length; j++){
                answer[i]++;
                if(prices[i] > prices[j])
                    break;
            }
        }

        return answer;
    }
}
