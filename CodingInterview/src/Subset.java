import java.util.Scanner;

public class Subset {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] set = new int[n];

        if (n >= 1 && n <= 100000) {
            for (int index = 0; index < n; index++) {
                set[index] = sc.nextInt();
            }

            int totalSum = 0;
            for (int i = 0; i < (1 << n); i++) {

                int max = Integer.MIN_VALUE;
                // Print current subset
                for (int j = 0; j < n; j++) {

                    if ((i & (1 << j)) > 0) {
                        if (set[j] > 0 && set[j] > max) {
                            max = set[j];
                        }
                        System.out.print(set[j] + " ");
                    }

                }
                if (max > 0) {
                    int sum = sumOfDigits(max);
                    totalSum = totalSum + sum;
                }

            }
            System.out.println(totalSum);
        }
    }

    private static int sumOfDigits(int input) {
        int sum = 0;
        while (input != 0) {
            int lastdigit = input % 10;
            sum += lastdigit;
            input /= 10;
        }

        return sum;
    }
}
