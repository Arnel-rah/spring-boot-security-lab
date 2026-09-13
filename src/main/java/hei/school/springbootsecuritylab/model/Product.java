package hei.school.springbootsecuritylab.model;

import java.math.BigDecimal;
import java.util.List;

public record Product(
        String id,
        String name,
        String brand,
        String description,
        Category category,
        BigDecimal price,
        int inventory,
        List<Image> images
) {

}