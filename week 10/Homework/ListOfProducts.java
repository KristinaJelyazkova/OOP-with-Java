package product;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

public class ListOfProducts<E> {
    private List<E> list;

    public ListOfProducts() {
        list = new ArrayList<>();
    }

    public void addElement(E element){
        list.add(element);
    }

    public void sort(Comparator<E> comparator){
        list.sort(comparator);
    }

    public List<E> listOfFilteredElements(Predicate<E> predicate){
        return list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public Double averageOfElementsProperty(ToDoubleFunction<E> toDoubleFunction){
        OptionalDouble result = list.stream()
                .mapToDouble(toDoubleFunction)
                .average();

        if(result.isPresent()){
            return result.getAsDouble();
        }
        else{
            return null;
        }
    }

    public <T> Map<T, List<E>> groupByElementsProperty(Function<E,T> function){
        return list.stream()
                .collect(Collectors.groupingBy(function));
    }
}
