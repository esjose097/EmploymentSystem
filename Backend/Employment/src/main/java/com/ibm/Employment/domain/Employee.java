package com.ibm.Employment.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase de dominio que representa un empleado.
 * @author jose casal
 * C:\Users\jose casal\.m2\repository\mysql\mysql-connector-java\8.0.29\mysql-connector-java-8.0.29.jar
 */
@Entity
@Table(name = "employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="firstName", nullable = false, length = 100)
    private String firstName;
    
    @Column(name="middleName", nullable = true, length = 100)
    private String middleName;
    
    @Column(name = "lastName", nullable = false, length = 100)
    private String lastName;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;
    
    @Column(name = "position", nullable = false, length = 100)
    private String position;
    
    @OneToMany(mappedBy = "compensation", cascade = CascadeType.ALL)
    private List<Compensation> compensations;

    /**
     * Constructor por defecto de la entidad, se encarga de crear una entidad
     * vacia e instanciar el atributo compensations con una ArrayList vacia.
     */
    public Employee() {
        this.compensations = new ArrayList<Compensation>();
    }    
    
    /**
     * Contructor de la clase, encargado de asignar todos los parametros a la clase y crear
     * una instancia de la misma.
     * @param id <-- ID del empleado.
     * @param firstName <-- Primer nombre del empleado.
     * @param middleName <-- Segundo nombre del empleado si es que tiene.
     * @param lastName <-- Apellidos del empleado.
     * @param birthDate <-- Fecha de nacimiento.
     * @param position <-- Puesto de trabajo del empleado.
     * @param compensations <-- Una lista de compensaciones del empleado.
     */
    public Employee(Long id, String firstName, String middleName, String lastName, Date birthDate, String position, ArrayList<Compensation> compensations) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;
        this.compensations = compensations;
    }
    
    /**
     * Constructor de la clase empleado que instancia todos los atributos de la clase
     * menos el ID.
     * @param firstName <-- Primer nombre del empleado.
     * @param middleName <-- Segundo nombre del empleado si es que tiene.
     * @param lastName <-- Apellidos del empleado.
     * @param birthDate <-- Fecha de nacimiento.
     * @param position <-- Puesto de trabajo del empleado.
     * @param compensations <-- Una lista de compensaciones del empleado.
     */
    public Employee(String firstName, String middleName, String lastName, Date birthDate, String position, ArrayList<Compensation> compensations) {
        this();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.position = position;
        this.compensations = compensations;
    }

    /**
     * Método get que devuelve el atrubuto id de la clase.
     * @return ID
     */
    public Long getId() {
        return id;
    }
    /**
     * Método set que asigna el atributo ID de la clase.
     * @param id <-- id del empleado.
     */
    public void setId(Long id) {
        this.id = id;
    }        
    /**
     * Método get que regresa el atributo firstName de la clase.
     * @return firstName.
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * Método set que asigna el atributo firstName a la clase.
     * @param firstName <-- Primer nombre.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * Metodo get que obtiene el atributo middleName de la clase.
     * @return middleName.
     */
    public String getMiddleName() {
        return middleName;
    }
    /**
     * Metodo set que asigna el atributo middleName a la clase.
     * @param middleName <-- Segundo nombre del empleado.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    /**
     * Metodo get que obtiene el atributo lastName de la clase.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Metodo set que asigna el atributo lastName a la clase.
     * @param lastName <-- Apellido del empleado.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * Metodo get que obtiene el atributo birthDay de la clase.
     * @return birthDay
     */
    public Date getBirthDate() {
        return birthDate;
    }
    /**
     * Metodo set que asigna el atributo birthDay a la clase.
     * @param birthDate <-- fecha de cumpleaños.
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    /**
     * Metodo get que obtiene el atributo position de la clase.
     * @return position
     */
    public String getPosition() {
        return position;
    }
    /**
     * Método set que asigna el atributo position a la clase.
     * @param position <-- posicion del empleado.
     */
    public void setPosition(String position) {
        this.position = position;
    }
    /**
     * Metodo get que obtiene el atributo compensations de la clase.
     * @return compensations.
     */
    public List<Compensation> getCompensations() {
        return compensations;
    }
    /**
     * Metodo set que asigna el atributo compensations a la clase.
     * @param compensations <-- Lista de compensaciones del empleado.
     */
    public void setCompensations(List<Compensation> compensations) {
        this.compensations = compensations;
    }
    /**
     * Metodo encargado de agregar una compensation a la lista de compensations.
     * @param compensation <--Compensación que se desea agregar.
     */
    public void addCompensation(Compensation compensation){
        this.compensations.add(compensation);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Employee other = (Employee) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", position=" + position + '}';
    }        
}
