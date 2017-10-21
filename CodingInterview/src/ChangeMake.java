import java.util.Scanner;

public class ChangeMake {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 250;//sc.nextInt();
        if(N >=1 && N <= 250){
            int M = 24;//sc.nextInt();
            if(M >=1 && M <= 50){
                int[] coins ={41, 34, 46, 9, 37, 32, 42, 21, 7 ,13, 1, 24, 3, 43, 2, 23, 8 ,45, 19, 30, 29, 18, 35, 11};// new int[M];
//                for(int c=0;c<M;c++){
//                    coins[c] = sc.nextInt();
//                }
                int[] F = new int[N + 1];
                F[0] = 1;
                for (int i = 0; i < coins.length; i++) {
                    for (int j = coins[i]; j <= N; j++) {
                        F[j] = F[j] + F[j - coins[i]];// pick one coin
                    }
                }
                System.out.println(F[N]);
            }
        }
    }
}
