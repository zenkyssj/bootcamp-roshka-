
function getInnerHtml(id){
    const element = document.getElementById(id);
    const random = Math.floor(Math.random() * 100);

    if (element){
        element.innerHTML = random;
    } else {
        console.error("No se encontro un elemento con el ID: " + id);
    }

}