window.onload= function () {
    let button = document.getElementsByClassName("button")[0];
    button.onclick = clickButton;
}

function clickButton(event) {
    let radios = document.querySelectorAll("input[type='radio']");
    for (let i = 0; i < radios.length ; i++) {
        let radio = radios[i];
        if(radio.checked) {
            let para = document.getElementById("show-hobby");
            para.textContent = radio.value;
        }
    }

}