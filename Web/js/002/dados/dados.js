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
            let randomNum = Math.floor(Math.random() * 6) + 1;
            for (let i = 0; i < randomNum; i++) {
            const dado = document.createElement('div');
            let dadoNumber = document.createElement('div');

            numberGenerated.textContent = randomNum + " dados generados";
            dado.className = 'dado';
            
            dadoNumber.textContent = '*'.repeat(i+1);
            
            dado.appendChild(dadoNumber);
            dadosContainer.appendChild(dado);
        }
    })
})