package tasks;

public class Task01 {

    /**
     * Возвращает минимальное значение из массива.
     * Не использовать стандартную библиотеку!
     */
    public static int min(int[] ints) {
        int curr_min = Integer.MAX_VALUE;

        for (int elem : ints) {
            if (elem < curr_min) {
                curr_min = elem;
            }
        }

        return curr_min;
    }

    public static float average(int[] ints) {
        float sum = 0;

        for (int elem : ints) {
            sum += elem;
        }

        return ints.length > 0 ? sum / ints.length : 0;
    }

}
