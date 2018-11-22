//  Defines the basic operations with a sequence.
public interface Selector {
    boolean end();
    Object current();
    void next();
}