package service;
import exceptions.ProductNotFoundException;
import model.Product;
import java.util.List;
public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
