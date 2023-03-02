package kata.market.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupermarketTest {

    private Supermarket superMarket;


    @Test
    public void item_should_correctly_be_updated_when_reduction_created() {
        //given
        superMarket = new Supermarket();
        Product product = new Product(false, null, "washing gel", 50);

        //when
        superMarket.addReduction(product, 2, 0.5f);

        //then
        assertThat(product.getReductionValueByNumber()._1(), is(2));
        assertThat(product.getReductionValueByNumber()._2(), is(0.5f));
    }

    public void item_should_correctly_be_updated_when_reduction_removed() {
        //given
        superMarket = new Supermarket();

        Product product = new Product(false, null, "washing gel", 50);
        superMarket.addReduction(product, 2, 0.5f);

        //when
        superMarket.removeReductions(product);

        //then
        assertThat(product.getReductionValueByNumber()._1(), is(nullValue()));
    }

    @Test
    public void item_reduction_should_correctly_be_replaced_when_new_reduction_created() {
        //given
        superMarket = new Supermarket();
        Product product = new Product(false, null, "washing gel", 50);
        superMarket.addReduction(product, 10, 0.9f);

        //when
        superMarket.addReduction(product, 2, 0.5f);

        //then
        assertThat(product.getReductionValueByNumber()._1(), is(2));
        assertThat(product.getReductionValueByNumber()._2(), is(0.5f));
    }


}