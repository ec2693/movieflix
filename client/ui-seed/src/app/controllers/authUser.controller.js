(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('AuthUserController', AuthUserController);

    AuthUserController.$inject = ['userService', '$location'];

    function AuthUserController(userService, $location) {
        var authUserVm = this;

        authUserVm.authUser = authUser;

        init();

        function init() {
            console.log('in AddUserController');
        }

        function authUser() {
            userService
                .authUser(authUserVm.existingUser)
                .then(function(data) {
                    console.log(data);
                    authUserVm.user = data;
                    $location.path('/titles');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();/**
 * Created by Era on 8/15/16.
 */
