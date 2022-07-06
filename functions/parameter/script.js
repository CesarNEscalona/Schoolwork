

function addAll()
{


    // no numbers?
    if (arguments.length === 0)
    {
        return undefined;
    }


    // sun
    let sum = 0;

    for(let i = 0; i < array.length; i++)
    {
        sum += arguments[i];
    }
    return sum;

}

console.log(addAll());
console.log(addAll(1,2,3));