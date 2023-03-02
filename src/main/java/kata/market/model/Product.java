package kata.market.model;

import io.vavr.Tuple2;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private boolean byWeight;
    private Tuple2<Integer, Float> reductionValueByNumber;
    private String name;
    private int unitaryPrice;
}
