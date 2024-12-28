package com.biling.biling.entity;

import com.biling.biling.dto.ProduitDto;
import jakarta.persistence.*;

@Entity
public class ProduitItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long produitId;
    @ManyToOne
    private Facture facture;
    private int quantity;
    private Double price;
    @Transient
    private ProduitDto produit;



    public ProduitDto getProduit() {
        return produit;
    }

    public void setProduit(ProduitDto produit) {
        this.produit = produit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
