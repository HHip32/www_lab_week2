package vn.edu.iuh.fit.backend.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.converters.ConvertEmployeeStatus;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee")
@NamedQueries({
        @NamedQuery(name = "Employee.getAll", query = "FROM Employee where status = ?1"),
        @NamedQuery(name = "Employee.updateStatus", query = "UPDATE Employee SET status = :status WHERE id = :id")
})
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "address", length = 250, nullable = false)
    private String address;
    @Column(name = "dob", nullable = false)
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dob;
    @Column(name = "email", length = 150)
    private String email;
    @Column(name = "full_name", length = 150, nullable = false)
    private String fullName;
    @Column(name = "phone", length = 15, nullable = false)
    private String phone;
    @Column(name = "status", nullable = false)
    @Convert(converter = ConvertEmployeeStatus.class)
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Employee() {
    }

    public Employee(String address, LocalDate dob, String email, String fullName, String phone, EmployeeStatus status) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public Employee(long id, String address, LocalDate dob, String email, String fullName, String phone, EmployeeStatus status) {
        this.id = id;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
