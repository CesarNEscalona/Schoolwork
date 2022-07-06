//won't run until the page is loaded!
window.onload = function() {
    let button = document.querySelector("button#submit");

    button.onfocus = function() {
        button.style.backgroundColor = "black";
        button.style.color = "white";
    }

    button.onblur = function() {
        button.style.backgroundColor = "";
        button.style.color = "";
    }
}

function buttonClicks()
{
    //add an event handler to each of our buttons
    let buttons = document.getElementsByTagName("button");
    for (let i = 0; i < buttons.length; i++)
    {
        let button = buttons[i];
        button.onclick = handleButtonClick;
    }
}

function handleButtonClick(event)
{
    //get the source of the event (the button clicked)
    let button = event.target;

    console.log(button.textContent);
}