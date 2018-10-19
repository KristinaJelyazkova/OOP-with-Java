public class SortUtilsTest {
    public static void main(String[] args) {
        final int SIZE = 3;
        int array[] = new int[SIZE];

        SortUtils.init(array);
        SortUtils.print(array);
        System.out.println();

        SortUtils.sortBbl(array);
        SortUtils.print(array);
        System.out.println();


        int a[] = {10, 40, 50};
        int b[] = {5, 25, 75, 95, 100};
        int result[] = SortUtils.merge(a, b);

        SortUtils.print(result);
    }
}
