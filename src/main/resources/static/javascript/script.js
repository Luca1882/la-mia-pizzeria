document.getElementById('clienteForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const formData = new FormData(this);

    fetch('/api/clienti', {
        method: 'POST',
        body: formData
    })
    .then(response => {
        if (!response.ok) throw new Error("Errore nella creazione del cliente");
        return response.json();
    })
    .then(cliente => {
        // Inserisci nuovo cliente nel select
        const selectCliente = document.querySelector('select[name="cliente"]');
        const nuovaOption = new Option(cliente.nome, cliente.id);
        selectCliente.add(nuovaOption);
        selectCliente.value = cliente.id;

        // Chiudi il modal
        const modalElement = document.getElementById('clienteModal');
        bootstrap.Modal.getInstance(modalElement).hide();

        // Reset del form del modal
        document.getElementById('clienteForm').reset();
    })
    .catch(error => {
        alert("Errore durante il salvataggio del cliente: " + error.message);
    });
});
