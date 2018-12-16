public class Product {
    enum Category{
        A, B, C, D;
    }

    private static int numberOfProducts = 0;

    private final int INV_NUMBER;
    private String invDescription;
    private Category category;
    private double price;

    public int getINV_NUMBER() {
        return INV_NUMBER;
    }

    public String getInvDescription() {
        return invDescription;
    }

    public void setInvDescription(String invDescription) {
        this.invDescription = (invDescription != null) ? invDescription : "";
    }

    public Product(String invDescription, Category category, double price) {
        numberOfProducts++;
        this.INV_NUMBER = numberOfProducts;
        setInvDescription(invDescription);
        this.category = category;
        this.price = (price > 0) ? price : 0;
    }

    public Product() {
        this("", Category.A, 0.0);
    }

    public Product(Product other){
        this(other.invDescription, other.category, other.price);
    }

    @Override
    public String toString() {
        return String.format("[unique number = %d, description = %s, price = %.2f]",
                INV_NUMBER, invDescription, price);
    }

    public static void main(String[] args) {
        Product[] products = {new Product("table", Category.A, 500.6912),
                        new Product("chair", Category.B, 100.5),
                        new Product("bed", Category.C, 1000.543),
                        new Product("lamp", Category.D, 10.879)};

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);

        }
    }
}
