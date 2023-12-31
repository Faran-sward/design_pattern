package SpaceGreenhouse.common.exception.product.conc;

import SpaceGreenhouse.common.exception.product.ProductNotFoundException;

public class FertilizerNotFoundException extends ProductNotFoundException {
    public FertilizerNotFoundException(String message) {
        super(message);
    }
}
