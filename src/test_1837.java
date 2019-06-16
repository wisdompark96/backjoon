import java.util.Scanner;

public class test_1837 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String str[] = scanner.nextLine().split(" ");

        String p = str[0];
        long k = Integer.parseInt(str[1]);

        for(long i = k-1; i > 1; i--){
            long[] result = mod(p, i, (int)(Math.log10(i*9)+1));
            if(result[1] == 0){
                long min = Math.min(i,result[0]);
                System.out.print("BAD "+min);
                return;
            }
        }

        System.out.print("GOOD");
    }

    public static long[] mod(String s, long k, int kLen){

        if(s.length() < 7){
            long n = Long.parseLong(s);
            long[] results = new long[2];
            results[0] = n/k;
            results[1] = n%k;
             return results;
        } else {
            int index = 0;
            long mod = 0;
            StringBuilder sb = new StringBuilder();
            long p = 1;
            int len = kLen+index;
            StringBuilder stringBuilder = new StringBuilder();
            while (index <= s.length()) {
                for (int i = index; i < len; i++){
                    stringBuilder.append(s.charAt(i));
                }
                long n = Long.parseLong(stringBuilder.toString());
                mod = n%k;
                p = n/k;
                sb.append(p);
                index += kLen;
                len += kLen;
                if(index-s.length() < kLen){
                     if(mod != 0){
                         len -=(int)(Math.log10(mod)+1);
                         stringBuilder.setLength(0);
                         stringBuilder.append(mod);
                     }
                    if(len > s.length()){
                        len -= len-s.length();
                    }
                }
            }
            long[] results = new long[2];
            if(sb.toString().length() > 6)
                results[0] = 1;
            else
                results[0] = Integer.parseInt(sb.toString());
            results[1] = mod;
            return results;
        }
    }
}
