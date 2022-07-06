window.onload = function() {
    let button = document.querySelector("button");
    button.onclick = loadCat;

    loadCat();
}

function loadCat() {
    fetch("https://api.thecatapi.com/v1/images/search", {
        method: "GET",
        mode: "cors",
        headers: {
            "Content-Type": "application/json",
            "x-api-key": "fcc16ba8-01f7-4af5-9e69-7a0c711322c9"
        }
    })
    .then(function(response) {
            return response.json();
        })
    .then(function(json) {
            let data = json[0];
            let image = document.getElementById("portrait");
            image.setAttribute("src", data.url);
        });
}

