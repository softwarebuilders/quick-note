var QN = {
    SIGNED_IN: false,
    onSignInSuccessful: function () {
        this.SIGNED_IN = true;
    },
    onSignInFailed: function () {
        this.SIGNED_IN = false;
        console.log('Sign in failed')
    },
    onSignOutSuccessful: function () {
        this.SIGNED_IN = false;
    },
    onSignOutFailed: function () {
        console.log('Sign out failed')
    }
}