
function getInnerHtml(id, str){
    const element = document.getElementById(id);

    if (element){
        element.innerHTML = str;
    } else {
        console.error("No se encontro un elemento con el ID: " + id);
    }
}
