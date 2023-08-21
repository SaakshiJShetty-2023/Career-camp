package careercamp;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(String message) {
        super(message);
    }
    
    // Other constructors and methods
}

