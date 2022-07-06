let button = document.querySelector("button");
button.onclick = function(event) {
    //stop the form from submitting
    event.preventDefault();

    //get our DOM elements
    let diceArea = document.querySelector("section.dice-area");
    diceArea.innerHTML = ""; //clear child elements in the section

    let targetNumber = document.getElementById("target").value;
    targetNumber = parseInt(targetNumber);

    //write a loop that adds rolled dice until
    //the target number appears
    let randomNum = 0;
    while (randomNum !== targetNumber)
    {
        //generate a random number - [1, 6]
        randomNum = Math.floor(Math.random() * 6) + 1;

        //show the number on the page
        diceArea.innerHTML += "<img src='images/" + randomNum +
            ".png' alt='A dice roll'>";
    }
};