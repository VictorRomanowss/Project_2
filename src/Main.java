import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void quickSort(int[] slivka, int start, int finish) {
        if (start >= finish)
            return;// не чего делить, завершаем выполнение
        // найдем опорный элемент:
        int srednik = (start + finish) / 2;
        int opornik = slivka[srednik];
        // i-начальный элемент меньше опрного элемента
        // j-конечный элемент больше опорного элемента
        int i = start, j = finish;
        while (i <= j) {
            while (slivka[i] < opornik) {
                i++;
            }
            while (slivka[j] > opornik) {
                j--;
            }
            if (i <= j) {//производим замену
                int red = slivka[i];
                slivka[i] = slivka[j];
                slivka[j] = red;
                i++;
                j--;
            }
        }
        // повторяем сортировку для левой и правой части
        if (start < j)
            quickSort(slivka, start, j);
        if (finish > i)
            quickSort(slivka, i, finish);
    }

    public static void main(String[] args) {
        int[] pink = new int[10];
        for (int i = 0; i < pink.length; i++) {
            pink[i] = (int) Math.round(Math.random() * 100);
        }
        System.out.println("Начальный вариант:");
        System.out.println(Arrays.toString(pink));
        int start = 0;
        int finish = pink.length - 1;
        quickSort(pink, start, finish);
        System.out.println("Отсортированный вариант:");
        System.out.println(Arrays.toString(pink));

    }
}