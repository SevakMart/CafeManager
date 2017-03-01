package cafemanager.model;

import cafemanager.model.userrole.Roles;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Entity
@javax.persistence.Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "field username is required")
    @Column(name = "username")
    private String userName;
    @NotEmpty(message = "field password is required")
    @Column(name = "password")
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "waiter",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Table> tables;

    public User() {
    }

    public User(String password, Roles role, List<Table> tables, String userName) {
        this.password = password;
        this.role = role;
        this.tables = tables;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
