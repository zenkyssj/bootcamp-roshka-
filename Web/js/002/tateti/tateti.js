const placeContainer = document.querySelector('.place-container');
const places = document.querySelectorAll('.place');
const playerContainer = document.querySelector('.player-container');
const restartButton = document.querySelector('.restart');

let actualPlayer = "Jugador 1";
let gameOver = false;

const noHover = 

playerContainer.innerText = "Turno de " + actualPlayer;

places.forEach((place) => {
    place.addEventListener("click", () => {
        if (gameOver) return;

        place.innerText = actualPlayer === "Jugador 1" ? "X" : "O";

        if (isWinner()) {
            playerContainer.innerText = actualPlayer + " es el ganador.";
            gameOver = true;
            placeContainer.classList.add("no-hover");
            return;
        }

        if (Array.from(places).every(p => p.innerText)){
            playerContainer.innerText = "Empate.";
            gameOver = true;
            placeContainer.classList.add("no-hover");
            return;
        }

        actualPlayer = actualPlayer === "Jugador 1" ? "Jugador 2" : "Jugador 1";
        playerContainer.innerText = "Turno de " + actualPlayer;

    })
});

restartButton.addEventListener("click", () => {
    places.forEach(p => {
        p.innerText = "";
        p.classList.remove("show-winner");
    });
    actualPlayer = "Jugador 1";
    playerContainer.innerText = "Turno de " + actualPlayer;
    gameOver = false;
    placeContainer.classList.remove("no-hover");
});

function isWinner() {
    const placesArray = Array.from(places).map(place => place.innerText);
    console.log(placesArray);

    for (let i = 0; i < 9; i += 3) {
        if (placesArray[i] &&
            placesArray[i] === placesArray[i + 1] &&
            placesArray[i] === placesArray[i + 2]) {
               return showWinner([i, i+1, i+2]);

        }
    }

    for (let i = 0; i < 3; i++) {
        if (placesArray[i] &&
            placesArray[i] === placesArray[i + 3] &&
            placesArray[i] === placesArray[i + 6]) {
                return showWinner([i, i+3, i+6]);

        }
    }

    if (placesArray[0] && placesArray[0] === placesArray[4] && placesArray[0] === placesArray[8]){
        return showWinner([0,4,8]);

    }

    if (placesArray[2] && placesArray[2] === placesArray[4] && placesArray[2] === placesArray[6]){
        return showWinner([2,4,6]);
 
    }

    return false;

}

function showWinner(winner){

    winner.forEach(p => {
        places[p].classList.toggle("show-winner", true);
    });

    return true;
}
