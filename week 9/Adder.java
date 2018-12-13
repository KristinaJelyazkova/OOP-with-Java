@FunctionalInterface
interface Adder<T extends Salesperson>{
    T add (T op1, T op2);
    default String printNumSales (T obj){
        return "" + obj.getNumSales() ;
    }
    static void printSales(Salesperson s)
    {
        System.out.println(s.getNumSales());
    }
}
