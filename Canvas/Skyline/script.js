/*
    Cesar Escalona
    05/04/2020
    JavaScript
    This program will generate a canvas of a skyline of buildings
    with windows in random locations
 */

//access the context of our canvas
let canvas = document.querySelector("canvas");
let context = canvas.getContext("2d");

// Constants(Magic numbers)
const WATER_HGT = 100;
const GROUND_HGT = 10;
const CVS_WIDTH = 600;
const CVS_HEIGHT = 400;
const BUILD_MIN_W = 20;
const BUILD_MAX_W = 80;
const BUILD_MIN_H = 50;
const BUILD_MAX_H = 150;
const FONT_OFFSET = 60;
const FONT_WIDTH = 100;
const WINDOW_SIZE = 5;
const NUM_BUILDINGS = 15;

// Call function
drawSky();

// Make sure to add NUM_Buildings here for loop
for(let i = 1; i <= NUM_BUILDINGS ; i++) {
    Seattle();
}

// Seattle Text top right
function Seattle() {
    context.beginPath();
    context.font = "60px serif";
    context.fillText("Seattle", CVS_WIDTH - 125, FONT_OFFSET, FONT_WIDTH);
    drawBuilding();
}

// Draw a Sky region on the Canvas
function drawSky() {
    context.beginPath();
    context.fillStyle = "#ffee00";
    context.fillStyle = "rgb(0,167,245)";
    context.fillRect(0, 0,CVS_WIDTH,CVS_HEIGHT);
}

// Draw Water on the Canvas
function drawWater() {
    context.beginPath();
    context.fillStyle = "rgb(4,6,125)";
    context.fillRect(0, 300,CVS_WIDTH,WATER_HGT);
}

// Draw a Ground on the Canvas
function drawGround() {
    context.beginPath();
    context.fillStyle = "rgb(0,0,0)";
    context.fillRect(0, 290,CVS_WIDTH,GROUND_HGT);
    drawWater();
}

// Draw a Building
function drawBuilding() {
    context.beginPath();
    let width = randomNum(BUILD_MIN_W, BUILD_MAX_W);
    let height = randomNum(BUILD_MIN_H, BUILD_MAX_H);
    let x = randomNum(25, CVS_WIDTH - 100);
    let y = 290 - height;
    context.fillStyle = "rgb(14,6,6)";
    context.fillRect(x, y,width,height);
    drawWindows(x, y, width);
    drawGround();
}

// Draw a window
function drawWindows(x, y, width) {
    context.beginPath();
    let buildingWindow = 5;
    let spacer = 5;
    let count  = width / (buildingWindow + spacer);
    // draw a number of windows
    windowX = x;

    for (let i = 1; i <= count; i++) {
        context.fillStyle = "white";
        context.fillRect(windowX + 5, y + 5, buildingWindow, buildingWindow);
        windowX += 10;
        windowY = y;
        for (let j = 1; j <= count; j++) {
            context.fillStyle = "white";
            context.fillRect(windowX - 5, windowY + 15, buildingWindow, buildingWindow);
            windowY += 10;
        }
    }
    context.fill;
}

// Random values
function randomNum(low, high) {
    return Math.floor(Math.random() * (high - low + 1)) + low;
}