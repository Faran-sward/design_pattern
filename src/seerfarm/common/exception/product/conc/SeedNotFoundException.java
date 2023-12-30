package seerfarm.common.exception.product.conc;

import seerfarm.common.exception.product.ProductNotFoundException;

public class SeedNotFoundException extends ProductNotFoundException {
    public SeedNotFoundException(String message) {
        super(message);
    }
}
