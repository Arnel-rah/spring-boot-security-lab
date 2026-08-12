package hei.school.springbootsecuritylab.repository;

import hei.school.springbootsecuritylab.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
