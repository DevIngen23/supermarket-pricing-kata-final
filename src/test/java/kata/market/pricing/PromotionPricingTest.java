package kata.market.pricing;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import kata.market.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PromotionPricingTest {

    private PromotionPricing promotionPricing;

    @Test
    @Parameters({"2f, 100f",
            "3f, 135f",
            "4f, 185f",
            "6f, 270f"})
    public void should_apply_reduction_when_promotion_number_needed_reached(float inputNumberToBuy, float expectedPrice) {
        //given
        Tuple2<Integer, Float> inputReduction = Tuple.of(3, 0.9f);
        Product anProduct = new Product(true, inputReduction, "item", 50);
        promotionPricing = new PromotionPricing();

        //when
        promotionPricing.calculateTotalAmount(anProduct, inputNumberToBuy);

        //then
        assertThat(promotionPricing.calculateTotalAmount(anProduct, inputNumberToBuy), is(expectedPrice));
    }
}
