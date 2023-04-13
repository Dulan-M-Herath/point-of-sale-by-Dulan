package com.example.pointofsalebyDulan.dto;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.ArrayList;

public class CustomerDTO {

    private int id;
    private String name;
    private String nic;
    private double salary;
    private String address;
    private ArrayList tp;
    private boolean isActive;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, String nic, double salary, String address, ArrayList tp, boolean isActive) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.salary = salary;
        this.address = address;
        this.tp = tp;
        this.isActive = isActive;
    }

    public CustomerDTO(String name, String nic, double salary, String address, ArrayList tp, boolean isActive) {
        this.name = name;
        this.nic = nic;
        this.salary = salary;
        this.address = address;
        this.tp = tp;
        this.isActive = isActive;
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
}
