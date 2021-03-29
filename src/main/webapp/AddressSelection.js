var citiesByState = {
    Tehran: ["Firozkooh","Damavand","Tehran","Varamin"],
    Isfahan: ["Najafabad","Kashan","Shahreza","Isfahan"],
    Alborz: ["Fardis","Mehrshahr","Nazarabad","Hashtgerd"]
}
function makeSubmenu(value) {
    if(value.length==0) document.getElementById("citySelect").innerHTML = "<option></option>";
    else {
        var citiesOptions = "";
        for(cityId in citiesByState[value]) {
            citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
        }
        document.getElementById("citySelect").innerHTML = citiesOptions;
    }
}
function displaySelected() { var country = document.getElementById("countrySelect").value;
    var city = document.getElementById("citySelect").value;
    alert(country+"\n"+city);
}
function originMakeSubmenu(value) {
    if(value.length==0) document.getElementById("originCity").innerHTML = "<option></option>";
    else {
        var citiesOptions = "";
        for(cityId in citiesByState[value]) {
            citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
        }
        document.getElementById("originCity").innerHTML = citiesOptions;
    }
}
function destinationMakeSubmenu(value) {
    if(value.length==0) document.getElementById("destinationCity").innerHTML = "<option></option>";
    else {
        var citiesOptions = "";
        for(cityId in citiesByState[value]) {
            citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
        }
        document.getElementById("destinationCity").innerHTML = citiesOptions;
    }
}
function resetSelection() {
    document.getElementById("countrySelect").selectedIndex = 0;
    document.getElementById("citySelect").selectedIndex = 0;
}