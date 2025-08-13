function calcular_cuadratica_suma(a, b, c){
    let discriminante = Math.pow(b,2) - (4 * a * c);
    if (discriminante < 0) {
        return "No hay soluciones reales";
    }
    return (-b + Math.sqrt(discriminante)) / (2 * a);
}

function calcular_cuadratica_resta(a, b, c){
    let discriminante = Math.pow(b,2) - (4 * a * c);
    if (discriminante < 0) {
        return "No hay soluciones reales";
    }
    return (-b - Math.sqrt(discriminante)) / (2 * a);
}

console.log("Resultado x1: " + calcular_cuadratica_suma(1, 5, 6));
console.log("Resultado x2: " + calcular_cuadratica_resta(1, 5, 6));