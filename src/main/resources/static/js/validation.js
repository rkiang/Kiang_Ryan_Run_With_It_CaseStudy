function pswdVisible() {
    var x = document.getElementById("password");
            var y = document.getElementById("inputPassword4");

    if (x.type  === "password") {
        x.type = "text";
        } else {
            x.type = "password";
        }
            if (y.type  === "password") {
                y.type = "text";
              } else {
                y.type = "password";
              }
 }