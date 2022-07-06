window.onload = function() {
    let textbox = document.getElementsByTagName("input")[0];
    textbox.onkeypress = function(event) {
        //stop the regular entry of a key in the textbox
        event.preventDefault();

        //retrieve the key that was pressed from the KeyEvent
        let key = event.key;
        let code = event.code;

        key = key.toLowerCase();
        textbox.value += key;
    };
};