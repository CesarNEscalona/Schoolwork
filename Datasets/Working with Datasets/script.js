/*
Cesar Escalona
It-207 Javascript
Assignment: Working with datasets
05/19/2020
This program will generate facts about police involved shootings. Data is from
Corgis website and this program will generate facts from that database.
*/

// import data from other js. file
console.log(data);

// write a loop that counts the number of elements in the array
let totalNum = 0;
for (let i = 0; i < data.length ; i++) {
    totalNum++;
}
document.getElementById("totalNum").innerHTML = totalNum;

// Write a loop that counts the number of times Wa is the state for all cases.
let stateMost = 0;
for (let i = 0; i < data.length; i++) {
    if(data[i].Incident.Location.State === "WA") {
        stateMost++;
    }
}
document.getElementById("stateMost").innerHTML = stateMost;

// Write a loop that counts the number of males or females shot, if neither === unknown
let maleShot = 0;
let femaleShot = 0;
let unknownShot = 0;
for (let i = 0; i < data.length ; i++) {
    if(data[i].Person.Gender === "Male"){
        maleShot++;
    }
    if(data[i].Person.Gender === "Female"){
        femaleShot++;
    }
    if(data[i].Person.Gender === "Unknown"){
        unknownShot++;
    }
}
if(maleShot > femaleShot && maleShot > unknownShot){
    console.log("Males were shot the most");
}
else if(unknownShot > maleShot && unknownShot > femaleShot) {
    console.log("Unknown were shot the most");
}
else if(femaleShot > unknownShot && femaleShot > maleShot){
    console.log("Females were shot the most");
}
let total = maleShot + femaleShot + unknownShot;
let mean = femaleShot / total;
let percent = mean * 100;
let p = percent.toFixed(1);

// print out the data on screen
document.getElementById("avgShot").innerHTML = p;

document.getElementById("malesShot").innerHTML = maleShot;

document.getElementById("femalesShot").innerHTML = femaleShot;

let difference = maleShot - femaleShot;
document.getElementById("difference").innerHTML = difference;

// background function
function backGround() {
    document.body.style.backgroundColor = "Black";
    document.body.style.backgroundImage = "url('https://ak.picdn.net/shutterstock/videos/26633170/thumb/10.jpg')";
    document.body.style.backgroundSize = "auto";
}

// Starter Script
//get access to our buttons
let previous = document.getElementById("previous");
let next = document.getElementById("next");

//the index of the current object shown
//on the web page
let index = 0;
display();

//responds to clicks of the "previous" button
previous.onclick = function(event) {
    index--;

    //make sure that index is never less than zero...
    if(index <= 0) {
        index = 0;
    }
    display();
}

//responds to clicks of the "next" button
next.onclick = function(event) {
    index++;

    //make sure that index is never greater than
    //array.length - 1
    if(index > data.length - 1) {
        index = data.length - 1;
    }
    display();
}

//shows the current record in the array of records
//at the position within the index variable
function display()
{
    // create a variable for the data at index 0
    let record = data[index];

    // get the suspect name
    document.getElementById("suspectName").innerHTML = record.Person.Name;

    // get the suspect age
    document.getElementById("suspectAge").innerHTML = record.Person.Age;

    // get the suspect race
    document.getElementById("suspectRace").innerHTML = record.Person.Race;

    // get the suspect gender
    document.getElementById("suspectGender").innerHTML = record.Person.Gender;

    // get the suspect weapon
    document.getElementById("suspectArmed").innerHTML = record.Factors.Armed;

    // get the manner in which the suspect died
    document.getElementById("suspectManner").innerHTML = record.Shooting.Manner;

    // get the suspect city location
    document.getElementById("suspectCity").innerHTML = record.Incident.Location.City;

    // get the suspect state location
    document.getElementById("suspectState").innerHTML = record.Incident.Location.State;

    // log it for record
    console.log(record);

    // add the background here
    backGround();
}