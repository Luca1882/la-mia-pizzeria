package it.pizzeria.la_mia_pizzeria.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "prenotazione")

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    //Collegamento con cliente
    @ManyToOne
    private Cliente cliente;

    //Collegamento con tavolo
    @ManyToOne
    private Tavolo tavolo;

    //Collegamento con le ordinazioni
    @OneToMany(mappedBy = "prenotazione", cascade = CascadeType.ALL)
    private List<Ordinazione> ordinazioni;

    private LocalDate data;
    private LocalTime ora;
    private int numeroPersone;
    private String causale;

    //Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }
    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOra() {
        return ora;
    }
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public int getNumeroPersone() {
        return numeroPersone;
    }
    public void setNumeroPersone(int numeroPersone) {
        this.numeroPersone = numeroPersone;
    }

    public String getCausale() {
        return causale;
    }
    public void setCausale(String causale) {
        this.causale = causale;
    }
    public List<Ordinazione> getOrdinazioni() {
        return ordinazioni;
    }
    public void setOrdinazioni(List<Ordinazione> ordinazioni) {
        this.ordinazioni = ordinazioni;
    }
}
