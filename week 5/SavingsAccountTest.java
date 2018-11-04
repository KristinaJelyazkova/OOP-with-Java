public class SavingsAccountTest {
    public static void main(String[] args) {
        SavingsAccount account1 = new SavingsAccount(200.74);
        SavingsAccount account2 = new SavingsAccount(100.5);

        System.out.printf("The first account is%s greater than the second.%n",
                (account1.isGreater(account2)) ? "" : " not");

        SavingsAccount account3 = new SavingsAccount(account1);

        System.out.printf("The third account(copy of the first) is%s greater than the first(the original).%n",
                (account3.isGreater(account1)) ? "" : " not");

        account1 = null;
        account2 = null;
        account3 = null;

        System.gc();
        Runtime.getRuntime().runFinalization();
    }
}
