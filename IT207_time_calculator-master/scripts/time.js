/*
    Cesar Escalona
    it-207 JavaScript
    04/10/2020
 */
"use strict"

let millis = new Date().getTime();
let seconds = millis / 1000;
let minutes = seconds / 60;
let hours = minutes / 60;
let days = hours / 24;
let years = days / 365; //fudge a bit here...

//round our numbers
millis = Math.round(millis);
seconds = Math.round(seconds);
minutes = Math.round(minutes);
hours = Math.round(hours);
days = Math.round(days);
years = Math.round(years);

//display them
let element = document.querySelector("div#millis span");
element.innerHTML = millis;
element = document.querySelector("div#seconds span");
element.innerHTML = seconds;
element = document.querySelector("div#minutes span");
element.innerHTML = minutes;
element = document.querySelector("div#hours span");
element.innerHTML = hours;
element = document.querySelector("div#days span");
element.innerHTML = days;
element = document.querySelector("div#years span");
element.innerHTML = years;