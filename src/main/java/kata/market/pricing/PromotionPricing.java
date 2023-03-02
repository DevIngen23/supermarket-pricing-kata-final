package kata.market.pricing;

import kata.market.model.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PromotionPricing extends Pricing {
    public float calculateTotalAmount(Product product, Float numberBought) {
        return 0f;
    }
}
