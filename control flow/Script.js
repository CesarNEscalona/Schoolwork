let breakfast = prompt("What did you eat for breakfast");
let exercise = confirm("Did you exercise today?");

if (breakfast === "fruit")
{
    alert("You are wise");
}
else if(exercise)
{
    switch (breakfast)
    {
        case "cereal":
            alert("You are studious");
            break;

        case "pancakes":
            alert("You are watchful");
            break;

        case "eggs":
            alert("You are silly");
            break;

        default:
            alert("Do not click me!");
            break;
    }
}
else
{
    switch(breakfast)
    {
        case "cereal":
            alert("You are melodramatic");
            break;

        case "pancakes":
            alert("You are unwise");
            break;

        case "eggs":
            alert("You are brave");
            break;

        default:
            alert("I don't feel so good...");
            break;
    }
}