import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class test_kakao_lru {
    static ArrayList<String> cache;
    static int cs = 0;

    public static void main(String[] args){
        String[] city = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        solution(3, city);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        cache = new ArrayList<>();
        cs = cacheSize;
        int cnt = 0;
        for(int i = 0; i < cities.length; i++){
            if(calcCache(cities[i])){
                cnt++;
            } else{
                cnt += 5;
            }
        }

        System.out.print(cnt);
        return answer;
    }

    public static boolean calcCache(String city){
         for (int i = 0; i < cache.size(); i++) {
                if (cache.get(i).equalsIgnoreCase(city)) {
                    cache.remove(i);
                    cache.add(0, city);
                    return true;

                }
            }

        if(cache.size() >= cs)
            cache.remove(cache.size()-1);
        cache.add(0, city);
        return false;
    }

}
