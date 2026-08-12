package hei.school.springbootsecuritylab.model;

import hei.school.springbootsecuritylab.entity.Product;

import java.math.BigDecimal;

public record JProduct(
        String id,
        String name,
        BigDecimal price,
        int quantity
) {
    public static JProduct fromEntity(Product product) {
        return new JProduct(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity()
        );
    }
}