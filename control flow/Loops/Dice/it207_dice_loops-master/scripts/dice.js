let button = document.querySelector("button");
button.onclick = function(event) {
    //stop the form from submitting
    event.preventDefault();

    //get our DOM elements
   let diceArea = document.querySelector("section.dice-area");
   diceArea.innerHTML= "";

   let targetNumber = document.getElementById("target").value;
   targetNumber = parseInt(targetNumber);

    //write a loop that adds rolled dice until
    //the target number appears
    let randomNum = 0;
    while (randomNum !== targetNumber)
    {
        randomNum = Math.floor(Math.random() * 6) + 1;

        diceArea.innerHTML += "<img src = 'images/" + randomNum +
            ".png' alt= 'A dice roll'>"

    }

};