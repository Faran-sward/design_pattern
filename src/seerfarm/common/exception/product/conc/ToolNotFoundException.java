package seerfarm.common.exception.product.conc;

import seerfarm.common.exception.product.ProductNotFoundException;

public class ToolNotFoundException extends ProductNotFoundException {

    public ToolNotFoundException(String message) {
        super(message);
    }
}
