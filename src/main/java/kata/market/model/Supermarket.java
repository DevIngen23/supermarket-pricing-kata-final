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

    private Optional<Integer> itemPromotion(Product product) {
        return Optional.ofNullable(product.getReductionValueByNumber())
                .filter(reductionList -> Objects.nonNull(reductionList._1))
                .filter(reductionList -> Objects.nonNull(reductionList._2))
                .map(reductionList -> reductionList._1);
    }

    float calculateTotalAmount(Client customer) {
        LinkedHashMap<Product, Float> input = customer.getCart();
        float total = 0f;

        total = processDefaultPricing(input, total);
        total = processPromotionPricing(input, total);

        return total;
    }

    private float processPromotionPricing(LinkedHashMap<Product, Float> inputMap, float total) {
        return inputMap.entrySet().stream()
                .filter(item -> itemPromotion(item.getKey()).isPresent())
                .map(item -> new PromotionPricing().calculateTotalAmount(item.getKey(), item.getValue()))
                .reduce(total, (f1, f2) -> f1 + f2);
    }

    private float processDefaultPricing(LinkedHashMap<Product, Float> inputMap, float total) {
        return inputMap.entrySet().stream()
                .filter(item -> !itemPromotion(item.getKey()).isPresent())
                .map(item -> new DefaultPricing().calculateTotalAmount(item.getKey(), item.getValue()))
                .reduce(total, (f1, f2) -> f1 + f2);
    }

    void addReduction(Product product, int numberToBuy, float reduction) {
        product.setReductionValueByNumber(new Tuple2<>(numberToBuy, reduction));
    }

    void removeReductions(Product product) {
        product.setReductionValueByNumber(new Tuple2<>(null, null));
    }
}