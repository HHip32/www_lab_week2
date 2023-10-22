package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "customer")
@NamedQueries(
        @NamedQuery(name = "Customer.getAll", query = "From Customer")
)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "email", length = 150)
    private String email;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "cust_name", length = 150, nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String address, String email, String phone, String name, List<Order> orders) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.orders = orders;
    }

    public Customer(String address, String email, String phone, String name) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }
    public Customer(long id,String address, String email, String phone, String name) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }

    public Customer(long id, String address, String email, String phone, String name, List<Order> orders) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", orders=" + orders +
                '}';
    }
}
