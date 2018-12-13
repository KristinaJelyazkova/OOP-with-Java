import java.util.function.*;

public class LambdaTest {
    private Double x;

    public LambdaTest(Double x) {
        this.x = x;
    }

    public static void method(Function<Double, Double> function) {}

    public static Double multBy2(Double x){
        return x * 2;
    }

    public Double add(Double y){
        return x + y;
    }

    public static void main(String[] args) {
        //a:
        Function<Integer, String> turnToString = String::valueOf;
        BiPredicate<Double, Double> sumMoreThan10 = (x, y) -> {
            Double z = x + y;
            return z.compareTo(10.0) > 0;
        };
        BiConsumer<String, String> printBoth = (x, y) -> System.out.println(x + " " + y);
        Supplier<int[]> createIntArrayWith10elem = () -> new int[10];
        IntFunction<double[]> createDoubleArray = double[]::new;

        System.out.println("The number 15 as a string is " + turnToString.apply(15));
        System.out.println("5.43 + 7.21 is " + (sumMoreThan10.test(5.43, 7.21) ? "more" : "less") + " than 10.");
        printBoth.accept("Krisi", "Mihova");
        int[] intArray = createIntArrayWith10elem.get();
        double[] doubleArray = createDoubleArray.apply(10);

        //b:
        Function<Double, Double> func = Math::cos;
        Consumer<String> task = System.out::println;
        Runnable task1 = System.out::println;
        Predicate<String> isEqual = String::isEmpty;

        //c:
        method(x -> x * 2);
        method(LambdaTest::multBy2);
        LambdaTest lambdaTest = new LambdaTest(2.0);
        method(lambdaTest::add);

        //d:
        Function<Double, Double> cos = (x) -> Math.cos(x);
        Consumer<String> print = (x) -> System.out.println(x);
        Runnable task2 = () -> System.out.println("Tова е Ламбда");
        BiPredicate<Integer, Integer> biggerThan = (x, y) -> x > y;
        IntPredicate even = (int x) -> x %2 == 0;
        IntBinaryOperator add = (int x, int y) -> x + y;
    }
}
