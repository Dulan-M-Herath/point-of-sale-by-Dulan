package com.example.pointofsalebyDulan.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Table(name = "orders")
@TypeDefs(
        @TypeDef(name = "json",typeClass= JsonType.class)
)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    @Id
    @Column(name = "order_id")
    private int orderId;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total",length = 10)
    private double amount;

    @OneToMany(mappedBy="orders")
    private Set<OrderDetails> orderDetails;

    @Column(name = "active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;


    public Order(Customer customer, Date date, double amount) {
        this.customer = customer;
        this.date = date;
        this.amount = amount;
    }
}
