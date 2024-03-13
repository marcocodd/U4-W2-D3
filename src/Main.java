import entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        List<Product> productsList = getProductList(10);
        System.out.println("Prodotti generati random");
        System.out.println(productsList);
        System.out.println(" ");
        List<Product> booksListPriceOver100 = productsList.stream().filter(product -> product.getCategory().equals("Books") && product.getPrice() > 100).toList();
        System.out.println("Prodotti Books con prezzo > 100");
        System.out.println(booksListPriceOver100);

        List<Product> productsBabyCategory = productsList.stream().filter(product -> product.getCategory().equals("Baby")).toList();
        System.out.println(" ");
        System.out.println("Libri categoria Baby");
        System.out.println(productsBabyCategory);


    }

    static Supplier<Long> randomId = () -> {
        Random random = new Random();
        return random.nextLong(1, 10000);
    };

    static Supplier<Double> randomPrice = () -> {
        Random random = new Random();
        return random.nextDouble() * 200 + 1;

    };


    public static List<Product> getProductList(int numberOfProducts) {
        List<Product> productsList = new ArrayList<>();
        String[] categories = {"Baby", "Books", "Boys"};

        Random randomIndex = new Random();
        for (int i = 0; i < numberOfProducts; i++) {
            productsList.add(new Product(randomId.get(), "Product", categories[(randomIndex.nextInt(3))], randomPrice.get()));

        }
        return productsList;
    }
    

}
