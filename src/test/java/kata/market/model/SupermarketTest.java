package kata.market.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SupermarketTest {

    private Supermarket superMarket;
    private Client client;


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


    @Test
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
    public void price_should_be_correct_when_calculating_total_price() {
        //given
        superMarket = new Supermarket();
        client = new Client();
        Product washingGel = new Product(false, null, "washing gel", 50);
        Product tomato = new Product(true, null, "tomato", 5);
        Product soap = new Product(false, null, "soap", 10);
        client.addToCart(washingGel, 4f);
        client.addToCart(tomato, 2.2f);
        client.addToCart(soap, 3f);
        superMarket.addReduction(soap, 2, 0.5f);

        //when
        superMarket.calculateTotalAmount(client);
        //then
        assertThat(superMarket.calculateTotalAmount(client), is(231.0f));
    }

}