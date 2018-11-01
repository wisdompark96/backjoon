import java.util.*;

public class kakao2 {
    public static void main(String[] args){

        int[] stage = {2, 1, 2, 6, 2, 4, 3, 3};
        solutiion(5,stage);
    }
    public static int[] solutiion(int N, int[] stages){
        int[] answer = new int[N];

        HashMap<Integer, Double> hashMap = new HashMap<>();
        for(int i = 1; i < N+1; i++){
            int total = 0;
            int fail = 0;
            for(int j = 0; j < stages.length; j++){
                if(i < stages[j])
                    total++;
                else if(i == stages[j]) {
                    fail++;
                    total++;
                }
            }
            double value ;
            if(total == 0)
                value = 0;
            else
                value = (double)fail/total;
            hashMap.put(i, value);
        }

        Iterator iter= sort(hashMap).iterator();

        int j = 0;
        while(iter.hasNext()){
            answer[j] = (int)iter.next();
            j++;
        }

        return answer;
    }

    public static ArrayList<Integer> sort(HashMap map){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(map.keySet());

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v2).compareTo(v1);
            }
        });

        return list;
    }

}
