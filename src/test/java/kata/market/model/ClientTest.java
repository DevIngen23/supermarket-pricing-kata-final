package kata.market.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClientTest {
    private Product washingGel, tomato;
    private Client client;

    @Test
    public void should_add_to_cart_when_added() {
        //given
        client = new Client();
        washingGel = new Product(false, null, "sweep", 50);
        tomato = new Product(true, null, "potato", 5);

        //when
        client.addToCart(washingGel, 1f);
        client.addToCart(tomato, 1.2f);

        //then
        assertThat(client.getCart().toString(), is("{" + washingGel.toString() + "=1.0, " + tomato.toString() + "=1.2}"));
    }

    @Test
    public void should_update_value_in_cart_when_added_twice() {
        //given
        client = new Client();
        washingGel = new Product(false, null, "sweep", 50);
        tomato = new Product(true, null, "potato", 5);

        //when
        client.addToCart(washingGel, 1f);
        client.addToCart(tomato, 1.2f);
        client.addToCart(washingGel, 1f);

        //then
        assertThat(client.getCart().toString(), is("{" + washingGel.toString() + "=2.0, " + tomato.toString() + "=1.2}"));
    }
}
