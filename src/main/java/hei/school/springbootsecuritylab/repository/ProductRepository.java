package hei.school.springbootsecuritylab.repository;

import hei.school.springbootsecuritylab.entity.JProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<JProduct, String> {
}
