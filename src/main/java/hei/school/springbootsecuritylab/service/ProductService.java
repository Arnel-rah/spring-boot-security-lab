package hei.school.springbootsecuritylab.service;

import hei.school.springbootsecuritylab.entity.Product;
import hei.school.springbootsecuritylab.exception.ResourceNotFoundException;
import hei.school.springbootsecuritylab.model.JProduct;
import hei.school.springbootsecuritylab.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<JProduct> findAll() {
        return repository.findAll().stream()
                .map(JProduct::fromEntity)
                .toList();
    }

    public JProduct findById(String id) {

        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit introuvable avec id " + id));
        return JProduct.fromEntity(product);
    }

    public JProduct create(JProduct dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setQuantity(dto.quantity());
        return JProduct.fromEntity(repository.save(product));
    }

    public JProduct update(String id, JProduct dto) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produit introuvable avec id " + id));
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setQuantity(dto.quantity());
        return JProduct.fromEntity(repository.save(product));
    }

    public void delete(String id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produit introuvable avec id " + id);
        }
        repository.deleteById(id);
    }
}