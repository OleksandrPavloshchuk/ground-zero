package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Owner implements Serializable {

    public enum Type {
        PLAYER, SYSTEM
    }

    public enum State {
        ACTIVE, SUSPENDED, DELETED
    }

    @Id
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

}
