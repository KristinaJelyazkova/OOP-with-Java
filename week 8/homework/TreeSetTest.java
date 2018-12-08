import java.util.*;

public class TreeSetTest {
    public static <T> Set<T> addAll(Set<T> s, Collection<? extends T> c){
        Set<T> set = new TreeSet<>(s);
        set.addAll(c);

        return set;
    }

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();
        String strArrA[] = {"dog", "cat", "tiger", "pig"},
            strArrB[] = {"frog", "dog", "monkey", "pig", "snake"};

        Set<String> setA = new TreeSet<>();
        for (int i = 0; i <strArrA.length ; i++) {
            setA.add(strArrA[i]);
        }

        ArrayList<String> arrB = new ArrayList<>();
        for (int i = 0; i < strArrB.length; i++) {
            arrB.add(strArrB[i]);
        }

        set = addAll(setA, arrB);

        Iterator<String> it = set.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
