package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name = "GZ_ACCOUNT")
public class Account implements Serializable {
    
    public enum Type {
        IN, OUT, TAX, PROFIT, GAME, DEPOSIT
    }
    
    @Id
    @NotNull    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private BigDecimal rest;
    private Type type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastChangedAt;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Owner.class, cascade = {CascadeType.ALL})
    private Owner owner;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Payment.class, cascade = {CascadeType.ALL})
    private List<Payment> payments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getRest() {
        return rest;
    }

    public void setRest(BigDecimal rest) {
        this.rest = rest;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastChangedAt() {
        return lastChangedAt;
    }

    public void setLastChangedAt(Date lastChangedAt) {
        this.lastChangedAt = lastChangedAt;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", rest=" + rest + ", type=" + type + ", createdAt=" + createdAt + ", lastChangedAt=" + lastChangedAt + ", owner=" + owner + ", payments=" + payments + '}';
    }
    
    
}
