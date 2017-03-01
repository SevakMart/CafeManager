package cafemanager.model;

import cafemanager.model.orderstatus.OrderStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Entity
@javax.persistence.Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "orders_status")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "tables_id")
    private Table orderTable;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "productOrder")
    private List<ProductInOrder> productInOrderList;

    public Order() {
    }

    public Order(OrderStatus orderStatus, Table orderTable, List<ProductInOrder> productInOrderList) {
        this.orderStatus = orderStatus;
        this.orderTable = orderTable;
        this.productInOrderList = productInOrderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Table getTable() {
        return orderTable;
    }

    public void setTable(Table table) {
        this.orderTable = table;
    }

    public List<ProductInOrder> getProductInOrderList() {
        return productInOrderList;
    }

    public void setProductInOrderList(List<ProductInOrder> productInOrderList) {
        this.productInOrderList = productInOrderList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                ", orderTable=" + orderTable +
                '}';
    }
}
