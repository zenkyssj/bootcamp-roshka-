document.addEventListener('DOMContentLoaded', () => {
    const container = document.createElement('div');
    container.className = 'container';
    document.body.appendChild(container);

    const titleContainer = document.createElement('div');
    titleContainer.className = 'title-container';
    container.appendChild(titleContainer);

    const btn = document.createElement('button');
    btn.className = 'btn';
    btn.textContent = 'Generar Dados';
    titleContainer.appendChild(btn);

    const numberGenerated = document.createElement('div');
    numberGenerated.className = 'number-container';
    titleContainer.appendChild(numberGenerated);

    const dadosContainer = document.createElement('div');
    dadosContainer.className = 'dados-container';
    container.appendChild(dadosContainer);

    btn.addEventListener('click', () => {
        dadosContainer.innerHTML = '';
        const totalDados = 5;
        let totalNumbers = [];
        for (let i = 0; i < totalDados; i++) {
            const dado = document.createElement('div');
            dado.className = 'dado';
        
            let diceRoll = Math.floor(Math.random() * 6) + 1;
            totalNumbers.push(diceRoll);

            const filas = Math.ceil(diceRoll / 3);
            for (let fila = 0; fila < filas; fila++) {
                const rowDiv = document.createElement('div');
            
                rowDiv.style.gridColumn = '1 / -1';

                let cantidad = (fila === filas - 1) ? diceRoll - fila * 3 : 3;
                rowDiv.textContent = '*'.repeat(cantidad);
                dado.appendChild(rowDiv);
            }
            dadosContainer.appendChild(dado);
        }

        numberGenerated.textContent = "Dados Generados: " + totalNumbers;
    });
});