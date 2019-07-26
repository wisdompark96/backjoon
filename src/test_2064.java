import java.util.Scanner;

public class test_2064 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String ip = "194.85.160.176";
        String mask ="255.255.255.248";

        String[] p = ip.split("\\.");
        String[] m = mask.split("\\.");

        for(int i = 0; i < p.length; i++){
            int a = Integer.parseInt(p[i]);
            int b = Integer.parseInt(m[i]);
            int sum = 0;
            for(int j = a; j < (a << 8); j = j << 1){
                System.out.println(j&b);
            }
        }

        /*int n = scanner.nextInt();
        String[] ips = new String[n];
        for(int i = 0; i < n; i++){
            ips[i] = scanner.next();
        }

        StringBuilder st1 = new StringBuilder();

        for(int i = 0; i < 4; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                String[] a = ips[j].split("\\.");
                for(int k = 1; k < (1 << 8); k = k<<1){
                    if(i != 3)
                        sum |= Integer.parseInt(a[i])&k;
                    else {
                        if(sum == 0)
                            sum = Integer.parseInt(a[i]) & k;
                        sum &= Integer.parseInt(a[i]) & k;
                    }

                }
            }

            System.out.println(sum);
        }*/
    }
}
