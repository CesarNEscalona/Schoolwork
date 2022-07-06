window.onload = function() {
    let button = document.querySelector("button");
    button.onclick = data;
}

function data(event) {
    event.preventDefault();

    let title = document.getElementById("title");
    let length = document.getElementById("length");
    let rating = document.getElementById("rating");

    let genres = document.querySelectorAll("input[name='genre']");
    let clicked;
    for (let i = 0; i < genres.length; i++) {
        if (genres[i].checked) {
            clicked = genres[i];
            break;
        }
    }


    let summary = document.getElementById("summary");
    summary.innerHTML +=  "<p>Title: " + title.value + "</p>";

    summary.innerHTML +=  "<p>Genre: " + clicked.value + "</p>";

    summary.innerHTML +=  "<p>Length: " + length.value + "</p>";

    let rate;
    if (rating.value === "1") {
        rate = "star";
    }
    else {
        rate = "stars";
    }
    summary.innerHTML +=  "<p>Rating: " + rating.value + " " + rate +"</p>";
}