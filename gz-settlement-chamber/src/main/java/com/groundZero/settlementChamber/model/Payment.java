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
}
