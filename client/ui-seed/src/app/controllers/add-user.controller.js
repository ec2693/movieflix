(function() {
    'use strict';

    angular
        .module('movieflix')
        .controller('AddUserController', AddUserController);

    AddUserController.$inject = ['userService', '$location'];

    function AddUserController(userService, $location) {
        var addUserVm = this;

        addUserVm.addUser = addUser;

        init();

        function init() {
            console.log('in AddUserController');
        }

        function addUser() {
            userService
                .createUser(addUserVm.newUser)
                .then(function(data) {
                    $location.path('/users/auth');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();/**
 * Created by Era on 8/15/16.
 */
