package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description", length = 250, nullable = false)
    private String description;
    @Column(name = "manufacturer_name", length = 100, nullable = false)
    private String manufacturer;
    @Column(name = "name", length = 150, nullable = false)
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private ProductStatus status;
    @Column(name = "unit", length = 25, nullable = false)
    private String unit;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImageList;

    public Product() {
    }
}
