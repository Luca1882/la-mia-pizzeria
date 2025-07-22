package it.pizzeria.la_mia_pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tavolo")

public class Tavolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int numeroPosti;
    private int postiMassimi;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id =id;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public int getPostiMassimi(){
        return postiMassimi;
    }

    public void setPostiMassimi(int postiMassimi) {
        this.postiMassimi = postiMassimi;
    }

}
