package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private BigDecimal amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Account.class, cascade = {CascadeType.ALL})
    private Account source;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Account.class, cascade = {CascadeType.ALL})
    private Account destination;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Account getSource() {
        return source;
    }

    public void setSource(Account source) {
        this.source = source;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", amount=" + amount + ", createdAt=" + createdAt + ", source=" + source + ", destination=" + destination + '}';
    }
    
    
}
