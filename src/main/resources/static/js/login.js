$(document).on("click", ".login", function(e) {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    e.preventDefault();
    let login = $('#email').val();
    let password = $('#password').val();

    $.ajax({
        type: "POST",
        url: "login-validation",
        data: {"email": login, "password": password},
        success: function (data) {
            console.log(data);
            if (data.success) {
                $(location).attr('href', data.url)
            } else {
                $('.error-message').text(data.message);
            }

        }
    })
});