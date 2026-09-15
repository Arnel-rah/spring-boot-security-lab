package hei.school.springbootsecuritylab.service.product;

import hei.school.springbootsecuritylab.model.Product;

import java.util.List;

public interface IProductService {

    Product addProduct(Product product);

    Product getProductById(String id);

    void deleteProductById(String id);

    void updateProduct(Product product, String productId);

    List<Product> getAllProducts();

    List<Product> getProductByCategory(String category);

    List<Product> getProductsByBrand(String brand);

    List<Product> getProductsByCategoryAndBrand(String category, String brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String name, String brand);
}