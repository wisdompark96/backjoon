public class ebay_2 {
    public static void main(String[] args){

        System.out.print(solution("AB", "ABAB"));
    }
    public static boolean solution(String s, String t) {
        boolean answer = true;

        if(s.length() > t.length()){
            int j = 0;
            for(int i = 0; i< s.length(); i++){
                if(s.charAt(i) != t.charAt(j))
                    return false;
                if(j == t.length()-1)
                    j = 0;
                else
                    j++;
            }
        } else if(s.length() < t.length()){
            int j = 0;
            for(int i = 0; i < t.length(); i++){
                if(t.charAt(i) != s.charAt(j))
                    return false;
                if(j == s.length()-1)
                    j = 0;
                else
                    j++;
            }
        } else{
            if(!s.equals(t))
                return false;
        }

        return answer;
    }
}
