const placeContainer = document.querySelector('.place-container');
const places = document.querySelectorAll('.place');
const playerContainer = document.querySelector('.player-container');

let actualPlayer = "Jugador 1";
let gameOver = false;

playerContainer.innerText = "Turno de " + actualPlayer;

places.forEach((place, i) => {
    place.addEventListener("click", () => {
        if (gameOver) return;

        place.innerText = actualPlayer === "Jugador 1" ? "X" : "O";

        if (isWinner()) {
            playerContainer.innerText = actualPlayer + " es el ganador.";
            gameOver = true;
            return;
        }

        actualPlayer = actualPlayer === "Jugador 1" ? "Jugador 2" : "Jugador 1";
        playerContainer.innerText = "Turno de " + actualPlayer;

    })
});

function isWinner() {
    const placesArray = Array.from(places).map(place => place.innerText);
    console.log(placesArray);

    for (let i = 0; i < 9; i += 3) {
        if (placesArray[i] &&
            placesArray[i] === placesArray[i + 1] &&
            placesArray[i] === placesArray[i + 2]) {
            return true;
        }
    }

    for (let i = 0; i < 3; i++) {
        if (placesArray[i] &&
            placesArray[i] === placesArray[i + 3] &&
            placesArray[i] === placesArray[i + 6]) {
            return true;
        }
    }

    return placesArray[0] && placesArray[0] === placesArray[4] && placesArray[0] === placesArray[8]
        || placesArray[2] && placesArray[2] === placesArray[4] && placesArray[2] === placesArray[6];

}