package kata.market.model;

import lombok.Data;

import java.util.LinkedHashMap;

import static io.vavr.API.*;


@Data
class Client {
    private LinkedHashMap cart = new LinkedHashMap<Product, Float>();

    void addToCart(Product product, Float numberToBuy) {
        if (cart.containsKey(product)) {

            cart.put(product, numberToBuy + (Float) cart.get(product));
        } else {
            cart.put(product, numberToBuy);
        }
    }

    void removeFromCart(Product product, Float number) {
    }

}

