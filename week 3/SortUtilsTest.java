public class SortUtilsTest {
    public static void main(String[] args) {
        /*final int SIZE = 10;
        int array[] = new int[SIZE];

        SortUtils.init(array);
        SortUtils.print(array);
        System.out.println();*/

        /*SortUtils.sortBbl(array);
        SortUtils.print(array);
        System.out.println();*/


        /*int a[] = {10, 40, 50};
        int b[] = {5, 25, 75, 95, 100};
        int result[] = SortUtils.merge(a, b);
        SortUtils.print(result);*/

        int array[] = new int[] {18, 2, 14, 10, 1, 15, 18, 10, 20, 12};

        int[] result = SortUtils.mergeSort2(array, 0, array.length);
        SortUtils.print(result);
    }
}
