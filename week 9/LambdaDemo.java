import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo {
    public static void main(String[] args)
    {
        Predicate<Salesperson> predicate1 = x -> x.getNumSales() < 1200;
        Predicate<Salesperson> predicate2 = x -> x.getNumSales() > 900;
        Predicate<Salesperson> predicate = predicate1.and(predicate2);
        Consumer<Salesperson> consumer1 = x -> {
            x.addBonus(0.05 * x.getSalary());
            System.out.println(x);
        };
        Consumer<Salesperson> consumer2 = x -> {
            x.addBonus(0.02 * x.getSalary());
            JOptionPane.showMessageDialog(null, x.toString());
        };
        Comparator<Salesperson> comparator1 = Comparator.comparingDouble(Salesperson::getSalary)
                .reversed();
        Comparator<Salesperson> comparator2 = Comparator.comparingDouble(Salesperson::getSalary)
                .reversed().
                        thenComparing(Salesperson::getNumSales); // да се инициализира
        Salesperson[] salespersons =
                {
                        new Salesperson("John Doe", 2000, 949),
                        new Salesperson("Jane Doe", 3900, 1500),
                        new Salesperson("Mary Jane", 3000, 549),
                        new Salesperson("Mariah Carey", 3900, 1000),
                        new Salesperson("George Michael", 2000, 849),
                        new Salesperson("Michael Jackson", 8000, 1900),
                        new Salesperson("Rachel McAdams", 2000, 239),
                        new Salesperson("Naomi Watts", 1000, 570),
                        new Salesperson("Gwen Stephanie", 1000, 2949),
                        new Salesperson("Christina Aguilera", 3900, 1900),
                        new Salesperson("Mariah Carey", 8000, 999),
                        new Salesperson("Jim Dawson", 4900, 1100),
                        new Salesperson("Tom Cruise", 9000, 599),
                        new Salesperson("Rachel McAdams", 3900, 1000)
                };
        List<Salesperson> listOfSalespersons = new ArrayList<>();
        listOfSalespersons = Arrays.asList(salespersons);
// обектите на salespersons да се запишат в listOfSalespersons
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate1, consumer1);
            System.out.println(salesperson);
            salesperson.printNumSales(salesperson);
        }
        for (Salesperson salesperson: salespersons)
        {
            applyBonus(salesperson, predicate2, consumer2);
            System.out.println(salesperson);
        }
        sort(listOfSalespersons, comparator1);
        System.out.println(listOfSalespersons);
        sort(listOfSalespersons, comparator2);
        System.out.println(listOfSalespersons);

        Salesperson addPerson = (new Salesperson("test", 0, 0)).add(listOfSalespersons.get(0),
                listOfSalespersons.get(1));
        System.out.println(addPerson);
        addPerson.printNumSales(addPerson);

        System.out.println(Salesperson.distinct(listOfSalespersons));
    }
    public static void applyBonus(Salesperson salesperson,
                                  Predicate<Salesperson> predicate,
                                  Consumer<Salesperson> consumer)
    {
// Напишете if команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if командата е изпълнено
        if(predicate.test(salesperson)){
            consumer.accept(salesperson);
        }
    }
    public static void applyBonus(List<Salesperson> salespersons,
                                  Predicate<Salesperson> predicate,
                                  Consumer<Salesperson> consumer)
    {
// Напишете if команда, където използвайте predicate
// за да определите дали да изпълните consumer
// Изпълнете consumer, когато условието на if командата е изпълнено
        salespersons.forEach(x -> applyBonus(x, predicate, consumer));
    }
    public static void sort(List<Salesperson> salespersons,
                            Comparator<Salesperson> comparator)
    {
// Сортирайте salespersons като използвате comparator
        salespersons.sort(comparator);
    }
}
