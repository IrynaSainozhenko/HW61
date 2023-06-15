import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

//        Задание 6 reduce
//        Посчитайте общую стоимость всех товаров в листе.
        List<Product> products = new ArrayList<>();
        products.add(new Product("telephone ", 8, 300, "electronic"));
        products.add(new Product("coffee machine",5, 293, "household equipment"));
        products.add(new Product("computer",4 ,1280 , "electronic"));
        products.add(new Product("table",7 ,120 , "furniture"));
        products.add(new Product("dress", 5 , 50, "clothes"));
        products.add(new Product("toaster", 8 , 25, "household equipment"));
        products.add(new Product("hat", 3, 20, "clothes"));
        products.add(new Product("TV Samsung", 6,  250, "electronic"));
        products.add(new Product("jacket", 4, 100, "clothes"));
        products.add(new Product("sofa", 10, 85, "furniture"));
        System.out.println("Исходный лист");
        System.out.println(products);

        // task 1
        List<Product> productsExpensiveTwoHundred =
        products
                .stream()
                .filter((product) -> product.getPrice() > 200)
                .toList();
        System.out.println("task 1");
        System.out.println(productsExpensiveTwoHundred);

        // task 2
        List<Product> productsSortedToRating =
                products.stream().sorted(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getRating() == o2.getRating()) {
                            return o1.getCategory().compareTo(o2.getCategory());
                        }
                        return Integer.compare(o1.getRating(), o2.getRating());
                    }
                }).toList();
        System.out.println("task 2");
        System.out.println(productsSortedToRating);

        // task 3
        boolean hasTitleIPhone = products
                .stream()
                .anyMatch(product -> product.getTitle().equals("Iphone XR"));
        System.out.println("task 3");
        System.out.println(hasTitleIPhone);

        // task 4
        List<Product> products1 = products
                .stream()
                .map(prod -> new Product(
                        prod.getTitle(), prod.getRating() + 1,
                        prod.getPrice(), prod.getCategory()))
                .toList();
        System.out.println("task 4");
        System.out.println(products1);

        // task 5
        products.forEach(price -> price.setPrice(price.getPrice() + 20));
        System.out.println("task 5");
        System.out.println(products);

        // task 6
        double totalPrice =
                products.
                stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);
        System.out.println("task 6");
        System.out.println(totalPrice);
    }
}