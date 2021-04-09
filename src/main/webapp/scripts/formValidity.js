$(document).ready(function() {


    jQuery.validator.addMethod("lettersonly", function(value, element) {
        return this.optional(element) || /^[a-z]+$/i.test(value);
    }, "Letters only please");

    $.validator.addMethod("usernameAndPass", function(value, element) {
        return this.optional(element) ||  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/i.test(value);
    }, "Please enter at least 8 character");

    $.validator.addMethod("mobile", function(value, element) {
        return this.optional(element) ||  /^[0-9]{11}$/i.test(value);
    }, "Please enter at least 8 character");

    $("#RegForm").validate({
        errorClass: "error fail-alert",
        validClass: "valid success-alert",
        rules: {
            name1 : {
                required: true,
                minlength: 3,
                lettersonly : true
            },
            lastName1 : {
                required: true,
                minlength: 3,
                lettersonly : true
            },
            username1: {
                required: true,
                minlength: 8,
                usernameAndPass: true
            },
            psw1: {
                required: true,
                minlength: 8,
                usernameAndPass: true
            },
            email1: {
                required: true,
                email: true
            },
            customerStreet: {
                required: true
            },

            customerBlock: {
                required: true
            },
            citySelec: {
                required: true
            },
            province: {
                required: true
            },
            mobileNumber: {
                required: true,
                mobile : true
            },

        },
        messages : {
            name: {
                minlength: "Name should be at least 3 characters"
            },

            email1: {
                email: "The email should be in the format: abc@domain.tld"
            },
            lastName1 : {
                lastName1 : "Last name should be at leasr 3 character"
            },
            username1: {
                username1: "Last name should be at leasr 8 character"
            },
            psw1: {
                psw1 : "Last name should be at leasr 8 character"
            },
            customerStreet: {
                required: true
            },
            mobileNumber: {
                mobileNumber : "Include 11 digit"
            },


        }
    });
});