import java.util.Arrays;

/**
 * A[0,1,2] values[3,1,2] -- iterate
 * 
 */
public class IterateCharWithNumber {

    public static int getCount1(int[] values) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] - 1 != i) { // index start at 0;
                count++;
            }
        }
        return count;
    }

    public static int getCount(int[] values) {
        int[] A = new int[values.length];
        int[] temp1 = new int[values.length];
        int[] temp2 = new int[values.length];
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            A[i] = i;
            temp1[i] = i;
        }
        while (true) {
            if (count == 0) {
                arrangeArray(values, temp1, temp2);
                temp1 = Arrays.copyOfRange(temp2, 0, temp2.length);
            } else {
                boolean result = checkForInitialState(A, temp1);
                if (result) {
                    break;
                }
                arrangeArray(values, temp1, temp2);
                temp1 = Arrays.copyOfRange(temp2, 0, temp2.length);
            }
            count++;
        }

        return count;
    }

    private static void arrangeArray(int[] values, int[] temp1, int[] temp2) {
        for (int i = 0; i < values.length; i++) {
            temp2[values[i] - 1] = temp1[i];
        }
    }

    private static boolean checkForInitialState(int[] A, int[] temp1) {
        boolean isSame = true;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != temp1[i]) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 5, 1, 4 };
        System.out.println(getCount(A));
        System.out.println(getCount1(A));
    }
}
