# 🍕 La Mia Pizzeria

**Gestione completa delle prenotazioni e degli ordini per una pizzeria.**  
Web application sviluppata con **Java + Spring Boot + Thymeleaf + MySQL**.

---

## 🚀 Funzionalità principali

- Gestione delle **prenotazioni**: cliente, data, tavolo, orario, causale (pranzo/cena), numero persone
- CRUD completo per i **clienti**, i **tavoli**, e il **menù**
- Visualizzazione prenotazioni per **giorno**
- Collegamento diretto ai **contatti WhatsApp** del cliente
- CRUD delle **ordinazioni** con selezione dei piatti dal menu

---

## 🧰 Tecnologie utilizzate

| Livello | Stack |
|--------|------|
| Backend | Java 17, Spring Boot, Spring Data JPA, Hibernate |
| Frontend | Thymeleaf, Bootstrap (opzionale) |
| Database | MySQL |
| Build Tool | Maven |
| Altro | Lombok, Spring Validation, Git |

---

## 🗂️ Struttura progetto

la-mia-pizzeria/
├── .mvn/                          # Wrapper Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── it/pizzeria/la_mia_pizzeria/
|   |   |       ├── model/         # Classi delle entità: Cliente, Menu, Prenotazione, Tavolo, Ordinazione
│   │   │       ├── repository/    # Interfacce JPA per accesso al DB
│   │   │       ├── service/       # Logica di business
│   │   │       └── controller/    # Controller Spring MVC
│   │   └── resources/
│   │       ├── templates/         # File Thymeleaf (HTML)
│   │       ├── static/            # File statici (CSS, JS, immagini)
│   │       └── application.properties
│
├── target/                        # Cartella generata da Maven (esclusa da Git)
├── pom.xml                        # File di configurazione Maven
└── README.md
