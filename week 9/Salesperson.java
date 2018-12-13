import java.util.*;

public class Salesperson implements Adder<Salesperson>{
    private String name;
    private double salary;
    private int numsales;
    public Salesperson(String name, double salary, int numsales)
    {
        this.name = name;
        this.salary = salary;
        this.numsales = numsales;
    }
    public void addBonus(double amount)
    {
        salary += amount;
    }
    public int getNumSales()
    {
        return numsales;
    }
    public double getSalary()
    {
        return salary;
    }
    public String getName()
    {
        return name;
    }

    @Override
    public Salesperson add(Salesperson op1, Salesperson op2) {
        return new Salesperson(op1.name, op1.salary,
                op1.numsales + op2.numsales);
    }

    public String printNumSales (Salesperson obj){
        double result = Double.parseDouble(Adder.super.printNumSales(obj));
        String res = String.format("%.2f", result);
        System.out.println(res);
        return res;
    }

    public static Set<Salesperson> distinct (List<Salesperson> list){
        Set<Salesperson> result = new HashSet<>();
        ListIterator<Salesperson> it = list.listIterator();

        while(it.hasNext()){
            result.add(it.next());
        }

        return result;
    }

    @Override
    public String toString()
    {
        return String.format("name: %s, salary: %.2f numsales: %d ",
                name, salary, numsales);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesperson that = (Salesperson) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
