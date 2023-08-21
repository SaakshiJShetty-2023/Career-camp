package careercamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class ProductDatabase {

private List<Product> products;

public ProductDatabase() {
    products = new ArrayList<>();
}

public void addProduct(Product product) {
    products.add(product);
}

public List<Product> getAllProducts() {
    return products;
}

public void deleteProduct(int prodId) throws ProductNotFoundException {
    Product productToRemove = null;
    for (Product product : products) {
        if (product.getProdId() == prodId) {
            productToRemove = product;
            break;
        }
    }
    if (productToRemove != null) {
        products.remove(productToRemove);
    } else {
        throw new ProductNotFoundException("Product with ID " + prodId + " not found.");
    }
}

public void updateProduct(Product updatedProduct) throws ProductNotFoundException {
    boolean found = false;
    for (int i = 0; i < products.size(); i++) {
        Product product = products.get(i);
        if (product.getProdId() == updatedProduct.getProdId()) {
            products.set(i, updatedProduct);
            found = true;
            break;
        }
    }
    if (!found) {
        throw new ProductNotFoundException("Product with ID " + updatedProduct.getProdId() + " not found.");
    }
}

public Product searchProductById(int prodId) throws ProductNotFoundException {
    for (Product product : products) {
        if (product.getProdId() == prodId) {
            return product;
        }
    }
    throw new ProductNotFoundException("Product with ID " + prodId + " not found.");
}

public List<Product> searchProductByName(String prodName) throws ProductNotFoundException {
    List<Product> foundProducts = new ArrayList<>();
    for (Product product : products) {
        if (product.getProdName().equalsIgnoreCase(prodName)) {
            foundProducts.add(product);
        }
    }
    if (foundProducts.isEmpty()) {
        throw new ProductNotFoundException("Product with name '" + prodName + "' not found.");
    }
    return foundProducts;
}

public List<Product> getProductsByPrice(boolean ascending) {
    List<Product> sortedProducts = new ArrayList<>(products);
    if (ascending) {
        Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getPrice));
    } else {
        Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getPrice).reversed());
    }
    return sortedProducts;
}



public List<Product> getProductsByDiscount(boolean ascending) {
    List<Product> sortedProducts = new ArrayList<>(products);
    if (ascending) {
        Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getDiscount));
    } else {
        Collections.sort(sortedProducts, Comparator.comparingDouble(Product::getDiscount).reversed());
    }
    return sortedProducts;
}
}
