package hei.school.springbootsecuritylab.controller.product;

import hei.school.springbootsecuritylab.model.Product;
import hei.school.springbootsecuritylab.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product created = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id, @RequestBody Product product) {
        productService.updateProduct(product, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        return ResponseEntity.ok(productService.getProductByCategory(category));
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByBrand(@PathVariable String brand) {
        return ResponseEntity.ok(productService.getProductsByBrand(brand));
    }

    @GetMapping("/category/{category}/brand/{brand}")
    public ResponseEntity<List<Product>> getProductsByCategoryAndBrand(
            @PathVariable String category,
            @PathVariable String brand
    ) {
        return ResponseEntity.ok(productService.getProductsByCategoryAndBrand(category, brand));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        return ResponseEntity.ok(productService.getProductsByName(name));
    }

    @GetMapping("/brand/{brand}/search")
    public ResponseEntity<List<Product>> getProductsByBrandAndName(
            @PathVariable String brand,
            @RequestParam String name
    ) {
        return ResponseEntity.ok(productService.getProductsByBrandAndName(brand, name));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countProductsByBrandAndName(
            @RequestParam String brand,
            @RequestParam String name
    ) {
        return ResponseEntity.ok(productService.countProductsByBrandAndName(name, brand));
    }
}