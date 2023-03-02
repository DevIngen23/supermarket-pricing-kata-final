package kata.market.pricing;

import kata.market.model.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DefaultPricingTest {

    private DefaultPricing pricing;

    @Test
    public void should_calculate_price() {
        //given
        Product product = new Product(true, null, "tomato", 5);
        pricing = new DefaultPricing();
        Float numberToBuy = 2f;

        //when
        pricing.calculateTotalAmount(product, numberToBuy);

        //then
        assertThat(pricing.calculateTotalAmount(product, numberToBuy), is(10f));
    }
}
