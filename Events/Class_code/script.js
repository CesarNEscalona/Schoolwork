// make sure to register events after the dom loads
window.onload = function() {
    let inputs = document.querySelectorAll("input, select");

    for (let i = 0; i < inputs.length; i++) {
        inputs[i].onfocus = gainFocus;
        inputs[i].onblur = loseFocus;
    }
}

// Responds to form elements gaining focus
function gainFocus(event) {
    let source = event.target;
    source.style.backgroundColor = "#21d96a";
}

// responds to form elements losing focus
function loseFocus(event) {
    let source = event.target;
    source.style.backgroundColor = "#e2e2e2";
}