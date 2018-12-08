import java.util.*;

public class ArrayListTest {

    public static <E extends Comparable<E>> E max(E[][] list){
        if(list.length == 0){
            System.out.println("List is empty! Exiting...");
            System.exit(-1);
        }

        E max = list[0][0];

        for (int i = 0; i < list.length; i++) {
            ArrayList<E> list1 = new ArrayList<>(Arrays.asList(list[i]));
            E currentMax = max(list1);
            if(currentMax.compareTo(max) > 0){
                max = currentMax;
            }
        }

        return max;
    }

    public static <E> void shuffle(ArrayList<E> list){
        Collections.shuffle(list);
    }

    public static  <E extends Comparable<E>> E max(ArrayList<E> list){
        if(list.isEmpty()){
            System.out.println("List is empty! Exiting...");
            System.exit(-1);
        }

        ListIterator<E> it = list.listIterator();
        E max = it.next();

        while(it.hasNext()){
            E current = it.next();
            if(current.compareTo(max) > 0){
                max = current;
            }
        }

        return max;
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
        Set<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    public static <E> void printTwoDimArray(E[][] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.print("" + list[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static <E> void printArray(ArrayList<E> list){
        Iterator it = list.iterator();
        while(it.hasNext()){
            System.out.print("" + it.next().toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random generator = new Random();
        Integer[][] list = new Integer[5][5];

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                list[i][j] = generator.nextInt(101);
            }
        }

        System.out.println("Two dimensional array:");
        printTwoDimArray(list);

        System.out.printf("The maximum element is %d.%n", max(list));

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(list[0]));
        list1.add(3, list1.get(0));
        list1.add(1, list1.get(2));

        System.out.println("Array:");
        printArray(list1);

        shuffle(list1);
        System.out.println("Array after shuffling:");
        printArray(list1);

        ArrayList<Integer> list2 = removeDuplicates(list1);
        System.out.println("Array after removing duplicates:");
        printArray(list2);
    }
}
