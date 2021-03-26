function validation() {
    var name =
        document.forms["RegForm"]["username"];
    var lastName =
        document.forms["RegForm"]["lastName"];
    var name =
        document.forms["RegForm"]["name"];
    var email =
        document.forms["RegForm"]["email"];
    var phone =
        document.forms["RegForm"]["mobileNumber"];
    var password =
        document.forms["RegForm"]["psw"];
    var address =
        document.forms["RegForm"]["Address"];

    var nameRegex = /^[a-zA-Z ]{2,30}$/;
    var phoneRegex = /^[0-9]{11}$/;
    var emailRegex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}$/;

    /*if (name.value == "") {
        window.alert("Please enter your name.");
        name.focus();
        return false;
    }

    if (address.value == "") {
        window.alert("Please enter your address.");
        address.focus();
        return false;
    }

    if (email.value == "") {
        window.alert(
            "Please enter a valid e-mail address.");
        email.focus();
        return false;
    }

    if (phone.value == "") {
        window.alert(
            "Please enter your telephone number.");
        phone.focus();
        return false;
    }

    if (password.value == "") {
        window.alert("Please enter your password");
        password.focus();
        return false;
    }*/
    if (!nameRegex.test(name.value)){
        window.alert("Wrong name format");
        return false;
    }
    if (!nameRegex.test(lastName.value)){
        window.alert("Wrong last name format");
        return false;
    }
     if (!phoneRegex.test(phone.value)){
            window.alert("Wrong phone number format");
            return false;
    }
    if (!emailRegex.test(email.value)){
            window.alert("Wrong email format");
            return false;
    }

    return true;
}



$(document).ready(function(){
    var a = (Math.ceil(Math.random()*9))+1;
    var b = (Math.ceil(Math.random()*9))+1;
    var queryText = a+" + "+b+"=";
    document.getElementById('queryString').innerHTML=queryText;
    var result = parseInt(a)+parseInt(b);
    document.getElementById('actualResult').value=result;
});

function _validate(){
    if(document.getElementById('actualResult').value != document.getElementById('result').value){
        alert("Summation is wrong ");
    }

}

