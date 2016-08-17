/**
 * Created by Era on 8/15/16.
 */
(function() {
    'use strict';

    angular
        .module('movieflix')
        .service('userService', userService);

    userService.$inject = ['$http', '$q','CONFIG'];

    function userService($http, $q, CONFIG) {
        var self = this;


        self.createUser = createUser;
        self.authUser = authUser;


        function createUser(user) {
            return $http.post(CONFIG.API_HOST + '/users', user)
                .then(successFn, errorFn);
        }

        function authUser(user) {
            return $http.post(CONFIG.API_HOST + '/users/auth/user', user)
                .then(successFn, errorFn);
        }


        function successFn(response) {
            return response.data; //RESOLVE
        }

        function errorFn(response) {
            return $q.reject(error.status); //REJECT
        }
    }
})();