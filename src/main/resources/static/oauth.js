var google = {
    signIn: function () {
        gapi.load('auth2', function () {
            gapi.auth2.init({
                client_id: '94278606361-98l5spr2iakcb1gavm38t5vhdrqvo5o4.apps.googleusercontent.com'
            }).then(function (obj) {
                QN.SIGNED_IN = true;
                QN.onSignInSuccessful();
            }, function (obj) {
                QN.onSignInFailed();
            });
            var auth2 = gapi.auth2.getAuthInstance();
            var signIn = auth2.signIn().then(function (obj) {
                var idToken = obj.getAuthResponse().id_token;
                console.log('Token: ' + idToken);
                $.post('googleSignIn', {token: idToken}, function (obj, status, jqXHR) {
                    console.log("object " + obj);
                });
            });
        });
    },

    signOut: function () {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
            $.post('googleSignOut', {}, function (obj, status, jqXHR) {
                console.log("object " + obj);
            });
            console.log('User signed out.');
        });
    }
}

