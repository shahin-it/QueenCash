$(function () {
    var logContainer = $("#log-container");
    logContainer.find('#login-form-link').click(function (e) {
        logContainer.find("#login-form").delay(100).fadeIn(100);
        logContainer.find("#reset-form").fadeOut(100);
        logContainer.find('#reset-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
    logContainer.find('#reset-form-link, .forgot-password').click(function (e) {
        logContainer.find("#reset-form").delay(100).fadeIn(100);
        logContainer.find("#login-form").fadeOut(100);
        logContainer.find('#login-form-link').removeClass('active');
        $(this).addClass('active');
        e.preventDefault();
    });
});
