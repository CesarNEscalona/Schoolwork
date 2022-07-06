/*
    Cesar Escalona
    5/28/2020
    JavaScript it-207
    This program will generate random colors for the boxes stores inside the flex box every time the
    button is clicked. This program will also save the colors generated into a table if the colored box is clicked.
 */

window.onload = function() {
    // when the window loads, let the button click generate colors for the divs
    let button = document.querySelector("button");
    button.onclick = generateColors;
}


// function for randomNum for colors
function randomNum(low, high)
{
    return Math.floor(Math.random() * (high - low + 1)) + low;
}


// create a function that walks through the boxes and applies a random color to each
function generateColors() {
    let square = document.getElementById("boxes"); // select the div that holds the boxes
    let box = square.children;   // select the 8 elements inside the div
    // write a loop that changes the colors around
    for (let i = 0; i < box.length ; i++) {
        // range needs to be within 0, 255
        let red = randomNum(0, 255);
        let green = randomNum(0, 255);
        let blue = randomNum(0, 255);
        box[i].style.backgroundColor = "rgb(" + red + "," + green + "," + blue + ")";
        // when you click on a box, it will save the color you clicked on to saveColor
        box[i].onclick = saveColor;
    }
}


// create a function that saves the colors into the table
function saveColor(event)
{
    //store the square clicked on
    let box = event.target;
    // create a new table row, for the table data(rgb value) and the table data(color)
    let tr = document.createElement("tr");
    let colorTd = document.createElement("td");
    let paintedTd = document.createElement("td");

    // textContent means we will take the rgb value and set it in the colorTd cell
    colorTd.textContent = box.style.backgroundColor;
    // take the paintedTd cell and set the color of it as the box background color
    paintedTd.style.backgroundColor = box.style.backgroundColor;

    // add the two rows of data to the table row value first then cell color
    tr.appendChild(colorTd);
    tr.appendChild(paintedTd);

    // add the table row to the table body as a new index
    let tbody = document.getElementsByTagName("tbody")[0];
    tbody.appendChild(tr);
}