package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Column(name = "note", length = 255)
    private String note;
    @Column(name = "price", columnDefinition = "DOUBLE", nullable = false)
    private double price;
    @Column(name = "quantity", columnDefinition = "DOUBLE", nullable = false)
    private double quantity;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public OrderDetail() {
    }
}
