public class winter_2018 {
    public static void main(String[] args){

        String[] skills = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.print(solution("CBD", skills));
    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (int i = 0; i < skill_trees.length; i++){
            int[] p = new int[skill.length()];
            String s = skill_trees[i];
            answer++;
            for(int j = 0; j < s.length(); j++){
                int idx = skill.indexOf(s.charAt(j));
                if(idx != -1){
                    if(idx != 0 && p[idx-1] == 0) {
                        answer--;
                        break;
                    } else {
                        p[idx] = 1;
                    }
                }
            }
        }

        return answer;

    }


}
