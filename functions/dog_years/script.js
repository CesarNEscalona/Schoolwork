let dogYears= 7;
let humanYears = dogToHumanYears(dogYears);
console.log("Your dog is "+ humanYears + " in human years.");

function dogToHumanYears(years)
{
   let humanYears = 0;

   if(years <= 3)
   {
       humanYears = years + 10;
   }
   else
   {
       humanYears = 30;
       years -= 3;
       humanYears += (years * 7);
   }
   return humanYears;
}