import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int noOfPositive=0;
        int noOfNegative=0;
        int noOfZeros=0;
        for(int i=0;i<N;i++){
            if(A[i]>0){
                noOfPositive++;
            }
            if(A[i]<0){
                noOfNegative++;
            }
            if(A[i]==0){
                noOfZeros++;
            }
        }
        DecimalFormat df = new DecimalFormat("#.######");
        df.setMinimumFractionDigits(6);
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format((double)noOfPositive/N));
        System.out.println(df.format((double)noOfNegative/N));
        System.out.println(df.format((double)noOfZeros/N));
    }
}
