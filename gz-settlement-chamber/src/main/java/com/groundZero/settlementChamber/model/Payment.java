package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;

@Entity
@Table(name = "GZ_PAYMENT")
public class Payment implements Serializable {

    @Id
    @Size(max = 64)
    private String id;

    @NotNull
    @Digits(fraction = 2, integer = 10)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @NotNull
    @Size(max = 64)
    @Column(name = "SOURCE_ID", length = 64)
    private String sourceId;

    @NotNull
    @Size(max = 64)
    @Column(name = "DESTINATION_ID", length = 64)
    private String destinationId;

    public Payment() {

    }

    public Payment(String sourceId, String destinationId, BigDecimal amount) {
        id = UUID.randomUUID().toString().replace("-", "");
        createdAt = Calendar.getInstance().getTime();
        this.destinationId = destinationId;
        this.sourceId = sourceId;
        this.amount = amount;
    }

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

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", amount=" + amount + ", createdAt=" + createdAt + ", sourceId=" + sourceId + ", destinationId=" + destinationId + '}';
    }

}
