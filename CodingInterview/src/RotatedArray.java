import java.util.Arrays;
import java.util.Scanner;

public class RotatedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int R = sc.nextInt();
        int q = sc.nextInt();
        if (N < 100000) {
            if (R < 100000) {
                if (q < 500) {
                    for (int i = 0; i < N; i++) {
                        A[i] = sc.nextInt();
                    }

                    for (int k = 0; k < R; k++) {
                        int temp = A[N-1];
                        for (int j = N-1; j >0; j--) {
                            A[j] = A[j-1];
                        }
                        A[0]=temp;
                    }
                    
                    for(int index=0; index< N; index++){
                        int value = sc.nextInt();
                        if(value >=0 && value<=N-1)
                        System.out.println(A[value]);
                    }
                }
            }
        }
        sc.close();
    }
}
//Scanner in = new Scanner(System.in);
//int n = in.nextInt();
//int k = in.nextInt();
//int q = in.nextInt();
//int[] a = new int[n];
//for(int a_i=0; a_i < n; a_i++){
//    a[a_i] = in.nextInt();
//}
//for(int i=0; i < k; i++){
//    int temp=a[n-1];
//    for(int ab=n-1; ab > 0; ab--)
//        a[ab] = a[ab-1];
//    a[0]=temp;
//}
//for(int a0 = 0; a0 < q; a0++){
//    int m = in.nextInt();
//    System.out.println(a[m]);
//}