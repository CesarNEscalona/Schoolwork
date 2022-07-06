
// create a variable to hold special characters
let characters = "";
let SPACE = "&nbsp;"

for (let i = 33; i <= 1000; i++)
{
    let character = "&#" + i + ";" ;
    characters += character + SPACE;
}

// Display the characters
let content = document.getElementById("content");
content.innerHTML = characters;