import java.util.Arrays;

public class HW2 {
    // Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
    public static void heapSort (int[] arr){
        int len = arr.length;

        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }

        for (int i = len - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i , 0);
        }
    }

    public static void heapify(int[] arr, int len, int i){ // Образуем кучу
        int bigRoot = i; // Находим большой элемент как корень
        int left = 2 * i + 1; // Левый дочерний элемент
        int right = 2 * i + 2; // Правый

        if (left < len && arr[left] > arr[bigRoot]) bigRoot = left; // Если левый больше конря
        if (right < len && arr[right] > arr[bigRoot]) bigRoot = right; // Если правый больше конря

        if(bigRoot != i ){ // Когда корень поменялся
            int swap = arr[i];
            arr[i] = arr[bigRoot];
            arr[bigRoot] = swap;

            heapify(arr, len, bigRoot);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 5, 3, 8, 9, 24, 6, 2, 1, 0, 5, 7, 3, 4, };
        System.out.println(Arrays.toString(arr));

        heapSort(arr);
        System.out.println("Сортировка списка...");
        System.out.println(Arrays.toString(arr));
    }
}
