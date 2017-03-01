package cafemanager.model;

import cafemanager.model.tablestatus.TableStatus;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

/**
 * Created by Sevak on 2/25/2017.
 */
@Entity
@javax.persistence.Table(name = "tables")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "tables_number")
    @Min(value = 1, message = "the number of table must be great than 0")
    private int tableNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User waiter;

    @Column(name = "tables_status")
    @Enumerated(EnumType.STRING)
    private TableStatus tableStatus;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "orderTable")
    private Set<Order> orders;

    public Table() {
    }

    public Table(int tableNumber, TableStatus tableStatus, User waiter, Set<Order> orders) {
        this.tableNumber = tableNumber;
        this.tableStatus = tableStatus;
        this.waiter = waiter;
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", tableNumber=" + tableNumber +
                ", waiter=" + waiter +
                ", tableStatus=" + tableStatus +
                '}';
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
