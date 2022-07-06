"use strict"
let pay = 0;
let hours = 42;

//multiply pay * rate
pay = 16.5 * hours;

if (hours > 40) {
    //remove regular hours and get
    //overtime pay
    hours = hours - 40;
    pay = pay + (24.75 * hours);
}

//output the pay
console.log(pay);
