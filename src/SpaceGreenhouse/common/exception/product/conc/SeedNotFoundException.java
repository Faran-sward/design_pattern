package SpaceGreenhouse.common.exception.product.conc;

import SpaceGreenhouse.common.exception.product.ProductNotFoundException;

public class SeedNotFoundException extends ProductNotFoundException {
    public SeedNotFoundException(String message) {
        super(message);
    }
}
