/*
    This file calculates the cost of theme park tickets when
    the user clicks the calculate button.
    Author: Cesar Escalona
    File: JavaScrpit
    Date: 04/18/2020
*/

let button = document.querySelector("button");
button.onclick = function(event) {
    //prevent the form from submitting
    event.preventDefault();

    //your code goes here...
    let adultCost = document.getElementById("AdCost");
    let childCost = document.getElementById("CdCost");
    let adultTix = document.getElementById("AdultTix");
    let childTix = document.getElementById("ChildTix");

    let adultCostValue = adultCost.value;
    let childCostValue = childCost.value;
    let adultTixValue = adultTix.value;
    let childTixValue = childTix.value;

    let AdultCost = parseFloat(adultCostValue);
    let ChildCost = parseFloat(childCostValue);
    let AdultTicket = parseInt(adultTixValue);
    let ChildTicket = parseInt(childTixValue);

    let Total = (ChildCost * ChildTicket) + (AdultCost * AdultTicket);
    document.getElementById("total").innerHTML = "Total cost for tickets: $" + Total + ".00";
}