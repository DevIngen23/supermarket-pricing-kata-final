package kata.market.pricing;

import kata.market.model.Product;
import lombok.Data;

@Data
public abstract class Pricing {

    public abstract float calculateTotalAmount(Product product, Float numberBought);

}
