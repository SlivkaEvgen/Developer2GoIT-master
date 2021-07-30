package miniShop.client;

import miniShop.model.Product;
import miniShop.repository.Store;
import miniShop.repository.StoredInStockImpl;
import miniShop.service.BasketImpl;

public class Main {
    public static void main(String[] args) {

        Store<Product,String> store = new StoredInStockImpl<>(new Product("A", 1.25d, 3.0d, 0.0d, 3.0d),
                new Product("B", 4.25d, 0.0d, 0.0d, 0.0d),
                new Product("C", 1.00d, 5.0d, 0.0d, 6.0d),
                new Product("D", 0.75d, 0.0d, 0.0d, 0.0d));

        BasketImpl basketImpl = new BasketImpl(store);

        System.out.println(basketImpl.calculateTotalCost("ABCDABA"));
        System.out.println(basketImpl.calculateTotalCost(null));
        System.out.println(basketImpl.calculateTotalCost(""));
        System.out.println(basketImpl.calculateTotalCost("aaa"));
        System.out.println(basketImpl.calculateTotalCost("a120986//*(±!#"));

    }
}
