
let number;
do {
    let number = prompt("Enter a number");
    number = parseInt(number);

}
while(Number.isNan(number));
alert(number + " is a number")