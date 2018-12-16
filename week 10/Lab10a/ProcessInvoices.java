// Exercise 17.11: ProcessInvoices.java
// Processing Invoices with lambdas and streams.
import javafx.util.Pair;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcessInvoices {
   public static void main(String[] args) {
      Invoice[] invoices = {
              new Invoice(83, "Electric sander", 7, 57.98),
              new Invoice(24, "Power saw", 18, 99.99),
              new Invoice(7, "Sledge hammer", 11, 21.50),
              new Invoice(77, "Hammer", 76, 11.99),
              new Invoice(39, "Lawn mower", 3, 79.50),
              new Invoice(68, "Screwdriver", 106, 6.99),
              new Invoice(56, "Jig saw", 21, 11.00),
              new Invoice(3, "Wrench", 34, 7.50)
      };

      Supplier<Stream<Invoice>> streamSupplier = () -> Arrays.stream(invoices);

      System.out.println("Invoices sorted by part description:");

      streamSupplier.get()
              .sorted(Comparator.comparing(Invoice::getPartDescription))
              .forEach(System.out::println);

      System.out.printf("%nnInvoices sorted by price:%n");

      streamSupplier.get()
              .sorted(Comparator.comparing(Invoice::getPrice))
              .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and quantity:%n");

      streamSupplier.get()
               .map(inv -> new Pair<>(inv.getPartDescription(), inv.getQuantity()))
               .sorted(Comparator.comparing(Pair::getValue))
               .forEach(System.out::println);

      System.out.printf("%nInvoices mapped to description and invoice amount:%n");

      streamSupplier.get()
              .map(inv -> new Pair<>(inv.getPartDescription(),
                      inv.getQuantity() * inv.getPrice()))
              .sorted(Comparator.comparing(Pair::getValue))
              .forEach(System.out::println);


      System.out.printf("%nInvoices mapped to description and invoice amount for invoices in the range 200-500:%n");


       Predicate<Pair<String, Double>> lessThan500 = pair -> Double.compare(pair.getValue(), 500) <= 0;
       Predicate<Pair<String, Double>> moreThan200 = pair -> Double.compare(pair.getValue(), 200) >= 0;
       Predicate<Pair<String, Double>> inRange = lessThan500.and(moreThan200);

       streamSupplier.get()
               .map(inv -> new Pair<>(inv.getPartDescription(),
                       inv.getQuantity() * inv.getPrice()))
               .filter(inRange)
               .sorted(Comparator.comparing(Pair::getValue))
               .forEach(System.out::println);

       Map<Boolean, List<Invoice>> group = streamSupplier.get()
               .collect(Collectors.partitioningBy(inv ->
                       Double.compare(inv.getQuantity() * inv.getPrice(), 300) <= 0));

       System.out.println();
       System.out.println("Group of invoices with values below or equal to 300");
       group.get(true).forEach(System.out::println);

       System.out.println();
       System.out.println("Group of invoices with values above 300");
       group.get(false).forEach(System.out::println);

       System.out.println();
       System.out.println("The invoice with the maximum quantity is:");

       streamSupplier.get()
               .max(Comparator.comparing(Invoice::getQuantity))
               .ifPresent(System.out::println);
   }
}



