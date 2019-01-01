import java.time.LocalDate;

public class Employee {
    private Integer employeeNumber;
    private String employeeFirstName;
    private String employeeLastName;
    private LocalDate hireDate;

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Employee(Integer employeeNumber, String employeeFirstName,
                    String employeeLastName, LocalDate hireDate) {
        this.employeeNumber = employeeNumber;
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return String.format("number = %d, first name = %s,"
                + "last name = %s, hire date = %s",
                getEmployeeNumber(), getEmployeeFirstName(),
                getEmployeeLastName(), getHireDate().toString());
    }
}
