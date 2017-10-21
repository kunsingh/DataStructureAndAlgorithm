import java.util.Arrays;

public class LeastNumberFinderWithSameDigit {

    public static int[] findLeastDigitWithSameNumber(int[] numbers) {
        assert numbers.length > 0 : "Empty Array";
        boolean isDone = false;
        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                    sort(numbers, j + 1);
                    isDone = true;
                    break;
                }
            }
            // We found the next minimum
            if (isDone) {
                break;
            }
        }
        return numbers;
    }

    private static void sort(int[] number, int i) {
        Arrays.sort(number, i, number.length);// Sort after swap to make it next
                                              // least number
    }

    public static void main(String[] args) {
        int[] numArr = { 2, 6, 5, 4 };
        numArr = findLeastDigitWithSameNumber(numArr);
        System.out.println(Arrays.toString(numArr));
    }
}
