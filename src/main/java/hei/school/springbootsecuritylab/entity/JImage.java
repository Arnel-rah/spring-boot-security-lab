package hei.school.springbootsecuritylab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "images")
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