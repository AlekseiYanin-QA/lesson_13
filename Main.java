import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000};
        Random random = new Random();

        for (int size : sizes) {
            // Генерируем случайный массив
            int[] originalArray = random.ints(size, 0, size).toArray();

            // Пузырьковая сортировка
            int[] arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
            int[] finalArrayToSort = arrayToSort;
            long bubbleSortTime = measureSortingTime(() -> BubbleSort.bubbleSort(finalArrayToSort), arrayToSort);

            // Сортировка выбором
            arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
            int[] finalArrayToSort1 = arrayToSort;
            long selectionSortTime = measureSortingTime(() -> SelectionSort.selectionSort(finalArrayToSort1), arrayToSort);

            // Стандартная сортировка
            arrayToSort = Arrays.copyOf(originalArray, originalArray.length);
            int[] finalArrayToSort2 = arrayToSort;
            long standardSortTime = measureSortingTime(() -> Arrays.sort(finalArrayToSort2), arrayToSort);

            // Вывод результатов
            System.out.println("Размер массива: " + size);
            System.out.println("Время пузырьковой сортировки: " + bubbleSortTime + " нс");
            System.out.println("Время сортировки выбором: " + selectionSortTime + " нс");
            System.out.println("Время стандартной сортировки: " + standardSortTime + " нс");
            System.out.println();
        }
    }

    public static long measureSortingTime(Runnable sortingAlgorithm, int[] array) {
        long startTime = System.nanoTime();
        sortingAlgorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

}
