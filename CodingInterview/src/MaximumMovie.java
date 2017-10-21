import java.util.Arrays;

public class MaximumMovie {

    public static int getMaxMovie(int[] start, int[] finish) {
        int[] finishSorted = Arrays.copyOfRange(finish, 0, finish.length);
        Arrays.sort(finishSorted);
        int[] newStart = new int[start.length];
        for (int i = 0; i < finish.length; i++) {
            int index = getIndexFor(finish[i], finishSorted);
            newStart[index] = start[i];
        }
        int count = 0;
        int result[] = new int[start.length];
        result[count] = 0;

        for (int i = 1; i < newStart.length; i++) {
            if (newStart[i] > finishSorted[result[count]]) {
                count++;
                result[count] = 1;
            }
        }
        System.out.println(count);
        System.out.println(Arrays.toString(newStart));
        System.out.println(Arrays.toString(finishSorted));
        System.out.println(Arrays.toString(result));
        return result[count];
    }

    private static int getIndexFor(int data, int[] finishSorted) {
        for (int i = 0; i < finishSorted.length; i++) {
            if (finishSorted[i] == data) {
                return i;
            }
        }
        return 0;
    }

    // watch maximum movie
    public static void main(String[] args) {
        int[] start = { 3, 6, 10, 11, 12, 17, 20 };// start movie time
        int[] finish = { 7, 10, 13, 12, 19, 18, 22 };// finish movie time
        System.out.println(getMaxMovie(start, finish));
    }
}
