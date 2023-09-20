package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;
import java.util.Objects;

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

    public Product(String description, String manufacturer, String name, ProductStatus status, String unit, List<OrderDetail> orderDetails, List<ProductImage> productImageList) {
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
        this.orderDetails = orderDetails;
        this.productImageList = productImageList;
    }

    public Product(long id, String description, String manufacturer, String name, ProductStatus status, String unit, List<OrderDetail> orderDetails, List<ProductImage> productImageList) {
        this.id = id;
        this.description = description;
        this.manufacturer = manufacturer;
        this.name = name;
        this.status = status;
        this.unit = unit;
        this.orderDetails = orderDetails;
        this.productImageList = productImageList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", unit='" + unit + '\'' +
                ", orderDetails=" + orderDetails +
                ", productImageList=" + productImageList +
                '}';
    }
}
