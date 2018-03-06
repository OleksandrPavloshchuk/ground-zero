package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "GZ_GAME")
public class Game implements Serializable {

    @Id
    private String id;

    @NotNull
    @Digits(fraction = 2, integer = 10)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CLOSED_AT")
    private Date closedAt;

    @NotNull
    @Size(max = 64)
    @Column(name = "ACC_1")
    private String accountId1;

    @NotNull
    @Size(max = 64)
    @Column(name = "ACC_2")
    private String accountId2;

    @NotNull
    @Size(max = 64)
    @Column(name = "ACC_3")
    private String accountId3;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public String getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(String accountId1) {
        this.accountId1 = accountId1;
    }

    public String getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(String accountId2) {
        this.accountId2 = accountId2;
    }

    public String getAccountId3() {
        return accountId3;
    }

    public void setAccountId3(String accountId3) {
        this.accountId3 = accountId3;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", amount=" + amount + ", createdAt=" + createdAt + ", closedAt=" + closedAt + ", accountId1=" + accountId1 + ", accountId2=" + accountId2 + ", accountId3=" + accountId3 + '}';
    }
    
    

}
