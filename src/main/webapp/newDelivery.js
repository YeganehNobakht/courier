window.document.getElementById("noOptions").style.display = "block";
window.document.getElementById("allOptions").style.display = "none";
function changeOptions() {
    var form = window.document.getElementById("form");
    var docOption = window.document.getElementById("docOption");
    var nDocOption = window.document.getElementById("nDocOption");

    window.document.getElementById("noOptions").style.display = "none";

    if (form.radioButton1.checked) {
        nDocOption.style.display = "none";
        docOption.style.display = "non";
        docOption.selectedIndex = 0;
    } else if (form.radioButton2.checked) {
        docOption.style.display = "none";
        nDocOption.style.display = "block";
        nDocOption.selectedIndex = 0;
    }

}
window.document.getElementById("radioButton1").onclick = changeOptions;
window.document.getElementById("radioButton2").onclick = changeOptions;



function closeForm() {
    document.getElementById("myForm").style.display = "none";
}



function premium(){
    var weight =
        document.forms["form"]["weight"];
    console.log("function premium")
    var pricePerKg = 20000;
    var x3 = weight.value *pricePerKg;
    document.getElementById("premiumPriceResult").innerHTML = "price: "+x3;

}
function silver(){
    console.log("function s")
    var weight =
        document.forms["form"]["weight"];
    var pricePerKg = 10000;
    var x3 = weight.value*pricePerKg;
    document.getElementById("silverPriceResult").innerHTML = "price: "+x3;
}
function gold(){
    console.log("function g")
    var weight =
        document.forms["form"]["weight"];
    var pricePerKg = 14000;
    var x3 = weight.value*pricePerKg;
    document.getElementById("goldPriceResult").innerHTML = "price: "+x3;
}
var submit=false;
$("#form").submit(function(event){
    console.log("hello")
    if(submit == true) {
        event.preventDefault();
    }
});
function submit_true() {
    submit=true;
}
function submit_false() {
    submit=false;
}
function openForm(event) {
    document.getElementById("myForm").style.display = "block";
    premium();
    silver();
    gold();
    submit_true();
    //event.preventDefault();
}