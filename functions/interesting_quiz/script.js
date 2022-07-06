let question1 = trueFalse("Does WA state have a state animal?");
let question2 = trueFalse("Does WA state have a capital building?");
let question3 = multipleChoice("What is the smallest country in the world?",
    "Italy", "Malta", "Vatican City", "Monaco");
let question4 = multipleChoice("Who said that 'Champagne should be dry, cold and free'?",
    "Charles Darwin", "Winston Churchill", "John Lennon", "Oliver Cromwell");

let quizArea = document.getElementById("quiz");
quizArea.innerHTML += question1;
quizArea.innerHTML += question2;
quizArea.innerHTML += question3;
quizArea.innerHTML += question4;

function trueFalse(description)
{
    let html = "<p>" + description + "</p>";
    html += "<ul><li>yes</li><li>no</li></ul>";

    return html;
}

function multipleChoice(description, op1, op2, op3, op4)
{
    let html = "<p>" + description + "</p>";
    html += "<ul>";

    //add the options
    html += "<li>" + op1 + "</li>";
    html += "<li>" + op2 + "</li>";
    html += "<li>" + op3 + "</li>";
    html += "<li>" + op4 + "</li>";

    html += "</ul>";

    return html;
}