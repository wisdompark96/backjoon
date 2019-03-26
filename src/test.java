import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;


public class test {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> hashMap = new HashMap<>();
       /* BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> arrayList = new ArrayList<>();
        String str ;
        while(true){
            str = br.readLine();
            if(str == null)
                break;
            arrayList.add(str);
        }

        for(int i = 0; i < arrayList.size(); i++)
            System.out.println(arrayList.get(i));
        br.close();
        bw.close();*/

       for(int i = 0; i < 100000; i++){
           hashMap.put(String.valueOf(i), "dddddddddddddd");
       }
    }

}
