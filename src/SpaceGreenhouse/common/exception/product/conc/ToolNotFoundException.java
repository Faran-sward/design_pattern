package SpaceGreenhouse.common.exception.product.conc;

import SpaceGreenhouse.common.exception.product.ProductNotFoundException;

public class ToolNotFoundException extends ProductNotFoundException {

    public ToolNotFoundException(String message) {
        super(message);
    }
}
