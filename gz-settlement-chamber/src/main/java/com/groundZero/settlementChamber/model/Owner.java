package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

//@Entity
//@Table(name = "GZ_OWNER")
public class Owner implements Serializable {

    public enum Type {
        PLAYER, SYSTEM
    }

    public enum State {
        ACTIVE, SUSPENDED, DELETED
    }

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String login;
    private String password;
    private Type type;
    private State ownerState;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Account.class, cascade = {CascadeType.ALL})
    private List<Account> accounts;

    public Owner() {

    }

    public Owner(String login, String password) {
        type = Type.PLAYER;
        ownerState = State.ACTIVE;
        this.login = login;
        this.password = password;
        this.id = UUID.randomUUID().toString();
        accounts = new ArrayList<>();
        createdAt = new Date();
    }

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public State getOwnerState() {
        return ownerState;
    }

    public void setOwnerState(State ownerState) {
        this.ownerState = ownerState;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Owner{" + "id=" + id + ", createdAt=" + createdAt 
                + ", login=" + login + ", password=" + password + ", type=" 
                + type + ", ownerState=" + ownerState 
                // + ", accounts=" + accounts 
                + '}';
    }
    
    

}
