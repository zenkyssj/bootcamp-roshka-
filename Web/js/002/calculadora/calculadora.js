const screenview = document.querySelector('.contenedor-pantalla');
const buttons = document.querySelectorAll('.btn');
const errorMessage = "Error de Calculo"

buttons.forEach(btn => {
    btn.addEventListener("click", () => {
        const pressedBtn = btn.textContent;

        if (btn.id === "c"){
            screenview.textContent = "0";
            return;
        }

        if (btn.id === "borrar"){
            if (screenview.textContent === 1 || screenview.textContent === errorMessage){
                screenview.textContent = "0";
            } else{
                screenview.textContent = screenview.textContent.slice(0, -1);
            }

            return;
        }

        if (btn.id === "igual"){
            try{
                screenview.textContent = eval(screenview.textContent);
            } catch (Exception){
                screenview.textContent = errorMessage;
                console.log(Exception);
            }

            return;
        }

        if(screenview.textContent === "0" || screenview.textContent === errorMessage) {
            screenview.textContent = pressedBtn;
        } else {
            screenview.textContent += pressedBtn;
        }
    })

})
