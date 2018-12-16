import java.util.*;

public class ListOfProducts<E extends Product> {
    private ArrayList<E> products;

    public ArrayList<E> getProducts() {
        ArrayList<E> result = new ArrayList<>();

        result.addAll(products);

        return result;
    }

    public void setProducts(ArrayList<E> products) {
        this.products = new ArrayList<>();
        this.products.addAll(products);
    }

    public String[] toArray(){
        String[] result = new String[products.size()];

        Iterator<E> it = products.iterator();
        int i = 0;

        while(it.hasNext()){
            result[i] = it.next().toString();
            i++;
        }

        return result;
    }

    public void setup(){
        products = new ArrayList<>();

        Random generator = new Random();
        int numberOfCategories = Product.Category.values().length;

        for (int i = 0; i < 10; i++) {
            char letter = (char)('a' + generator.nextInt(26));
            char[] str = new char[1];
            str[0] = letter;
            Product.Category category =
                    Product.Category.values()[generator.nextInt(numberOfCategories)];
            products.add((E) new Product(new String(str),
                    category, generator.nextDouble()));
        }
    }

    public double averagePrice(){
        OptionalDouble average = products.stream()
                .mapToDouble(Product::getPrice)
                .average();

        if(average.isPresent()){
            return average.getAsDouble();
        }
        return 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");

        for (int i = 0; i < products.size(); i++) {
            result.append(products.get(i).toString());
            if(i != products.size() - 1)
                result.append(", ");
        }

        result.append("}");

        return new String(result);
    }

    public static void main(String[] args) {
        ListOfProducts<Product> list = new ListOfProducts<>();

        ArrayList<Product> array = new ArrayList<>();

        array.add(new Product("table", Product.Category.A, 500.6912));
        array.add(new Product("chair", Product.Category.B, 100.5));
        array.add(new Product("bed", Product.Category.C, 1000.543));
        array.add(new Product("lamp", Product.Category.D, 10.879));

        list.setProducts(array);

        System.out.println(Arrays.asList(list.toArray()));
        System.out.println("average price = " + list.averagePrice());
        System.out.println(list);

        list.setup();
        System.out.println(list);
    }
}
