public enum Months {
    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    MAY("May"),
    JUN("June"),
    JUL("July"),
    AUG("August"),
    SEP("September"),
    OCT("October"),
    NOV("November"),
    DEC("December");

    public static String Month[] = {"January", "February", "March",
        "April", "May", "June",
        "July", "August", "September",
        "October", "November", "December"};

    private String monthName;

    Months(String name){
        monthName = name;
    }

    @Override
    public String toString() {
        return monthName;
    }
}
