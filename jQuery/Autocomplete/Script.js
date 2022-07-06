
//popular programming languages
let languages = [
    "Javascript", "Java", "Python", "C#",
    "Cobalt", "Basic", "Ruby", "C",
    "C++", "Ada"
];

$(document).ready(function() {
    $("input#programming-languages").autocomplete({
        source: languages
    });
});