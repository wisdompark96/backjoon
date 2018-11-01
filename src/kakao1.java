import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class kakao1 {
    public static void main(String[] args){

        String[] record={"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Change uid4567 C", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        solution(record);
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        String[] command = new String[record.length];
        String[] id = new String[record.length];

        HashMap<String,String> uid = new HashMap<>();


        for(int i = 0; i < record.length; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(record[i]);
            command[i] = stringTokenizer.nextToken();
            id[i] = stringTokenizer.nextToken();

            if(command[i].equals("Enter") || command[i].equals("Change")){
                String c = stringTokenizer.nextToken();
                if(!uid.containsKey(id[i]))
                    uid.put(id[i], c);
                else
                    uid.replace(id[i], c);
            }

        }


        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < command.length; i++){

            String ch = uid.get(id[i]);
            switch (command[i]){
                case "Enter":
                    list.add(ch+"님이 들어왔습니다.");
                    break;
                case "Leave":
                    list.add(ch+"님이 나갔습니다.");
            }
        }

        answer = list.toArray(new String[list.size()]);


        return answer;
    }
}
