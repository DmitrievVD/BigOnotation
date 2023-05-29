import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Search {
    public static List<Integer> numbers = new ArrayList<>();
    public static Random rnd = new Random();
    public static void main(String[] args) {
//        inList(numbers);
//        numbersSum(10);
//        List<Integer> numSimple = searchSimpleNumbers(numbers);
        System.out.println(dinamicCndgeCounter(6, 4));

    }

    public static void numbersSum(int n){ // Линейный алгоритм O(n)
        int sum = 0;
        for (int i = 1; i <=n; i++){
            sum += i;
        }
        System.out.println(sum);
    }

    public static void inList(List<Integer> list){ // Заполнение массива
        for (int i = 0; i < 100; i++) {
            list.add(rnd.nextInt(0,1000));
        }
//        for (Integer ls : list) {
//            System.out.println(ls);
//        }
    }

    public static List<Integer> searchSimpleNumbers(List<Integer> list){ // Квадратичный алгоритм О(n^2)
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (Integer el : list) {
            boolean isSimple = true;
            for (int i = 2; i < el; i++) {
                if (el % i == 0){
                    isSimple = false;
                    break;
                }
            }
            if (isSimple){
                result.add(el);
                System.out.println(el);
                count++;
            }
        }
        System.out.println("-------------");
        System.out.println(count);
        return result;
    }

    public static int endgeCounter(int endge){ // Экспоненциальная О(2^n)
        int count = 0;
        for (int i = 1; i <= endge; i++) {
            for (int j = 1; j <= endge; j++) {
                for (int k = 1; k <=endge; k++) {
                    for (int l = 1; l <= endge; l++) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int dinamicCndgeCounter(int endgs, int cubes){
        int counter = 0;
        if (cubes != 0){
            for (int i = 1; i <= endgs; i++) {
                counter ++;
            }
            counter += dinamicCndgeCounter(endgs, cubes - 1);
        }
        return counter;
    }


}