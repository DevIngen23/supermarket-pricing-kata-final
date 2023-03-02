package kata.market.model;

import io.vavr.Tuple2;
import kata.market.pricing.DefaultPricing;
import kata.market.pricing.PromotionPricing;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
class Supermarket {

    float calculateTotalAmount(Client customer) {
        LinkedHashMap<Product, Float> input = customer.getCart();
        float total = 0f;
        return total;
    }

    void addReduction(Product product, int numberToBuy, float reduction) {
        product.setReductionValueByNumber(new Tuple2<>(numberToBuy, reduction));
    }

    void removeReductions(Product product) {
        product.setReductionValueByNumber(new Tuple2<>(null, null));
    }
}