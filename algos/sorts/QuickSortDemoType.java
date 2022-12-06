package algos.sorts;

import java.util.Arrays;
import java.util.Random;

public class QuickSortDemoType {
    public static void main(String[] args) {
        quickSortRandomArray();
    }

    private static void quickSort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partitionHoare(array, lo, hi);
        quickSort(array, lo, p - 1);
        quickSort(array, p + 1, hi);
    }

    private static void quickSort() {
        quickSort(ints, 0, QuickSortDemoType.ints.length - 1);
    }

    public static void quickSortRandomArray() {
        quickSort();
        printArray();

        System.out.println("  Partitions competed: " + partitionsCount);
    }

    private static final int[] ints;
    private static int partitionsCount;

    static {
        Random rand = new Random();
        ints = new int[rand.nextInt(10, 20)];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = rand.nextInt(-20, 21);
        }

        printArray(true);
        partitionsCount = 0;    // for diagnostics
    }

    private static void printArray(boolean printLength) {
        System.out.println(Arrays.toString(ints));
        if (printLength) {
            System.out.println("  Length: " + ints.length);
        }
    }

    private static void printArray() {
        printArray(false);
    }

    private static int partitionHoare(int[] array, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        int pivot = array[lo];
        while (true) {
            while (i < hi && array[i] < pivot) {
                ++i;
            }
            while (array[j] > pivot) {
                --j;
            }
            if (i >= j) {
                break;
            }
            swap(array, i++, j--);
            partitionsCount++;
        }
        swap(array, lo, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
