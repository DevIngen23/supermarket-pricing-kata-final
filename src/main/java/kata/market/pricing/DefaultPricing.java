package kata.market.pricing;

import kata.market.model.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DefaultPricing extends Pricing {
    public float calculateTotalAmount(Product product, Float number) {
        return (product.getUnitaryPrice() * number);
    }
}
