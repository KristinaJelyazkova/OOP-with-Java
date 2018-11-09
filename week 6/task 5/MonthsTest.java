public class MonthsTest {
    public static void main(String[] args) {
        System.out.println("Months referred by name:");

        System.out.println(Months.JAN);
        System.out.println(Months.FEB);
        System.out.println(Months.MAR);
        System.out.println(Months.APR);
        System.out.println(Months.MAY);
        System.out.println(Months.JUN);
        System.out.println(Months.JUL);
        System.out.println(Months.AUG);
        System.out.println(Months.SEP);
        System.out.println(Months.OCT);
        System.out.println(Months.NOV);
        System.out.println(Months.DEC);

        System.out.println("\nMonths referred by index:");

        for (int i = 0; i < 12; i++) {
            System.out.println(Months.Month[i]);
        }
    }
}
