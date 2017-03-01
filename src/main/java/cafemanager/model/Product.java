package cafemanager.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by Sevak on 2/25/2017.
 */
@Entity
@javax.persistence.Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    @NotEmpty(message = "field title is required")
    private String title;

    @Column(name = "price")
    @Min(value = 0, message = "price must be great than 0")
    private double price;
    @OneToOne(mappedBy = "product", cascade = {CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private ProductInOrder productInOrder;

    public Product() {
    }

    public Product(double price, ProductInOrder productInOrder, String title) {
        this.price = price;
        this.productInOrder = productInOrder;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductInOrder getProductInOrder() {
        return productInOrder;
    }

    public void setProductInOrder(ProductInOrder productInOrder) {
        this.productInOrder = productInOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
