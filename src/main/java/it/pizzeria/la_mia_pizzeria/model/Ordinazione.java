package it.pizzeria.la_mia_pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordinazione")

public class Ordinazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    private Prenotazione prenotazione;

    @ManyToOne
    private Menu piatto;

    private int quantita;
    

    //Getters and Setters

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public Prenotazione getPrenotazione(){
        return prenotazione;
    }
    public void setPrenotazione(Prenotazione prenotazione) {
        this.prenotazione = prenotazione;
    }

    public Menu getPiatto() {
        return piatto;
    }
    public void setPiatto(Menu piatto) {
        this.piatto = piatto;
    }
    
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    
}
