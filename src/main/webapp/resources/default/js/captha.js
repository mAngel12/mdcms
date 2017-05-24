$(document).ready(function() {
    var n1 = Math.round(Math.random() * 4 + 1);
    var n2 = Math.round(Math.random() * 4 + 1);
    var result = n1 + n2;
    $("#operation").val(n1 + " + " + n2);
    document.getElementById("operation").innerHTML = n1 + " + " + n2 + " = ";
    $("#capthaButton").click(function() {
        if (result == $("#answer").val()) {
            alert("Ok! You are human! Now you can send message!");
            document.getElementById("add").removeAttribute("disabled");
            document.getElementById("capthaButton").setAttribute("disabled", "true");
            document.getElementById("answer").setAttribute("disabled", "true");
        }
    });
});