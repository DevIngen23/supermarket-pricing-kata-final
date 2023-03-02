package kata.market.pricing;

import kata.market.model.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PromotionPricing extends Pricing {
    public float calculateTotalAmount(Product product, Float numberBought) {
        int numberForReduction = product.getReductionValueByNumber()._1();
        int timesReductionApplied = (int) (numberBought / numberForReduction);
        float numberOfFullPriceGoods = numberBought % numberForReduction;
        float reductionValue = product.getReductionValueByNumber()._2();
        float reducedPrice = timesReductionApplied * product.getUnitaryPrice() * numberForReduction * reductionValue;
        float unreducedPrice = numberOfFullPriceGoods * product.getUnitaryPrice();
        return reducedPrice + unreducedPrice;
    }
}
