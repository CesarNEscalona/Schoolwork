/*
    This file contains all JavaScript for
    displaying breed information for cat selected.

    Author: Cesar Escalona
    File: Cat API
    Date: 6/9/2020
 */

window.onload = function() {
    loadBreeds();
    let button = document.querySelector("button");
    button.onclick = searchBreeds;
}


function loadBreeds() {
    fetch("https://api.thecatapi.com/v1/breeds?limit=67", {
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
            let data = json;

            // loop through all the items in the array
        for (let i = 0; i < data.length ; i++) {
            let option = document.createElement("option");

            option.textContent = data[i].name;

            let select = document.getElementsByTagName("select")[0];

            select.appendChild(option);
        }
    });
}


function searchBreeds() {
    let catSelect = document.getElementById("breeds");
    fetch("https://api.thecatapi.com/v1/breeds/search?q=" + catSelect.value, {
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
             let data = json;
             // get cats info...
            document.getElementById("name").textContent = data[0].name;
            document.getElementById("description").textContent = data[0].description;
            document.getElementById("origin").textContent = data[0].origin;
            document.getElementById("life-span").textContent = data[0].life_span + " years";

            let childFriendly = data[0].child_friendly;
            document.getElementById("child-friendly").textContent = data[0].child_friendly;

            let dogFriendly = data[0].dog_friendly;
            document.getElementById("dog-friendly").textContent = data[0].dog_friendly;

            let energyLevel = data[0].energy_level;
            document.getElementById("energy-level").textContent = data[0].energy_level;

            let socialNeeds = data[0].social_needs;
            document.getElementById("social-needs").textContent = data[0].social_needs;
            let txt = "wikipedia";
            let url = data[0].wikipedia_url;
            document.getElementById("wiki").innerHTML = txt.link(url);

            let id = data[0].id;

            childSwitch(childFriendly);
            dogSwitch(dogFriendly);
            energySwitch(energyLevel);
            socialSwitch(socialNeeds);
            loadPics(id);
        });
}


function loadPics(id) {
    fetch("https://api.thecatapi.com/v1/images/search?limit=10&breed_id=" + id, {
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
            let data = json;
            let bottom = document.getElementById("bottom");
            bottom.textContent = "";
            for (let i = 0; i <data.length ; i++) {
                let img = document.createElement("img");
                img.src = data[i].url;
                bottom.appendChild(img);
            }
        });
}


function childSwitch(childFriendly) {
    let text;
    switch (childFriendly) {
        case 1:
            text = "very unfriendly (" + childFriendly + ")";
            break;
        case 2:
            text = "unfriendly (" + childFriendly + ")";
            break;
        case 3:
            text = "indifferent (" + childFriendly + ")";
            break;
        case 4:
            text = "friendly (" + childFriendly + ")";
            break;
        case 5:
            text = "very friendly (" + childFriendly + ")";
            break;
        default:
            text = "Something wrong with Switch Statement";
            break;
    }
    document.getElementById("child-friendly").innerHTML = text;
}


function dogSwitch(dogFriendly) {
    let dogF;
    switch (dogFriendly) {
        case 1:
            dogF = "very unfriendly (" + dogFriendly + ")";
            break;
        case 2:
            dogF = "unfriendly (" + dogFriendly + ")";
            break;
        case 3:
            dogF = "indifferent (" + dogFriendly + ")";
            break;
        case 4:
            dogF = "friendly (" + dogFriendly + ")";
            break;
        case 5:
            dogF = "very friendly (" + dogFriendly + ")";
            break;
        default:
            dogF = "Something wrong with Switch Statement";
            break;
    }
    document.getElementById("dog-friendly").innerHTML = dogF;
}


function energySwitch(energyLevel) {
    let text;
    switch (energyLevel) {
        case 1:
            text = "like a sloth (" + energyLevel + ")";
            break;
        case 2:
            text = "slow moving (" + energyLevel + ")";
            break;
        case 3:
            text = "energetic (" + energyLevel + ")";
            break;
        case 4:
            text = "a ball of energy (" + energyLevel + ")";
            break;
        case 5:
            text = "bouncing off the walls (" + energyLevel + ")";
            break;
        default:
            text = "Something wrong with Switch Statement";
            break;
    }
    document.getElementById("energy-level").innerHTML = text;
}


function socialSwitch(socialNeeds) {
    let text;
    switch (socialNeeds) {
        case 1:
            text = "antisocial (" + socialNeeds + ")";
            break;
        case 2:
            text = "a loner (" + socialNeeds + ")";
            break;
        case 3:
            text = "indifferent (" + socialNeeds + ")";
            break;
        case 4:
            text = "needs friends (" + socialNeeds + ")";
            break;
        case 5:
            text = "very needy (" + socialNeeds + ")";
            break;
        default:
            text = "Something wrong with Switch Statement";
            break;
    }
    document.getElementById("social-needs").innerHTML = text;
}