package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
@NamedQueries(
        @NamedQuery(name = "ProductImage.getAll", query = "From ProductImage ")
)
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", columnDefinition = "BIGINT(20)")
    private long imageId;
    @Column(name = "alternative", length = 250)
    private String alternative;
    @Column(name = "path", length = 250, nullable = false)
    private String path;
    @ManyToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

    public ProductImage() {
    }

    public ProductImage(long imageId, Product product) {
        this.imageId = imageId;
        this.product = product;
    }

    public ProductImage(long imageId, String alternative, String path, Product product) {
        this.imageId = imageId;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "imageId=" + imageId +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                ", product=" + product +
                '}';
    }
}
