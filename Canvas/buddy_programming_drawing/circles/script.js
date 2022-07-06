//access the context of our canvas
let canvas = document.querySelector("canvas");
let context = canvas.getContext("2d");

// should be using Constants == magic numbers.
const CIRCLE_MIN_RAD = 5;
const CIRCLE_MAX_RAD = 50;
const CNV_SIZE = 500;
const NUM_CIRCLES = 50;

// draw the box
background();

// loop the program 50 times for 50 cirles
for(let i = 1; i <= NUM_CIRCLES; i++) {
    randomCircle();

}
// background function
function background() {
    context.fillStyle = "#FFEE00";
    context.fillStyle = "rgb(30,239,208)";

    context.fillRect(0, 0, CNV_SIZE, CNV_SIZE);
}

// Produces random low and high values
function randomCircle() {
    context.beginPath();

    //pick a random x and y location for the circle
    //  between 0, 500
    let x = randomNum(CIRCLE_MAX_RAD, CNV_SIZE - CIRCLE_MAX_RAD);
    let y = randomNum(CIRCLE_MAX_RAD, CNV_SIZE - CIRCLE_MAX_RAD);
    let radius = randomNum(CIRCLE_MIN_RAD, CIRCLE_MAX_RAD);

    //choose random colors for the circles rgb
    let red = randomNum(0, 255);
    let green = randomNum(0, 255);
    let blue = randomNum(0, 255);

    context.strokeStyle = "black";
    // concatenate the colors to the fillstyle
    context.fillStyle =  "rgb(" + red + "," + green + "," + blue + ")";

    //draw the circle using - arc(x, y, radius, 0, 2 * Math.PI)
    context.arc(x, y, radius, 0, 2 * Math.PI);
    context.fill();
    context.stroke();
}
// Random values
function randomNum(low, high) {
    return Math.floor(Math.random() * (high - low + 1)) + low;
}