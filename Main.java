import java.util.Arrays;
/**
 * Пример обучающей программы с реализацией быстрой сортировки Quicksort
 * @see https://urvanov.ru
 */
public class Main {
 
    public static void main(String [] args) {
        int [] array1 = {9, 0, -2, 89, 1, 2, 3, -3, -99, 6};
        quicksort(array1, 0, array1.length);
        System.out.println(Arrays.toString(array1));
    }
 
    /**
     * Реализуем алгоритм быстрой сортировки
     * @param array1 Массив, в котором нужно упорядочить элементы.
     * @param startIndex Начальный индекс в массиве (включая).
     * @param endIndex Конечный индекс в массиве (не включая)
     */
    public static void quicksort(int[] array1, int startIndex, int endIndex) {
        int pivotValue = getPivot(array1, startIndex, endIndex);
        int currentStartIndex = startIndex;
        int currentEndIndex = endIndex - 1;
        
        while (currentStartIndex < currentEndIndex) {
            while (array1[currentStartIndex] < pivotValue) currentStartIndex++;
            while (array1[currentEndIndex] > pivotValue) currentEndIndex--;
            if (currentStartIndex < currentEndIndex) {
                int buffer = array1[currentStartIndex];
                array1[currentStartIndex] = array1[currentEndIndex];
                array1[currentEndIndex] = buffer;
            }
        }
        if (currentStartIndex > startIndex) quicksort(
                array1, startIndex, currentStartIndex);
        if (endIndex > currentStartIndex + 1) quicksort(
                array1, currentStartIndex + 1, endIndex);
    }
    
    
    /**
     * 
     * @param array1
     * @param lowIndex
     * @param highIndex
     * @return Значение опорного элемента. В этой реализации опорный элемент -
     *  это последний элемент в массиве.
     */
    public static int getPivot(int[] array1, int startIndex, int endIndex) {
        return array1[endIndex - 1];
    }
}