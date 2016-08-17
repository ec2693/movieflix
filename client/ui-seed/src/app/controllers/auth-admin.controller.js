(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('AuthAdminController', AuthAdminController);

    AuthAdminController.$inject = ['userService' ,'$location'];

    function AuthAdminController(userService,$location) {
        var authAdminVm = this;
        authAdminVm.authAdmin = authAdmin;

        init();

        function init() {
            console.log('in authAdminController');
        }

        function authAdmin() {
            console.log('in authAdmin');
            userService
                .authAdmin(authAdminVm.admin)
                .then(function(data) {
                    console.log(data);
                    $location.path('/titles');
                }, function(error) {
                    console.log(error);
                })
        }



    }
})();/**
 * Created by Era on 8/17/16.
 */
