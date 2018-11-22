import java.util.Random;

public class UseSort {
    public static void main(String[] args) {
        Random generator = new Random();
        int[] array = new int[10];

        System.out.println("The array is:");
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(1000);
            System.out.print(array[i] + " ");
        }
        System.out.println();

        SortOrder sortOrder = new SortOrder();
        Sortable upward = sortOrder.upward(),
                downward = sortOrder.downward();
        MySort mySort = new MySort(upward);

        mySort.sort(array);

        System.out.println("The array sorted in ascending order:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        mySort.setCallback(downward);

        mySort.sort(array);

        System.out.println("The array sorted in descending order:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        MySort mySort2 = new MySort(new Sortable() {
            @Override
            public boolean greater(int a, int b) {
                return a > b;
            }
        });

        mySort2.sort(array);

        System.out.println("The array sorted in ascending order using anonymous class:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
