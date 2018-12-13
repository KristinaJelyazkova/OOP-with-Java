import java.net.Inet4Address;
import java.util.function.BiFunction;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class LambdaTest2 {
    public static String method(StringFunction f, String s){
        return f.change(s);
    }

    public static void main(String[] args) {
        //a:
        IntConsumer print = value -> System.out.printf("%d", value);
        print.accept(3);
        System.out.println();

        //b:
        String s = "hello";
        String result = method(new StringFunction() {
            @Override
            public String change(String s) {
                return s.toUpperCase();
            }
        }, s);
        System.out.println(result);

        //c:
        Supplier<String> welcome = () -> "Welcome to lambdas!";
        System.out.println(welcome.get());

        //d:
        BiFunction<Integer, Integer, Integer> max = Math::max;
        System.out.println(max.apply(10, 3));
    }
}
