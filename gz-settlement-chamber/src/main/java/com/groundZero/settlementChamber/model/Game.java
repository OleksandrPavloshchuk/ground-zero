package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

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

    @ElementCollection
    @CollectionTable(name = "GZ_PLAYER", joinColumns = @JoinColumn(name = "GAME_ID"))
    private Set<String> accounts;

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

    public Set<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<String> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", amount=" + amount + ", createdAt=" + createdAt + ", closedAt=" + closedAt + ", accounts=" + accounts + '}';
    }
}
