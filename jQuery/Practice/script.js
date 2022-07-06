$(document).ready(function() {

    $("h1").text("Registration Form");

    $("button").click(function() {
        event.preventDefault();
        alert("User registered");
    });

    //set the class for elements that have been visited
    $("input, select").on({
        focus: function() {
            $(this).addClass("shine");
        },
        blur: function() {
            $(this).removeClass("shine");
        }
    });

    //add a darker border to form elements on mouse over
    $("input, select").hover(
        function(event) {
            $(this).css("border",
                "2px solid black");
        },
    function(event) {
        $(this).css("border",
            "1px solid grey");
    }
);
});

