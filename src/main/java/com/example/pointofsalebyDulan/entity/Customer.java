package com.example.pointofsalebyDulan.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id",length =5)
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "NIC")
    private String nic;

    @Column(name = "customer_salary")
    private double salary;

    @Column(name = "customer_address",length = 20)
    private String address;

    @Type(type = "json")
    @Column(name = "contact_number", columnDefinition = "json")
    private ArrayList tp;

    @Column(name = "active_status")
    private boolean isActive;

    @OneToMany(mappedBy="customer")
    private Set<Order> orderSet;

    public Customer(String name, String nic, double salary, String address, ArrayList tp, boolean isActive) {
        this.name = name;
        this.nic = nic;
        this.salary = salary;
        this.address = address;
        this.tp = tp;
        this.isActive = isActive;
    }

    public Customer(int id, String name, String nic, double salary, String address, ArrayList tp, boolean isActive) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.salary = salary;
        this.address = address;
        this.tp = tp;
        this.isActive = isActive;
    }


    public Customer() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList getTp() {
        return tp;
    }

    public void setTp(ArrayList tp) {
        this.tp = tp;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", tp=" + tp +
                ", isActive=" + isActive +
                '}';
    }
}
