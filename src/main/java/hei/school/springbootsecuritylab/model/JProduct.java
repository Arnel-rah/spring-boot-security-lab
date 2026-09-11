package hei.school.springbootsecuritylab.model;

import hei.school.springbootsecuritylab.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public record JProduct(
        String id,
        String name,
        String brand,
        String description,
        Jcategory category,
        BigDecimal price,
        int inventory,
        List<Jimage> images
) {

}