public class ebay_3 {
    public static void main(String[] args){

        int[] s = {3, 5, 6, 8, -1, -1, -1, 1, 7, -1, -1, -1, 4, -1, 2, -1, -1};
        System.out.print(solution(s));
    }
    public static boolean solution(int[] serialization) {
        boolean answer = true;

        int[] tree =  new int[10000];
        if(serialization[0] == -1)
            return true;
        else {
            tree[0] = serialization[0];
            int j = 0;
            for(int i = 1; i < serialization.length; i++){


                if(tree[(j+1)*2 -1] == 0) {
                    tree[(j + 1) * 2 - 1] = serialization[i];
                    if(serialization[i] == -1){
                        if(j % 2 == 0){
                            j = j/4+1;
                            continue;
                        }
                        else {
                            j = (j+1)*2 ;
                        }
                    } else
                        j = (j+1)*2 -1;
                }
                else{
                    return false;
                }

            }
        }
        return answer;
    }

}
