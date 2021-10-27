package tasks;

import java.util.Arrays;
import java.util.Random;

/**
 * Напишите класс, конструктор которого принимает два массива:
 * массив значений и массив весов значений.
 * Класс должен содержать метод, который будет возвращать элемент
 * из первого массива случайным образом, с учётом его веса.
 * Пример:
 * Дан массив [1, 2, 3], и массив весов [1, 2, 10].
 * В среднем, значение «1» должно возвращаться в 2 раза реже,
 * чем значение «2» и в десять раз реже, чем значение «3».
 */
class RandomFromArray {
    private final Random rnd = new Random();
    private final int weight_sum;
    private final int[] weight_scan;
    private final int[] values;

    public RandomFromArray(int[] values, int[] weights) {
        if (values.length == 0 || weights.length == 0 || values.length != weights.length) {
            throw new IllegalArgumentException("values and weights arrays must be of the same size > 0");
        }

        for (int w : weights) {
            if (w < 0) {
                throw new IllegalArgumentException("weights must >= 0");
            }
        }

        this.values = values;

        weight_scan = new int[weights.length];

        weight_scan[0] = weights[0];
        for (int i = 1; i < weights.length; ++i) {
            weight_scan[i] = weight_scan[i - 1] + weights[i];
        }

        weight_sum = weight_scan[weight_scan.length - 1];
    }

    public int Get() {
        return values[Math.abs(Arrays.binarySearch(weight_scan, rnd.nextInt(weight_sum)) + 1)];
    }
}

public class Task05 {

}
