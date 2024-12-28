package com.biling.biling.entity;

import com.biling.biling.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateFacture;
    private Long customerId;
    private String customerName;

    @OneToMany(mappedBy = "facture")
    private List<ProduitItems> produitItems = new ArrayList<ProduitItems>();
    @Transient
    private CustomerDto customer;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        dateFacture = dateFacture;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<ProduitItems> getProduitItems() {
        return produitItems;
    }

    public void setProduitItems(List<ProduitItems> produitItems) {
        this.produitItems = produitItems;
    }
}
