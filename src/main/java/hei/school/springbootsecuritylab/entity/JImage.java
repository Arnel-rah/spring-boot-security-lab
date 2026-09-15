package hei.school.springbootsecuritylab.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
@Builder
public class JImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String filePath;
    private String fileType;
    private String downloadUrl;

    @Lob
    @Column(columnDefinition = "bytea")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private JProduct product;
}