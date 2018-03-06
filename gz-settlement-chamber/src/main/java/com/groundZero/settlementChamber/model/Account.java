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
@Table(name = "GZ_ACCOUNT")
public class Account implements Serializable {

    public static final String TAX = "-: TAX";
    public static final String ROYALTY = "-: ROYALTY";
    
    @Id
    private String id;

    @NotNull
    @Digits(fraction = 2, integer = 10)
    private BigDecimal rest;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "LAST_CHANGED_AT")
    private Date lastChangedAt;

    @NotNull
    @Size(max = 64)
    private String login;
    
    @NotNull
    @Size(max = 32)
    private String password;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", rest=" + rest + ", createdAt=" + createdAt + ", lastChangedAt=" + lastChangedAt + ", login=" + login + ", password=" + password + '}';
    }   

}
