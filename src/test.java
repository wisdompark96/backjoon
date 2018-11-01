import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K =  sc.nextInt();
        sc.close();

        int[][] list = new int[1001][1001];
        list[0][0]= list[1][0] = list[1][1] = 1;//파스칼의 삼각형 생각해보기

        for(int i = 2; i<= N; i++){
            for(int j = 0; j <= i; j++){//파스칼의 삼각형에서  j의 끝 번호는 = i와 같음(EX: 2C0~~~~2C2)
                if(i == j || j == 0){
                    list[i][j] = 1;
                }else{
                    list[i][j] = list[i - 1][j -1] + list[i - 1][j];//이해 안 될 경우 이항 계수 1번문제 참고
                }

                list[i][j] %= 10007;
            }
        }

        System.out.println(list[N][K]);
    }
}
