package com.ibm.Employment.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase del Dominio que representa una compensación.
 * @author jose casal
 */
@Entity
@Table(name = "compensation")
public class Compensation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="type", nullable = false, length = 100)
    private String type;
    
    @Column(name = "amount")
    private Double amount;
    
    @Column(name = "description", nullable = true)
    private String description;
    
    @Column()
    private Date date;
    private Employee employee;

    public Compensation() {
    }    

    public Compensation(Long id, String type, Double amount, String description, Date date, Employee employee) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.employee = employee;
    }
    
    public Compensation(String type, Double amount, String description, Date date, Employee employee) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }        

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }        

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compensation other = (Compensation) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Compensation{" + "id=" + id + ", type=" + type + ", amount=" + amount + ", description=" + description + ", date=" + date + '}';
    }        
}
