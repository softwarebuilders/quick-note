/*function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
    console.log('Name: ' + profile.getName());
    console.log('Image URL: ' + profile.getImageUrl());
    console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
    var idToken = googleUser.getAuthResponse().id_token;
    console.log('Token: ' + idToken)
    $.ajax({
        async: false,
        dataType: "json",
        url: "verify",
        method: "GET",
        data: {
            token: idToken
        },
        success: function (response) {
            alert(response);
        }
    });

}*/

function signIn() {
    gapi.load('auth2', function () {
        gapi.auth2.init({
            client_id: '94278606361-98l5spr2iakcb1gavm38t5vhdrqvo5o4.apps.googleusercontent.com'
        }).then(function (obj) {
            console.log('init OK');
            console.log(obj);
        }, function (obj) {
            console.log('init failed')
        });
        var auth2 = gapi.auth2.getAuthInstance();
        var signIn = auth2.signIn().then(function (obj) {
            var profile = obj.getBasicProfile();
            console.log('ID: ' + profile.getId());
            var idToken = obj.getAuthResponse().id_token;
            console.log('Token: ' + idToken);
            $.post('verify',{token: idToken}, function (obj, status, jqXHR) {
                console.log("object " + obj);
            });
        });
    });
}

function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        console.log('User signed out.');
    });
}