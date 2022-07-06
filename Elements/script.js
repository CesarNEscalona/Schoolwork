//won't run until the page is loaded!
window.onload = function() {
    let ul = document.querySelector("ul");

    console.log(ul);

    //try to avoid this...
    //ul.innerHTML += "<li>Abraham Lincoln</li>";

    //try to prefer this mechanism...
    let li = document.createElement("li");
    li.innerHTML = "Martin Luther King ";

    let anchor = document.createElement("a");
    anchor.innerHTML = "Learn More";
    anchor.setAttribute("href", "https://www.history.com/this-day-in-history/martin-luther-king-jr-born");

    li.appendChild(anchor);
    ul.appendChild(li);
};