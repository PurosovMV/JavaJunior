import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class HW1 {
    public static void main(String[] args) {
        Random random = new Random();
        // Задаем массив
        int[] array = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(100))
                .limit(10)
                .toArray();
        double avgEvenNum = Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .average()
                .getAsDouble();


        System.out.println("Массив: " + Arrays.toString(array) + "\nСреднее значение чётных чисел массива: " + avgEvenNum);
    }
}
