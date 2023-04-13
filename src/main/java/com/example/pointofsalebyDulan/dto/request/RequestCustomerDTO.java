package com.example.pointofsalebyDulan.dto.request;

public class RequestCustomerDTO {
    private int id;
    private String name;
    private String nic;
    private double salary;

    public RequestCustomerDTO(int id, String name, String nic, double salary) {
        this.id = id;
        this.name = name;
        this.nic = nic;
        this.salary = salary;
    }

    public RequestCustomerDTO() {
    }

    @Override
    public String toString() {
        return "RequestCustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", salary=" + salary +
                '}';
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
}
