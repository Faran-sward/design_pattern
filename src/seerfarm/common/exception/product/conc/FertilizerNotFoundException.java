package seerfarm.common.exception.product.conc;

import seerfarm.common.exception.product.ProductNotFoundException;

public class FertilizerNotFoundException extends ProductNotFoundException {
    public FertilizerNotFoundException(String message) {
        super(message);
    }
}
