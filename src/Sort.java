import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{ 5, 3, 8, 9, 24, 6, 2, 1, 0, 5, 7, 3, 4, };

//        bubbleSort(arr);
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 0));






    }

    public static void bubbleSort(int[] arrey){ // Сортировка пузырьков сложность O (n^2)
        for (int j = arrey.length; j > 1 ; j--) {
            for (int i = 0; i < j - 1; i++) {
                if (arrey[i] > arrey[i+1]){
                    int temp = arrey[i];
                    arrey[i] = arrey[i+1];
                    arrey[i+1] = temp;
                }
            }
        }
    }


    public static void quickSort(int[] arr, int beginIndex, int endIndex){ // Быстрая сортировка O(n * log n)
        int pivot = arr[beginIndex + (endIndex - beginIndex) / 2];
        int left = beginIndex;
        int right = endIndex;
        while (left <= right){
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right){
                if (left < right){
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                left++;
                right--;
            }
        }
        if (left < endIndex){
            quickSort(arr, left, endIndex);
        }
        if (right > beginIndex){
            quickSort(arr, beginIndex, right);
        }
    }

    public static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
    }

    public static int binarySearch(int[] arr, int num, int beginIndex, int endIndex){
        if(beginIndex <= endIndex){
            int midpoint = beginIndex + (endIndex - beginIndex) / 2;
            if(arr[midpoint] < num)return binarySearch(arr, num, midpoint + 1, endIndex);
            else if(arr[midpoint] > num)return binarySearch(arr, num, beginIndex, midpoint - 1);
            else return midpoint;
        }
        else return -1;
    }

    public static int binarySearch(int[] arr, int num){
        return binarySearch(arr, num, 0, arr.length - 1);
    }

}
