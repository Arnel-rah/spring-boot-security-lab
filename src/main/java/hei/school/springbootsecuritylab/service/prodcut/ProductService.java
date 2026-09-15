package hei.school.springbootsecuritylab.service.prodcut;

import hei.school.springbootsecuritylab.entity.JCategory;
import hei.school.springbootsecuritylab.entity.JProduct;
import hei.school.springbootsecuritylab.model.Category;
import hei.school.springbootsecuritylab.model.Image;
import hei.school.springbootsecuritylab.model.Product;
import hei.school.springbootsecuritylab.repository.ProductRepository;
import hei.school.springbootsecuritylab.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        JProduct saved = productRepository.save(toEntity(product));
        return toModel(saved);
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    @Override
    public void deleteProductById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Product product, String productId) {
        JProduct existing = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        existing.setName(product.name());
        existing.setBrand(product.brand());
        existing.setDescription(product.description());
        existing.setPrice(product.price());
        existing.setInventory(product.inventory());

        productRepository.save(existing);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory_Name(category).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategory_NameAndBrand(category, brand).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndNameContainingIgnoreCase(brand, name).stream()
                .map(this::toModel)
                .toList();
    }

    @Override
    public Long countProductsByBrandAndName(String name, String brand) {
        return productRepository.countByBrandAndNameContainingIgnoreCase(brand, name);
    }

    private Product toModel(JProduct entity) {
        Category category = entity.getCategory() != null
                ? new Category(entity.getCategory().getId(), entity.getCategory().getName())
                : null;

        List<Image> images = entity.getImages() != null
                ? entity.getImages().stream()
                .map(img -> new Image(
                        img.getId(),
                        img.getFilePath(),
                        img.getFileType(),
                        img.getDownloadUrl()
                ))
                .toList()
                : List.of();

        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getBrand(),
                entity.getDescription(),
                category,
                entity.getPrice(),
                entity.getInventory(),
                images
        );
    }

    private JProduct toEntity(Product product) {
        JCategory category = null;
        if (product.category() != null) {
            category = JCategory.builder()
                    .id(product.category().id())
                    .name(product.category().name())
                    .build();
        }

        return JProduct.builder()
                .id(product.id())
                .name(product.name())
                .brand(product.brand())
                .description(product.description())
                .category(category)
                .price(product.price())
                .inventory(product.inventory())
                .build();
    }
}