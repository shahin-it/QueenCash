$(function () {
    var logContainer = $("#log-container");
    logContainer.find('#login-form-link').click(function (e) {
        logContainer.find("#login-form").delay(100).fadeIn(100);
        logContainer.find("#register-form").fadeOut(100);
        logContainer.find('#register-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    logContainer.find('#register-form-link').click(function (e) {
        logContainer.find("#register-form").delay(100).fadeIn(100);
        logContainer.find("#login-form").fadeOut(100);
        logContainer.find('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});
