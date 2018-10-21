import java.util.Arrays;
import java.util.Scanner;

public class SortUtils {
    public static void init(int[] a) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            System.out.printf("Enter a[%d]: ", i);
            a[i] = in.nextInt();
        }
    }

    public static void print(int[] a){
        System.out.print("[");

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if(i < a.length - 1){
                System.out.print(", ");
            }
        }

        System.out.print("]");
    }

    public static void sortBbl(int[] a){
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if(a[j] > a[j + 1]){
                    int swap = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = swap;
                }
            }
        }
    }

    public static int[] merge(int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        int currentPositionA = 0;
        int currentPositionB = 0;

        for (int i = 0; i < result.length; i++) {
            if(currentPositionA >= a.length){
                System.arraycopy(b, currentPositionB,
                        result, i, b.length - currentPositionB);
                return result;
            }
            if(currentPositionB >= b.length){
                System.arraycopy(a, currentPositionA,
                        result, i, a.length - currentPositionA);
                return result;
            }
            if(a[currentPositionA] <= b[currentPositionB]){
                result[i] = a[currentPositionA];
                currentPositionA++;
            }
            else{
                result[i] = b[currentPositionB];
                currentPositionB++;
            }
        }

        return result;
    }

    public static int[] mergeSort(int[] a){
        if(a.length == 0){
            int result[] = new int[0];
            return result;
        }
        if(a.length == 1){
            int result[] = new int[1];
            result[0] = a[0];
            return result;
        }

        int middle = a.length / 2;

        int firstHalf[] = mergeSort(Arrays.copyOfRange(a, 0, middle));
        int secondHalf[] = mergeSort(Arrays.copyOfRange(a, middle, a.length));

        int result[] = merge(firstHalf, secondHalf);

        return result;
    }

    public static int[] mergeSort2(int[] a, int from, int to){
        if(from == to){
            return new int[0];
        }
        if(Math.abs(to - from) <= 1){
            return new int[]{a[from]};
        }

        int middle = (to - from) / 2;

        int firstHalf[] = mergeSort2(a, from, from + middle);
        int secondHalf[] = mergeSort2(a, from + middle, to);

        int result[] = merge(firstHalf, secondHalf);

        return result;
    }
}
