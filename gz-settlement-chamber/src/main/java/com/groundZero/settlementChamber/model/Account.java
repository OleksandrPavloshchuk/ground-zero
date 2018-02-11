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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Account implements Serializable {
    
    public enum Type {
        IN, OUT, TAX, PROFIT, GAME, DEPOSIT
    }
    
    @Id
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
    
    
}
