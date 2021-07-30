package miniShop.service;

import miniShop.model.Product;
import miniShop.repository.Store;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class BasketImpl implements Basket{

    private final Store<Product,String> store;

    public BasketImpl(Store<Product,String> store) {
        this.store = store;
    }

    public double calculateTotalCost(String basket) {
        double totalPrice = 0.0d;
        if (basket != null) {
            Map<String, Integer> calculatorMap = countProductsInBasket(basket);
            for (String productName : calculatorMap.keySet()) {
                Product product = store.getById(productName).get();
                if (calculatorMap.get(productName) != null) {
                    double amount = calculatorMap.get(productName);
                    double price = product.getPrice();
                    double discountPrice = product.getDiscountPrice();
                    double discountAmount = product.getDiscountAmount();
                    int a = (int) (amount / discountAmount);
                    totalPrice += (amount < discountPrice) ? (amount * price) : ((price * (amount - (discountAmount * a))) + (discountPrice * a));
                }
            }
        }
        return totalPrice;
    }

    private Map<String, Integer> countProductsInBasket(String basket) {
        int count = 0;
        Map<String, Integer> mapBasket = new HashMap<>();
        for (String basketChar : basket.toUpperCase().split("")) {
            Optional<Product> optionalID = store.getById(basketChar);
            if (optionalID.isPresent()) {
                mapBasket.putIfAbsent(basketChar, count);
                mapBasket.put(basketChar, mapBasket.get(basketChar) + 1);
            }
        }
        return mapBasket;
    }
}
