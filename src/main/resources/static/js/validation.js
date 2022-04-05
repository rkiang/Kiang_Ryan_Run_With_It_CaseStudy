function pswdVisible() {
    var x = document.getElementById("inputPassword3");
//            var y = document.getElementById("password2");

    if (x.type  === "password") {
        x.type = "text";
        } else {
            x.type = "password";
        }
//            if (y.type  === "password") {
//                y.type = "text";
//              } else {
//                y.type = "password";
//              }
 }