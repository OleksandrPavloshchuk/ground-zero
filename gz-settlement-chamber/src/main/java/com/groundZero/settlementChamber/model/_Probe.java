package com.groundZero.settlementChamber.model;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TEMP_PROBE")
public class _Probe implements Serializable {

    @Id
    private String id;
    
    @NotNull
    private String name;
    
    public _Probe() {
        
    }
    
    public _Probe(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "_Probe{" + "id=" + id + ", name=" + name + '}';
    }
    
}
