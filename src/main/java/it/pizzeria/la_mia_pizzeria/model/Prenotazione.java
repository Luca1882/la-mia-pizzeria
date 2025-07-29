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
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "prenotazione")

public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    //Collegamento con cliente
    @NotNull(message = "Il cliente è obbligatorio")
    @ManyToOne
    private Cliente cliente;

    //Collegamento con tavolo
    @NotNull(message = "Il tavolo è obbligatorio")
    @ManyToOne
    private Tavolo tavolo;

    //Collegamento con le ordinazioni
    @OneToMany(mappedBy = "prenotazione", cascade = CascadeType.ALL)
    private List<Ordinazione> ordinazioni;

    @NotNull(message = "La data è obbligatoria")
    @FutureOrPresent(message = "La data deve essere nel presente o futuro")
    private LocalDate data;
    
    @NotNull(message = "L'ora è obbligatoria")
    @FutureOrPresent(message = "L'ora deve essere nel presente o futuro")
    private LocalTime ora;

    @NotNull(message = "Il numero di persone è obbligatorio")
    @Min(value = 1, message = "Il numero di persone deve essere almeno 1")
    @Max(value = 30, message = "Il numero di persone non può superare 30")
    private int numeroPersone;

    @NotNull(message = "La causale è obbligatoria")
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
