/*
    Cesar Escalona
    it-207 Working with Cat apis
    This program will grab information from the Cat Api and
    will display links to photos of British Long
    Haired cats.
 */

window.onload = function() {
    loadCat();
}

function loadCat() {
    fetch("https://api.thecatapi.com/v1/images/search?limit=10&breed_id=siam", {
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
            console.log(json);
            loadBslo(json);
        });
}

function loadBslo(images) {
    let result = document.getElementById("list");
    for (let i = 0; i < images.length ; i++) {
        let item = document.createElement("li");
        let link = document.createElement("a");

        link.textContent = images[i].url;
        link.setAttribute("href", images[i].url);

        item.appendChild(link);
        result.appendChild(item);
    }
}