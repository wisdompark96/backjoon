import java.util.Scanner;

public class kakao_test1 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);

        String phone = scanner.next();
        char[] num = new char[phone.length()];
        for(int i = 0; i < phone.length(); i++){
            num[i] = phone.charAt(i);
        }

        switch (phone.length()){
            case 16:
                System.out.print(isright(3,num,phone));
                break;
            case 11:
                System.out.print(isright(2, num, phone));
                break;
            case 13:
                System.out.print(isright(1, num, phone));
                break;
             default:
                 System.out.print(-1);
                 break;
        }
    }

    public static int isright(int num, char[] c, String phone){
        int cnt = 0;
        int cnt2 = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i] == '-')
                cnt++;
            if(c[i] == '+')
                cnt2++;
        }
        switch (num){
            case 1:
                if(phone.indexOf("-") == -1 || phone.contains("+"))
                    return -1;
                else{
                    if(c[3]!= '-' || c[8] != '-' || cnt >2)
                        return -1;
                    if(c[0] != '0' || c[1] !='1' || c[2] != '0')
                        return -1;
                }
                break;
            case 2:
                if(phone.contains("-") || phone.contains("+"))
                    return -1;
                else{
                    if(c[0] != '0' || c[1] !='1' || c[2] != '0')
                        return -1;
                }
                break;
            case 3:
                if(cnt >3 || phone.indexOf("+") != 0 || cnt2 >1)
                    return -1;
                else{
                    if(c[1] != '8' || c[2] != '2' || c[3] != '-' || c[4] != '1' || c[5] != '0'|| c[6] != '-' || c[11] != '-')
                        return -1;
                }
                break;

        }

        return num;
    }


}
