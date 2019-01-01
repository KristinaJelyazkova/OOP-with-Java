package product;

public class Product {
    private String description;
    private String category;
    private double price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = (description == null) ? "" : description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = (category == null) ? "" : category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = (price > 0) ? price : 0;
    }

    public Product(String description, String category, double price) {
        setDescription(description);
        setCategory(category);
        setPrice(price);
    }

    @Override
    public String toString() {
        return String.format("Description: %s, Category: %s, Price: %.2f",
                description, category, price);
    }
}
