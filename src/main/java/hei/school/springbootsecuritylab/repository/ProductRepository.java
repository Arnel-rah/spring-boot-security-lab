package hei.school.springbootsecuritylab.repository;

import hei.school.springbootsecuritylab.entity.JProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<JProduct, String> {
    List<JProduct> findByCategory_Name(String categoryName);
    List<JProduct> findByBrand(String brand);
    List<JProduct> findByCategory_NameAndBrand(String categoryName, String brand);
    List<JProduct> findByNameContainingIgnoreCase(String name);
    List<JProduct> findByBrandAndNameContainingIgnoreCase(String brand, String name);
    Long countByBrandAndNameContainingIgnoreCase(String brand, String name);
}
