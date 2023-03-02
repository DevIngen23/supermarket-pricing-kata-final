package kata.market.model;

import io.vavr.Tuple2;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
class Supermarket {

    void addReduction(Product product, int numberToBuy, float reduction) {
        product.setReductionValueByNumber(new Tuple2<>(numberToBuy, reduction));
    }

}