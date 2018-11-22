import iterator.*;

import java.util.Random;

public class SequenceTest {
    public static void main(String[] args) {
        int size = 10;
        Sequence sequence = new Sequence(size);
        Random generator = new Random();

        for (int i = 0; i < size; i++) {
            sequence.add(generator.nextInt(991) + 10);
        }

        SelectorForward selector = sequence.getSelectorForward();
        System.out.println("\nElements from beginning to end: ");

        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

        SelectorBackward selector2 = sequence.getSelectorBackward();
        System.out.println("\nElements from end to beginning: ");

        while (!selector2.begin()) {
            System.out.println(selector2.current());
            selector2.previous();
        }

        SelectorTwoWay selector3 = sequence.getSelectorTwoWay(generator.nextInt(size));
        System.out.println("\nElements from random index to end and then from end to beginning:");

        while(!selector3.end()){
            System.out.println(selector3.current());
            selector3.next();
        }

        selector3.previous();

        while(!selector3.begin()){
            System.out.println(selector3.current());
            selector3.previous();
        }
    }
}