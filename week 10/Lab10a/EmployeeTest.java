import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EmployeeTest {
    List<Employee> employees;

    public void setup() {
        employees = new ArrayList<>();
        employees.add(new Employee(123, "Jack", "Johnson",
                LocalDate.of(1988, Month.APRIL, 12)));
        employees.add(new Employee(345, "Cindy", "Bower",
                LocalDate.of(2011, Month.DECEMBER, 15)));
        employees.add(new Employee(567, "Perry", "Node",
                LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(467, "Pam", "Krauss",
                LocalDate.of(2005, Month.JUNE, 07)));
        employees.add(new Employee(435, "Fred", "Shak",
                LocalDate.of(1988, Month.APRIL, 17)));
        employees.add(new Employee(678, "Ann", "Lee",
                LocalDate.of(2007, Month.APRIL, 12)));
    }

    public void sortEmployeesByNumber(){
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getEmployeeNumber))
                .forEach(System.out::println);
    }

    public void sortEmployeesByHireDate(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getHireDate).reversed())
                .forEach(System.out::println);
    }

    public Optional<Employee> longestTenuredEmployee(){
        Optional<Employee> result = employees.stream()
                .min(Comparator.comparing(Employee::getHireDate));

        if(result.isPresent()){
            System.out.println("The longest tenured employee has these characteristics:");
            System.out.println(result.get());
        }

        return result;
    }

    public void sortEmployeesByByName(){
        employees.stream()
                .sorted(Comparator.comparing(Employee::getEmployeeFirstName).reversed()
                        .thenComparing(Employee::getEmployeeLastName).reversed())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        EmployeeTest employeeTest = new EmployeeTest();
        employeeTest.setup();

        employeeTest.sortEmployeesByNumber();
        System.out.println();

        employeeTest.sortEmployeesByHireDate();
        System.out.println();

        employeeTest.longestTenuredEmployee();
        System.out.println();

        employeeTest.sortEmployeesByByName();
    }
}
