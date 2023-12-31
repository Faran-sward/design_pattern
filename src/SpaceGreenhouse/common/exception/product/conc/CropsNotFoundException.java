package SpaceGreenhouse.common.exception.product.conc;

import SpaceGreenhouse.common.exception.product.ProductNotFoundException;

public class CropsNotFoundException extends ProductNotFoundException {
    public CropsNotFoundException(String message) {
        super(message);
    }
}
