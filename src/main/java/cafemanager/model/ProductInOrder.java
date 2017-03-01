package cafemanager.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Sevak on 2/25/2017.
 */

@Entity
@javax.persistence.Table(name = "product_in_orders")
public class ProductInOrder implements Serializable {


    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Order productOrder;

    @Id
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "amount")
    private int amount;

    public ProductInOrder(int amount, Order productOrder, Product product) {
        this.amount = amount;
        this.productOrder = productOrder;
        this.product = product;
    }

    public ProductInOrder() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Order getProductOrder() {
        return productOrder;
    }

    public void setProductOrder(Order productOrder) {
        this.productOrder = productOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductInOrder{" +
                "amount=" + amount +
                ", productOrder=" + productOrder +
                ", product=" + product +
                '}';
    }
}
