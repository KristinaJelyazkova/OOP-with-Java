import java.util.*;

public class ArrayListTest {
    private ArrayList<String> list;

    public ArrayListTest() {
        list = new ArrayList<>();
    }

    public void sort(){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void sortByFrequency(){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Collections.frequency(list, o2) - Collections.frequency(list, o1);
            }
        });
    }

    public static <T extends Comparable<? super T>> T removeMax(List<T> list){
        if(list.isEmpty()){
            return null;
        }

        T max = list.get(0);
        //int maxPos = 0;
        ListIterator<T> it = list.listIterator();

        while(it.hasNext()){
            //int currentIndex = it.nextIndex();
            T current = it.next();
            if(current.compareTo(max) > 0){
                max = current;
                //maxPos = currentIndex;
            }
        }

        list.remove(max);

        return max;
    }

    public void getNames(){
        Scanner in = new Scanner(System.in);
        Set<String> names = new HashSet<>();

        System.out.println("Enter number of students' names:");
        int amount = in.nextInt();
        in.nextLine();

        for (int i = 0; i < amount; i++) {
            System.out.println("Enter a name of a student and press enter:");
            names.add(in.nextLine());
        }

        list = new ArrayList<>(names);
    }

    public void searchNames(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a student's name you are searching for:");
        String name = in.nextLine();

        if(list.contains(name)){
            System.out.println("Name found!");
        }
        else{
            System.out.println("Name not found!");
        }
    }

    public void copyTo(ArrayList<String> str){
        Iterator<String> it = list.iterator();

        while(it.hasNext()){
            str.add(it.next());
        }
    }

    public String toStringDescending(){
        ArrayList<String> copy = new ArrayList<>();
        copyTo(copy);
        sort();

        StringBuilder result = new StringBuilder();
        Iterator<String> it = list.iterator();
        boolean notFirst = false;

        while (it.hasNext()){
            if(notFirst) {
                result.append(" " + it.next());
            }
            else{
                notFirst = true;
                result.append(it.next());
            }
        }

        list = copy; // Restoring the order of the list before sorting

        return new String(result);
    }

    public void printArray(){
        Iterator it = list.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        ArrayListTest test = new ArrayListTest();

        test.getNames();

        System.out.println();
        System.out.println("The array contains:");
        test.printArray();

        test.searchNames();

        System.out.println();
        System.out.println("The names in descending order:");
        System.out.println(test.toStringDescending());

        System.out.println();
        System.out.println("The max name is " + removeMax(test.list));
        System.out.println("The list without this name is:");
        test.printArray();

        test.list.add("Kristina Mihova");
        test.list.add("Ivo Mihov");
        test.list.add("Ivo Mihov");
        test.sortByFrequency();
        System.out.println();
        System.out.println("The names sorted by frequency:");
        test.printArray();
    }
}
