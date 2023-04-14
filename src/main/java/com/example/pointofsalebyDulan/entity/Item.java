package com.example.pointofsalebyDulan.entity;

import com.example.pointofsalebyDulan.entity.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "Item")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data // getter+setter+toString()
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Item_Id")
    private int id;

    @Column(name = "Item_name",nullable = false,length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type",nullable = false, length = 100)
    private MeasuringType measuringType;

    @Column(name = "balance_qty",length = 10)
    private double balanceQty;

    @Column(name = "supplier_price",length = 10)
    private double suplierPrice;

    @Column(name = "selling_price", length = 10)
    private double sellingPrice;

    @Column(name = "active_status")
    private boolean activeStatus;

}
