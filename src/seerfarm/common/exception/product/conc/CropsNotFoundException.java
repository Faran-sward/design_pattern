package seerfarm.common.exception.product.conc;

import seerfarm.common.exception.product.ProductNotFoundException;

public class CropsNotFoundException extends ProductNotFoundException {
    public CropsNotFoundException(String message) {
        super(message);
    }
}
